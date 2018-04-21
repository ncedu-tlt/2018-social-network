<template>
    <v-container>
        <v-toolbar color="white" dense>
            <v-text-field
                prepend-icon="search"
                v-model="search"
            />
            <AddChat/>
        </v-toolbar>
        <v-card>
            <v-list
                two-line
                style="max-height: 450px"
                class="scroll-y">
                <template v-for="(chat, index, key) in filteredChats">
                    <v-list-tile avatar :key="key" @click="$router.push(`/chat/${chat.id}`)">
                        <v-list-tile-avatar>
                            <img :src="chat.avatar">
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title v-html="chat.name"/>
                            <v-list-tile-sub-title v-html="chat.previewMsg"/>
                        </v-list-tile-content>
                        <v-list-tile-action-text>{{ chat.dateMsg }}</v-list-tile-action-text>
                    </v-list-tile>
                    <v-divider v-if="index + 1 < filteredChats.length" :key="index"/>
                </template>
            </v-list>
        </v-card>
    </v-container>
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
