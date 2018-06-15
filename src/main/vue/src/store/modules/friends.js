
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
    async updateFriends({ commit }) {
        const updatedFriends = boilerplate.getFriends();
        commit('updateFriends', updatedFriends);
    }
};

const boilerplate = {
    getFriends() {
        return [
            {
                id: 2000,
                name: 'Andrey Zorin',
                login: 'zorin',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 3000,
                name: 'Alexandra Sotnikova',
                login: 'sotn',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            }
        ];
    }
};

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
