<template>
    <v-container v-if="id">
        <div v-if="$vuetify.breakpoint.smAndDown">
            <v-layout row>
                <v-flex md12>
                    <Chat :chat-id="id"/>
                </v-flex>
            </v-layout>
        </div>
        <div v-else>
            <v-layout row>
                <v-flex md4>
                    <ChatList/>
                </v-flex>
                <v-flex md8>
                    <Chat :chat-id="id"/>
                </v-flex>
            </v-layout>
        </div>
    </v-container>
    <v-container v-else>
        <div v-if="$vuetify.breakpoint.smAndDown">
            <v-layout row>
                <v-flex md12>
                    <ChatList/>
                </v-flex>
            </v-layout>
        </div>
        <div v-else>
            <v-layout row>
                <v-flex md4>
                    <ChatList/>
                </v-flex>
                <v-flex md8 text-xs-right>
                    <Chat :chat-id="id"/>
                </v-flex>
            </v-layout>
        </div>
    </v-container>
</template>

<script>
import ChatList from './ChatList';
import Chat from './Chat';

export default {
    name: 'ChatPage',
    components: {
        ChatList,
        Chat
    },
    props: {
        id: {
            type: String,
            required: false,
            default: ''
        }
    }
};
</script>
