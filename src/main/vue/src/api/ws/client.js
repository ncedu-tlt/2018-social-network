import SockJS from 'sockjs-client';
import {over} from 'webstomp-client';
import router from '@/router';

const WS_ENDPOINT = '/ws';

let stompClient;

export default {

    /**
     * Establishing WebSocket connection, if it's not established yet.
     * @param {Object=} headers Connection headers.
     * @returns {Promise<void>} Promise, that resolves when connection is established.
     */
    connect(headers) {
        return new Promise((resolve, reject) => {
            if (stompClient) {
                resolve();
                return;
            }

            const socket = new SockJS(WS_ENDPOINT);
            stompClient = over(socket);
            stompClient.connect({},
                () => resolve(),
                frame => {
                    reject(new Error('Connection error'));
                    if (frame.code === 1002) {
                        router.push('/auth');
                    }
                }
            );
        });
    },

    /**
     * Disconnects from the WebSocket endpoint.
     * @returns {Promise<void>} Promise, that resolves when connection is shut down.
     */
    disconnect() {
        return new Promise(resolve => {
            if (!stompClient) {
                resolve();
                return;
            }
            stompClient.disconnect(() => resolve());
        });
    },

    /**
     * Sends a message to the server.
     * @param {string} destination Destination endpoint.
     * @param {Object=} payload Message payload.
     * @param {Object=} headers Message headers.
     */
    send(destination, payload, headers) {
        const body = payload instanceof String ? payload : JSON.stringify(payload);
        stompClient.send(destination, body, headers);
    },

    /**
     * Registers callback for the specified topic.
     * @param {string} topic
     * @param {SubscriptionCallback} callback
     * @param {Object=} headers
     * @returns {Subscription} Subscription.
     */
    subscribe(topic, callback, headers) {
        return stompClient.subscribe(topic, frame => {
            const payload = frame.body ? JSON.parse(frame.body) : null;
            callback(payload);
        }, headers);
    },

    /**
     * Cancels subscription by it's ID.
     * Tip: The recommended way of cancelling the subscription is to call "unsubscribe" directly on Subscription object.
     * @param {number} id Subscription ID.
     * @param {Object=} headers Headers.
     */
    unsubscribe(id, headers) {
        stompClient.unsubscribe(id, headers);
    }

};

/**
 * Subscription callback.
 * @callback SubscriptionCallback
 * @param {Object} payload Message payload.
 */

/**
 * Subscription.
 * @typedef {Object} Subscription
 * @property {number} id Unique subscription ID.
 * @property {UnsubscribeFunction} unsubscribe Cancels subscription.
 */

/**
 * Cancels subscription.
 * @typedef {Function} UnsubscribeFunction
 * @param {Object=} headers Headers.
 */
