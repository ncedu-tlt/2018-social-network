import client from '@/api/ws/client';
import store from '@/store';

let subscriptions;
let clientsCount = 0;

export default {

    /**
     * Initiates WebSocket connection and registers all chat specific subscriptions.
     * @returns {Promise<void>} Promise, that resolves when connection is established.
     */
    async connect() {
        clientsCount++;
        if (clientsCount > 1) return;
        await client.connect();
        subscriptions = [
            client.subscribe('/topic/chat/message', message => store.commit('chat/addMessage', message))
        ];
    },

    /**
     * Cancels all chat specific subscriptions.
     */
    disconnect() {
        clientsCount--;
        if (clientsCount === 0) {
            subscriptions.forEach(subscription => subscription.unsubscribe());
        }
    },

    /**
     * Sends the message to the server.
     * @param {string} message Message text.
     */
    sendMessage(message) {
        client.send('/app/chat/message', { text: message });
    }
};
