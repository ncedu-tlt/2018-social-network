<template>
    <v-dialog v-model="dialog" scrollable max-width="400px">
        <v-btn icon slot="activator">
            <v-icon>add</v-icon>
        </v-btn>
        <v-card>
            <v-card-title>Select friends</v-card-title>
            <v-divider/>
            <v-card-actions>
                <v-text-field
                    prepend-icon="search"
                    v-model="search"
                />
            </v-card-actions>
            <v-card-text style="height: 300px;">
                <template v-for="(friend, index) in filteredFriends">
                    <v-list :key="index">
                        <v-list-tile avatar>
                            <v-list-tile-avatar>
                                <img :src="friend.avatar">
                            </v-list-tile-avatar>
                            <v-list-tile-content>
                                <v-list-tile-sub-title v-html="friend.status"/>
                                <v-list-tile-title v-html="friend.name"/>
                            </v-list-tile-content>
                            <v-list-tile-action>
                                <v-checkbox v-model="selected" :value="friend"/>
                            </v-list-tile-action>
                        </v-list-tile>
                        <v-divider v-if="index + 1 < filteredFriends.length"/>
                    </v-list>
                </template>
            </v-card-text>
            <v-divider/>
            <v-card-actions>
                <v-btn flat @click.native="dialog=false">Close</v-btn>
                <v-btn
                    v-if="!exist"
                    color="primary"
                    flat
                    :disabled="selected.length === 0"
                    @click.native="createChat">Invite</v-btn>
                <v-btn v-else color="primary" flat @click.native="openChat">
                    Open
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
            selected: [],
            dialog: false,
            exist: false,
            selectedLogin: []
        };
    },
    computed: {
        ...mapState('friends', [
            'friends'
        ]),
        ...mapGetters('chats', [
            'getChatByLogin'
        ]),
        filteredFriends() {
            return this.friends.filter(friend => {
                return friend.name.toLowerCase().includes(this.search.toLowerCase());
            });
        }
    },
    watch: {
        selected: function () {
            this.selectedLogin = this.selected.map(p => p.login);
            if (this.selected.length === 1) {
                this.exist = this.getChatByLogin(this.selectedLogin.toString()).length === 1;
            } else {
                this.exist = false;
            }
        },
        dialog: function () {
            if (!this.dialog) {
                this.selected = [];
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
            let newChat = await this.addChat(this.selected);
            this.dialog = false;
            this.$router.push(`/chat/${newChat.id}`);
        },
        openChat() {
            let chatId = this.getChatByLogin(this.selectedLogin).map(chat => chat.id);
            this.dialog = false;
            this.$router.push(`/chat/${chatId}`);
        }
    }
};
</script>
