import { getCurrentUser, isAuthorized, logout } from '@/api/rest/user.api';

const state = {
    authed: JSON.parse(localStorage.getItem('authed')),
    userName: localStorage.getItem('userName')
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuthCheck(state, authCheckValue) {
        state.authed = JSON.parse(authCheckValue);
    },
    setUserName(state, name) {
        state.userName = name;
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
    async getCurrentUser({ commit }) {
        const response = await getCurrentUser();
        localStorage.setItem('userName', response.data.name);
        commit('setUserName', response.data.name);
    },
    async logout({ commit }) {
        await logout();
        localStorage.clear();
        commit('setAuthCheck', false);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
