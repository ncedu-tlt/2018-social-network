import { isAuthorized, logout } from '@/api/rest/user.api';

const state = {
    authed: localStorage.getItem('authed')
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuthCheck(state, authed) {
        state.authed = authed;
    }
};

/**
 * Actions serves the same purpose as mutations with two differences:
 * 1. Instead of modifying the state, they just commit mutations.
 * 2. Actions can be asynchronous.
 */
const actions = {
    async checkAuth({ commit, dispatch }) {
        // Call some API in order to get current value
        const authResponse = await isAuthorized();
        if (authResponse.data.name != null) {
            localStorage.setItem('authed', authResponse.data.name);
            commit('setAuthCheck', authResponse.data.name);
        }
    },
    async logout({ commit }) {
        await logout();
        localStorage.clear();
        commit('setAuthCheck', null);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
