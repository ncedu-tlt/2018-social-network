import { getProjects } from '@/api/rest/user.api';

const state = {
    projects: []
};

const mutations = {
    updateProjects(state, updatedProjects) {
        state.projects = updatedProjects;
    }
};

const actions = {
    async updateProjects({ commit }, userName) {
        const responce = await getProjects(userName);
        const updatedProjects = responce.data;
        commit('updateProjects', updatedProjects);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
