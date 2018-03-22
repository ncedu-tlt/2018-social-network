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
    setAuthCheck(state, authed) {
        state.authed = authed;
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
    async checkAuth({ commit, dispatch }) {
        // Call some API in order to get current value
        const authResponse = await isAuthorized();
        localStorage.setItem('authed', authResponse.data);
        commit('setAuthCheck', authResponse.data);

        if (authResponse.data) {
            const userResponse = await getCurrentUser();
            localStorage.setItem('userName', userResponse.data.name);
            commit('setUserName', userResponse.data.name);
        } else {
            commit('setUserName', null);
        }
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
