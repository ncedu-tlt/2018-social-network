
const state = {
    friends: []
};

const getters = {
    getUserById: (state) => (id) => {
        return state.friends.filter(user => user.id.toString() === id.toString())[0];
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
                id: 1,
                name: 'Andrey Zorin',
                login: 'zorin',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 2,
                name: 'Artem Kozlov',
                login: 'tadoma',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 3,
                name: 'Michail Fedoseev',
                login: 'fedoseev',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: false
            },
            {
                id: 4,
                name: 'Nikolai Petrov',
                login: 'login1',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 5,
                name: 'Alexandra Sotnikova',
                login: 'login2',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 6,
                name: 'Ilya Bokov',
                login: 'login3',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 7,
                name: 'Ira Raush',
                login: 'login4',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                online: true
            },
            {
                id: 8,
                name: 'Katya Eliseeva',
                login: 'login5',
                avatar: 'http://googledino.ru/assets/googe_dino.png',
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
