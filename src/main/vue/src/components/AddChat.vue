<template>
    <v-dialog v-model="dialog" scrollable max-width="400px">
        <v-btn icon slot="activator">
            <v-icon>add</v-icon>
        </v-btn>
        <v-card>
            <v-card-title>{{ $t('friend.select') }}</v-card-title>
            <v-divider/>
            <v-card-actions>
                <v-text-field
                    prepend-icon="search"
                    v-model="search"
                />
            </v-card-actions>
            <v-card-text>
                <template v-for="(friend, index) in filteredFriends">
                    <v-list :key="friend.id">
                        <v-list-tile avatar>
                            <v-list-tile-avatar>
                                <img :src="friend.avatar">
                            </v-list-tile-avatar>
                            <v-list-tile-content>
                                <v-list-tile-sub-title>{{ friend.online? $t('friend.status.online'):$t('friend.status.offline') }}</v-list-tile-sub-title>
                                <v-list-tile-title v-html="friend.name"/>
                            </v-list-tile-content>
                            <v-list-tile-action>
                                <v-checkbox v-model="selectedFriends" :value="friend"/>
                            </v-list-tile-action>
                        </v-list-tile>
                        <v-divider v-if="index + 1 < filteredFriends.length"/>
                    </v-list>
                </template>
            </v-card-text>
            <v-divider/>
            <v-card-actions>
                <v-btn flat @click.native="dialog=false">{{ $t('dialog.close') }}</v-btn>
                <v-btn
                    v-if="!exist"
                    color="primary"
                    flat
                    :disabled="selectedFriends.length === 0"
                    @click.native="createChat">{{ $t('dialog.invite') }}</v-btn>
                <v-btn v-else color="primary" flat @click.native="openChat">
                    {{ $t('dialog.open') }}
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
import { mapActions, mapGetters, mapState } from 'vuex';

export default {
    name: 'AddChat',
    data: function () {
        return {
            search: '',
            selectedFriends: [],
            dialog: false,
            exist: false,
            selectedId: []
        };
    },
    computed: {
        ...mapState('friends', [
            'friends'
        ]),
        ...mapState('auth', [
            'userId'
        ]),
        ...mapGetters('chats', [
            'getChatsByParticipantId'
        ]),
        filteredFriends() {
            return this.friends.filter(friend => {
                return friend.name.toLowerCase().includes(this.search.toLowerCase());
            });
        }
    },
    watch: {
        selectedFriends: function () {
            this.selectedId = this.selectedFriends.map(friend => friend.id);
            if (this.selectedId.length === 1) {
                this.selectedId.push(parseInt(this.userId));
                this.exist = this.getChatsByParticipantId(this.selectedId).length >= 1;
            } else {
                this.exist = false;
            }
        },
        dialog: function () {
            if (!this.dialog) {
                this.selectedFriends = [];
            }
        }
    },
    mounted() {
        this.updateFriends();
    },
    methods: {
        ...mapActions('friends', [
            'updateFriends'
        ]),
        ...mapActions('chats', [
            'addChat'
        ]),
        async createChat() {
            let newChat = await this.addChat(this.selectedFriends);
            this.dialog = false;
            this.$router.push(`/chat/${newChat.id}`);
        },
        openChat() {
            let chatId = this.getChatsByParticipantId(this.selectedId)[0][1];
            this.dialog = false;
            this.$router.push(`/chat/${chatId}`);
        }
    }
};
</script>
