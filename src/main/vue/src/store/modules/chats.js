
const state = {
    chats: []
};

const getters = {
    getChatByLogin: (state) => (login) => {
        return state.chats.filter(chat => chat.participants.toString() === login.toString());
    }
};

const mutations = {
    updateChats(state, updatedChats) {
        state.chats = updatedChats;
    },
    addChat(state, chat) {
        state.chats.push(chat);
    }
};

const actions = {
    async updateChats({ commit }) {
        const updatedChats = boilerplate.getChats();
        commit('updateChats', updatedChats);
    },
    async addChat({ commit }, people) {
        let chat = {
            id: state.chats.length + 1,
            avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
            name: people.map(p => p.name).join(', '),
            previewMsg: 'Just created...',
            dateMsg: `${new Date().getHours()}:${new Date().getMinutes()}`,
            participants: people.map(p => p.login)
        };
        if (people.length > 1) {
            chat.type = 'conference';
        } else {
            chat.type = 'dialog';
        };
        commit('addChat', chat);
        return chat;
    }
};

const boilerplate = {
    getChats() {
        return [
            {
                id: 1,
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                name: 'Andrey Zorin',
                previewMsg: 'Some message...',
                dateMsg: '21:33',
                type: 'dialog',
                participants: ['zorin']
            },
            {
                id: 2,
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                name: 'Conference name',
                previewMsg: 'Text text text',
                dateMsg: '12:10',
                type: 'conference',
                participants: ['zorin', 'login1']
            },
            {
                id: 3,
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                name: 'Project name',
                previewMsg: 'Another message...',
                dateMsg: '10:56',
                type: 'project',
                participants: ['login2', 'login3']
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
