import {getProfile} from '@/api/rest/profile.api';

const state = {
    profile: {}
};

const mutations = {
    setUserProfileData(state, data) {
        if (data !== null) {
            state.profile = data;
        }
    }
};

const actions = {
    async getCurrentUserData({ commit }) {
        const response = await getProfile();
        if (response.data) {
            commit('setUserProfileData', response.data);
        }
    }
};

export default {
    namespaced: true,
    state,
    actions,
    mutations
};
