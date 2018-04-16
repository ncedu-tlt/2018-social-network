import { getSettings } from '../../api/rest/user.api';

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
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
