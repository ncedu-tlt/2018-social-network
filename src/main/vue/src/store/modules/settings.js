import {getSettings, setSettings} from '../../api/rest/user.api';

const state = {
    settings: []
};

const mutations = {
    updateSettings(state, updatedSettings) {
        state.settings = updatedSettings;
    }
};

const actions = {
    async getSettings({ commit }) {
        const response = await getSettings();
        const updatedSettings = response.data;
        commit('updateSettings', updatedSettings);
    },
    async setSettings({ commit }) {
        await setSettings(state.settings);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
