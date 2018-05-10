import { getCurrentUser, logout } from '@/api/rest/user.api';
import { getSettings } from '@/api/rest/settings.api';
import index from '../../i18n/index';
const state = {
    userName: localStorage.getItem('userName'),
    removeUser: false
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuth(state, userName) {
        state.userName = userName;
    },
    setRemove(state) {
        state.removeUser = true;
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

            const settingsResponse = await getSettings();
            const language = settingsResponse.data.settingUnits.filter(language => language.settingsId.name === 'settings.language');
            if (language[0].value) {
                index.locale = language[0].value;
                localStorage.setItem('language', language[0].value);
            }
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
