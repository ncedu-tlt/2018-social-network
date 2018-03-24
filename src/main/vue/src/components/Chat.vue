<template>
    <v-container>
        <ul>
            <li v-for="message in messages" :key="message.name + message.text">
                <b>{{ message.name }}</b> {{ message.text }}
            </li>
        </ul>
        <v-text-field v-model="text" @keyup.enter="sendMessage"/>
        <v-btn @click="sendMessage">Send</v-btn>
    </v-container>
</template>

<script>
import chatClient from '@/api/ws/chat.ws.api';

export default {
    name: 'Chat',
    data: () => ({
        text: ''
    }),
    computed: {
        messages() {
            return this.$store.state.chat.messages;
        }
    },
    mounted() {
        chatClient.connect();
    },
    beforeDestroy() {
        chatClient.disconnect();
    },
    methods: {
        sendMessage() {
            chatClient.sendMessage(this.text);
            this.text = '';
        }
    }
};
</script>
