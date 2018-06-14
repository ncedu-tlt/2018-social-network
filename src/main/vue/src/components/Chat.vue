<template>
    <v-card tile height="100%">
        <div v-if="chat" class="chat-body">
            <v-toolbar color="white" card dense>
                <v-toolbar-title class="subheading primary--text text--lighten-2">
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
            <div>
                <v-divider/>
            </div>
            <div v-resize="onResize" class="content" ref="content">
                <v-list two-line>
                    <virtual-list :size="size" :remain="remain" :start="start" :offset="offset">
                        <template v-for="message of chat.messages">
                            <div v-if="userId == message.fromId" :key="message.id">
                                <v-list-tile avatar>
                                    <v-list-tile-content>
                                        <v-list-tile-sub-title class="caption your-message">{{ $d(message.dateMsg, 'long') }}</v-list-tile-sub-title>
                                        <v-list-tile-sub-title class="your-message" v-html="getParticipantById(message.fromId).name"/>
                                        <v-list-tile-title class="your-message" v-html="message.body"/>
                                    </v-list-tile-content>
                                    <v-list-tile-avatar>
                                        <img :src="getParticipantById(message.fromId).imagePath">
                                    </v-list-tile-avatar>
                                </v-list-tile>
                            </div>
                            <div v-else :key="message.id">
                                <v-list-tile avatar :key="message.id">
                                    <v-list-tile-avatar>
                                        <img :src="getParticipantById(message.fromId).imagePath">
                                    </v-list-tile-avatar>
                                    <v-list-tile-content>
                                        <v-list-tile-sub-title class="caption">{{ $d(message.dateMsg, 'long') }}</v-list-tile-sub-title>
                                        <v-list-tile-sub-title v-html="getParticipantById(message.fromId).name"/>
                                        <v-list-tile-title v-html="message.body"/>
                                    </v-list-tile-content>
                                </v-list-tile>
                            </div>
                        </template>
                    </virtual-list>
                </v-list>
            </div>
            <v-card-actions>
                <v-layout row align-end>
                    <v-flex>
                        <v-btn icon><v-icon>attach_file</v-icon></v-btn>
                        <v-btn v-if="innerWidth <= 350" icon @click="addMessageNClear"><v-icon>send</v-icon></v-btn>
                    </v-flex>
                    <v-flex xs12>
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
                            @keypress.enter.prevent="addMessageNClear"
                            v-validate="{ required: true }"
                        />
                    </v-flex>
                    <v-flex v-if="innerWidth > 350">
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
import { mapActions, mapGetters, mapState } from 'vuex';

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
            chat: null,
            newMsg: '',
            selfId: '',
            start: 0,
            offset: 0,
            size: 100,
            remain: 4,
            innerWidth: innerWidth
        };
    },
    computed: {
        ...mapGetters({
            getChatById: 'chats/getChatById',
            getParticipantById: 'chats/getParticipantById'
        }),
        ...mapState('auth', [
            'userId'
        ])
    },
    watch: {
        chatId: async function () {
            if (this.chatId === '') this.chat = null;
            else {
                await this.updateChatData();
            }
        }
    },
    async mounted() {
        await this.updateChatData();
    },
    async updated() {
        if (this.chat) {
            this.offset = this.chat.messages.length * 100;
        }
    },
    methods: {
        ...mapActions('chats', [
            'addMessage',
            'updateParticipants'
        ]),
        onResize() {
            this.remain = Math.round(this.$refs.content.clientHeight / this.size);
        },
        async updateChatData() {
            if (this.chatId !== '') {
                this.chat = await this.getChatById(this.chatId);
                if (this.chat) await this.updateParticipants(this.chat.participants);
            }
        },
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
                    this.updateChatData();
                }
            });
        }
    }
};
</script>
<style scoped>
    .chat-textarea{
        height: 5em;
        border: 1px solid rgba(0,0,0,.12);
    }
    .chat-body{
        display: flex;
        flex-direction: column;
        height: 100%;
    }
    .content{
        flex-direction: column;
    }
    .layout{
        width: 100%;
    }
    .your-message{
        text-align: end;
    }
</style>
