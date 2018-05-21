import { getCurrentUser, logout } from '@/api/rest/user.api';
import { getSettings } from '@/api/rest/settings.api';
import index from '../../i18n/index';
const state = {
    userName: localStorage.getItem('userName'),
    userId: localStorage.getItem('userId'),
    userAvatar: localStorage.getItem('userAvatar'),
    userRealName: localStorage.getItem('userRealName'),
    userOrganization: localStorage.getItem('userOrganisation'),
    removeUser: false
};

/**
 * Mutations are the only way to modify app's state.
 * They should always stay synchronous.
 */
const mutations = {
    setAuth(state, payload) {
        if (payload !== null) {
            state.userName = payload.userName;
            state.userId = payload.userId;
            state.userRealName = payload.userRealName;
            state.userAvatar = payload.userAvatar;
            state.userOrganization = payload.userOrganization;
        } else {
            state.userName = null;
            state.userId = null;
            state.userRealName = null;
            state.userAvatar = null;
            state.userOrganization = null;
        }
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
            localStorage.setItem('userId', authResponse.data.userId);
            localStorage.setItem('userAvatar', authResponse.data.imagePath);
            localStorage.setItem('userRealName', authResponse.data.name);
            if (!authResponse.data.organization) {
                localStorage.setItem('userOrganisation', authResponse.data.organization);
            }
            commit('setAuth', { userName: authResponse.data.login, userId: authResponse.data.userId, userRealName: authResponse.data.name, userAvatar: authResponse.data.imagePath, userOrganization: authResponse.data.organization });

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
