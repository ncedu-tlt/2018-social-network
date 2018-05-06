<template>
    <v-card tile height="100%">
        <div v-if="chatId" class="chat-body">
            <v-toolbar color="white" card dense>
                <v-toolbar-title class="chat-title primary--text text--lighten-2">
                    {{ chat.type === 'dialog' ?
                        $t('chat.title') + chat.name :
                        chat.name
                    }}
                </v-toolbar-title>
                <v-spacer/>
                <v-btn icon>
                    <v-icon>settings</v-icon>
                </v-btn>
            </v-toolbar>
            <v-divider/>

            <v-list two-line>
                <virtual-list :size="60" :remain="6" :bench="5">
                    <template v-for="message of chat.messages">
                        <v-list-tile avatar :key="message.id">
                            <v-list-tile-avatar>
                                <img :src="getUserById(message.fromId).avatar">
                            </v-list-tile-avatar>
                            <v-list-tile-content>
                                <v-list-tile-action-text>{{ $d(message.dateMsg, 'long') }}</v-list-tile-action-text>
                                <v-list-tile-sub-title v-html="getUserById(message.fromId).name"/>
                                <v-list-tile-title v-html="message.body"/>
                            </v-list-tile-content>
                        </v-list-tile>
                    </template>
                </virtual-list>
            </v-list>
            <v-card-actions>
                <v-layout class="chat-actions" align-end justify-space-around>
                    <v-flex>
                        <v-btn icon><v-icon>attach_file</v-icon></v-btn>
                    </v-flex>
                    <v-flex xs10>
                        <v-text-field
                            :label="$t('chat.label')"
                            class="chat-textarea"
                            multi-line
                            no-resize
                            rows="2"
                            autofocus
                            full-width
                            clearable
                            v-model="newMsg"
                            @keyup.enter="addMessageNClear"
                            :rules="[(v) => v.length <= 150 || $t('chat.errors.max')]"
                            :counter="150"
                            v-validate="{ required: true, max: 150 }"
                        />
                    </v-flex>
                    <v-flex>
                        <v-btn icon @click="addMessageNClear"><v-icon>send</v-icon></v-btn>
                    </v-flex>
                </v-layout>
            </v-card-actions>
        </div>
        <v-layout v-else fill-height>
            <v-flex d-flex xs12 align-center text-xs-center>
                <v-card flat>
                    <v-icon x-large>chat</v-icon>
                    <v-card-text>{{ $t('chat.welcome') }}</v-card-text>
                </v-card>
            </v-flex>
        </v-layout>
    </v-card>
</template>
<script>
import virtualList from 'vue-virtual-scroll-list';
import { mapActions, mapGetters } from 'vuex';

export default {
    name: 'Chat',
    components: { 'virtual-list': virtualList },
    props: {
        chatId: {
            type: String,
            required: false,
            default: ''
        }
    },
    data: function () {
        return {
            chat: {},
            newMsg: ''
        };
    },
    computed: {
        ...mapGetters({
            getChatById: 'chats/getChatById',
            getUserById: 'friends/getUserById'
        })
    },
    async beforeMount() {
        if (this.chatId !== '') {
            this.chat = await this.getChatById(this.chatId);
        }
    },
    async beforeUpdate() {
        if (this.chatId !== '') {
            this.chat = await this.getChatById(this.chatId);
        }
    },
    methods: {
        ...mapActions('chats', [
            'addMessage'
        ]),
        addMessageNClear() {
            this.$validator.validateAll().then((result) => {
                if (result) {
                    let safeMsg = this.newMsg.replace(/<[^>]*>/, '&tag');
                    this.addMessage(
                        {
                            chat: this.chat,
                            newMsg: safeMsg
                        });
                    this.newMsg = '';
                    this.$validator.reset();
                }
            });
        }
    }
};
</script>
<style scoped>
    .chat-title{
        font: normal 1.2em Tahoma, sans-serif;
    }
    .chat-body{
        height: 100%;
    }
    .chat-textarea{
        height: 5em;
        border: 1px solid rgba(0,0,0,.12);
    }
</style>
