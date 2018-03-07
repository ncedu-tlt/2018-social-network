import { isAuthorized, logout } from '@/api/rest/user.api';
import router from '@/router';

const state = {
    authCheck: Boolean
};

/**
 * Getters are used when we need some computed values based on the storage.
 */
const getters = {
    getAuthCheck: state => state.authCheck
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    mutateAuthCheck(state, authCheckValue) {
        state.authCheck = authCheckValue;
    }
};

/**
 * Actions serves the same purpose as mutations with two differences:
 * 1. Instead of modifying the state, they just commit mutations.
 * 2. Actions can be asynchronous.
 */
const actions = {
    async actionAuthCheck({ commit }, authCheckValue) {
        // Call some API in order to get current value
        const response = await isAuthorized();
        authCheckValue = response.data;
        commit('mutateAuthCheck', authCheckValue);
    },
    async actionLogout() {
        await logout();
        router.push('/');
    }
};

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
};
