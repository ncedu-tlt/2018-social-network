import {getSettings, setSettings} from '../../api/rest/settings.api';

const state = {
    settings: {}
};

const mutations = {
    updateSettings(state, updatedSettings) {
        state.settings = updatedSettings;
    },
    changeSetting(state, _setting) {
        for (let i = 0; i < state.settings.settingUnits.length; i++) {
            console.log(_setting.name);
            console.log(state.settings.settingUnits[i].name);
            if (state.settings.settingUnits[i].name === _setting.name) {
                console.log('я попал внутрь');
                state.settings.settingUnits[i].value = _setting.value ? 'true' : 'false';
            }
        }
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
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
