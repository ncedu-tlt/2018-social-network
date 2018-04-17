<template>
    <v-container>
        <v-layout row>
            <v-flex md4 :class="{'hidden-sm-and-down': id}">
                <ChatList/>
            </v-flex>
            <v-flex md8 text-xs-right :class="{'hidden-sm-and-down': !id}">
                <Chat :chat-id="id"/>
            </v-flex>
        </v-layout>
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

<style scoped>

</style>
