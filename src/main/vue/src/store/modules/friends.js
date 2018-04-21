
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
                status: 'Online'
            },
            {
                id: 2,
                name: 'Michail Fedoseev',
                login: 'fedoseev',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Last seen 6:00 pm'
            },
            {
                id: 3,
                name: 'Nikolai Petrov',
                login: 'login1',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Online'
            },
            {
                id: 4,
                name: 'Alexandra Sotnikova',
                login: 'login2',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Online'
            },
            {
                id: 5,
                name: 'Ilya Bokov',
                login: 'login3',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Online'
            },
            {
                id: 6,
                name: 'Ira Raush',
                login: 'login4',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Online'
            },
            {
                id: 7,
                name: 'Katya Eliseeva',
                login: 'login5',
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                status: 'Online'
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
