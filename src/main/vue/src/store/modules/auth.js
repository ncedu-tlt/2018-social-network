import { isAuthorized, logout } from '@/api/rest/user.api';
import router from '@/router';

const state = {
    isAuthed: false
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuthCheck(state, authCheckValue) {
        state.isAuthed = authCheckValue;
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
        commit('setAuthCheck', response.data);
    },
    async logout() {
        await logout();
        router.push('/');
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
