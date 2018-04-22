
const state = {
    friends: []
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
                id: 1,
                name: 'Andrey Zorin',
                login: 'zorin',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            },
            {
                id: 2,
                name: 'Michail Fedoseev',
                login: 'fedoseev',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: false
            },
            {
                id: 3,
                name: 'Nikolai Petrov',
                login: 'login1',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            },
            {
                id: 4,
                name: 'Alexandra Sotnikova',
                login: 'login2',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            },
            {
                id: 5,
                name: 'Ilya Bokov',
                login: 'login3',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            },
            {
                id: 6,
                name: 'Ira Raush',
                login: 'login4',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            },
            {
                id: 7,
                name: 'Katya Eliseeva',
                login: 'login5',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                online: true
            }
        ];
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
