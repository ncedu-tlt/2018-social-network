import { getUsers } from '@/api/rest/user.api';

const state = {
    friends: []
};

const getters = {
    getFriendById: (state) => (id) => {
        return state.friends.find(friend => friend.id === id);
    }
};

const mutations = {
    updateFriends(state, updatedFriends) {
        state.friends = updatedFriends;
    }
};

const actions = {
    async updateFriends({ commit, rootState }) {
        const response = await getUsers();
        const users = response.data;
        const toDelete = new Set([parseInt(rootState.auth.userId)]);
        const updatedFriends = users.filter(obj => !toDelete.has(obj.userId));

        commit('updateFriends', updatedFriends);
    }
};

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
