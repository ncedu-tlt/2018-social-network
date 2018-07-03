import {getCurrentUser} from '@/api/rest/user.api';
import {getProfile} from '@/api/rest/profile.api';
import {getSettings} from '@/api/rest/settings.api';

const state = {
    profile: {
        name: '',
        userAvatar: '',
        languages: [],
        technologies: [],
        placeOfWork: '',
        job: ''
    },
    profileSettings: {
        showLanguages: true,
        showTechnologies: true,
        showPlaceOfWork: true,
        showJob: true
    }
};

const mutations = {
    setUserProfileData(state, data) {
        if (data !== null) {
            state.profile.name = data.name;
            state.profile.userAvatar = data.userAvatar;
            state.profile.languages = data.languages;
            state.profile.technologies = data.technologies;
            state.profile.placeOfWork = data.placeOfWork;
            state.profile.job = data.job;
        }
    },
    setUserSettings(state, values) {
        if (values !== null) {
            state.profileSettings.showLanguages = values.showLanguages;
        }
    }
};

const actions = {
    async getCurrentUserData({ commit }) {
        const userResponse = await getCurrentUser();
        const profileResponse = await getProfile();
        if (userResponse.data && profileResponse.data) {
            commit('setUserProfileData', {name: userResponse.data.name, userAvatar: userResponse.data.imagePath, languages: profileResponse.data.languages, technologies: profileResponse.data.technologies, placeOfWork: profileResponse.data.placeOfWork, job: profileResponse.data.job});
        }
    },
    async getCurrentUserSettings({ commit }) {
        const settingsResponse = await getSettings();
        if (settingsResponse.data) {
            const showLanguages = settingsResponse.data.settingUnits.filter(showLanguages => showLanguages.settingsId.name === 'settings.show_language');
            commit('setUserSettings', {showLanguages: showLanguages[0].value});
        }
    }
};

export default {
    namespaced: true,
    state,
    actions,
    mutations
};
