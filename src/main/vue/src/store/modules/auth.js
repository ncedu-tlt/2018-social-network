import { isAuthorized, logout } from '@/api/rest/user.api';

const state = {
    authed: localStorage.getItem('authed')
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuthCheck(state, authCheckValue) {
        state.authed = authCheckValue;
    }
};

/**
 * Actions serves the same purpose as mutations with two differences:
 * 1. Instead of modifying the state, they just commit mutations.
 * 2. Actions can be asynchronous.
 */
const actions = {
    async checkAuth({ commit }) {
        // Call some API in order to get current value
        const response = await isAuthorized();
        localStorage.setItem('authed', response.data);
        commit('setAuthCheck', response.data);
    },
    async logout({ dispatch }) {
        await logout();
        dispatch('checkAuth');
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
