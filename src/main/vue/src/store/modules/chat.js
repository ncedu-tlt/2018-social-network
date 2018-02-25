// It's an example store module.
// TODO: Remove, when the project build will start.

/**
 * State presents the data of our app.
 */
const state = {
    messages: []
};

/**
 * Getters are used when we need some computed values based on the storage.
 */
const getters = {
    messagesCount: state => state.messages.length
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    addMessage(state, message) {
        state.messages.push(message);
    }
};

/**
 * Actions serves the same purpose as mutations with two differences:
 * 1. Instead of modifying the state, they just commit mutations.
 * 2. Actions can be asynchronous.
 */
const actions = {
    sendMessage({ commit }, message) {
        // Call some API in order to send a message
        commit('addMessage', message);
    }
};

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
};
