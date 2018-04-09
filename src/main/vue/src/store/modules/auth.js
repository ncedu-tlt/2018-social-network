import { getCurrentUser, logout } from '@/api/rest/user.api';

const state = {
    userName: localStorage.getItem('userName')
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuth(state, userName) {
        state.userName = userName;
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
        const authResponse = await getCurrentUser();
        if (authResponse.data) {
            localStorage.setItem('userName', authResponse.data.login);
            commit('setAuth', authResponse.data.login);
        } else {
            localStorage.clear();
            commit('setAuth', null);
        }
    },
    async logout({ commit }) {
        await logout();
        localStorage.clear();
        commit('setAuth', null);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
