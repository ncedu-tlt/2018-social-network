<template>
    <v-card height="100%">
        <v-toolbar color="white" card dense>
            <v-text-field
                prepend-icon="search"
                v-model="search"
            />
            <AddChat/>
        </v-toolbar>
        <v-list class="scroll-y" two-line>
            <template v-for="(chat, index) in filteredChats">
                <v-list-tile avatar :key="chat.id" @click="$router.push(`/chat/${chat.id}`)">
                    <v-list-tile-avatar>
                        <img :src="chat.avatar">
                    </v-list-tile-avatar>
                    <v-list-tile-content>
                        <v-list-tile-sub-title>{{ $d(chat.dateMsg, 'long') }}</v-list-tile-sub-title>
                        <v-list-tile-title v-html="chat.name"/>
                        <v-list-tile-action-text v-html="chat.previewMsg"/>
                    </v-list-tile-content>
                </v-list-tile>
                <!-- eslint-disable-next-line vue/valid-v-for -->
                <v-divider v-if="index + 1 < filteredChats.length"/>
            </template>
        </v-list>
    </v-card>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import AddChat from './AddChat';

export default {
    name: 'ChatList',
    components: {
        AddChat
    },
    data() {
        return {
            search: ''
        };
    },
    computed: {
        ...mapState('chats', [
            'chats'
        ]),
        filteredChats() {
            return this.chats.filter(chat => {
                return chat.name.toLowerCase().includes(this.search.toLowerCase());
            });
        }
    },
    mounted() {
        this.updateChats();
    },
    methods: {
        ...mapActions('chats', [
            'updateChats'
        ])
    }
};
</script>
<style scoped>
    .scroll-y{
        max-height: calc(100% - 50px);
    }
</style>
