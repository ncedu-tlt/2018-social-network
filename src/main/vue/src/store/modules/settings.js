import {getSettings, setSettings} from '../../api/rest/settings.api';
import { deleteUser } from '../../api/rest/user.api';

const state = {
    settings: {}
};

const mutations = {
    updateSettings(state, updatedSettings) {
        state.settings = updatedSettings;
    },
    changeSetting(state, _setting) {
        for (let i = 0; i < state.settings.settingUnits.length; i++) {
            if (state.settings.settingUnits[i].settingsId.name === _setting.name) {
                state.settings.settingUnits[i].value = _setting.value ? 'true' : 'false';
            }
        }
        setSettings(state.settings);
    },
    setLanguage(state, language) {
        for (let i = 0; i < state.settings.settingUnits.length; i++) {
            if (state.settings.settingUnits[i].settingsId.name === 'settings.language') {
                state.settings.settingUnits[i].value = language;
            }
        }
        localStorage.setItem('language', language);
        setSettings(state.settings);
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
    },
    async deleteUser({commit}, userName) {
        await deleteUser(userName);
        commit('updateSettings', null);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
