import {getFriends, addFriend, removeFriend} from '../../api/rest/friends.api';

const state = {
    friends: [],
    isRemoved: false
};

const getters = {
    getFriendById: (state) => (id) => {
        return state.friends.find(friend => friend.id === id);
    }
};

const mutations = {
    updateFriends(state, updatedFriends) {
        state.friends = updatedFriends;
    },
    removeFriend(state, friendId) {
        removeFriend(friendId);
    },
    addFriend(state, friend) {
        addFriend(friend);
    },
    setRemoved(state) {
        state.isRemoved = !state.isRemoved;
    }
};

const actions = {
    async getFriends({ commit }) {
        const response = await getFriends();
        const updatedFriends = response.data;
        commit('updateFriends', updatedFriends);
    },
    async addFriend({ commit }, friend) {
        commit('addFriend', friend);
    },
    removeFriend({ commit, state }, friend) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                commit('removeFriend', friend);
                let updatedFriends;
                updatedFriends = state.friends.filter(function (element) {
                    return friend.Id !== element.friendId.id;
                });
                commit('updateFriends', updatedFriends);
                resolve(commit('setRemoved'));
            }, 500);
        });
    }
};

/* const boilerplate = {
    getFriends() {
        return [
            {
                id: 1,
                name: 'Andrey Zorin',
                login: 'zorin',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 3,
                name: 'Michail Fedoseev',
                login: 'fedoseev',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: false
            },
            {
                id: 4,
                name: 'Nikolai Petrov',
                login: 'login1',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 5,
                name: 'Alexandra Sotnikova',
                login: 'login2',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 6,
                name: 'Ilya Bokov',
                login: 'login3',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 7,
                name: 'Ira Raush',
                login: 'login4',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 8,
                name: 'Katya Eliseeva',
                login: 'login5',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            }
        ];
    }
}; */

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
