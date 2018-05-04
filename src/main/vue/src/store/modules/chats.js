
const state = {
    chats: []
};

const getters = {
    getChatById: (state) => (id) => {
        return state.chats.filter(chat => chat.participantsId.toString() === id.toString());
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
            dateMsg: new Date(),
            participantsId: people.map(p => p.id)
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
                dateMsg: new Date(),
                type: 'dialog',
                participantsId: [1]
            },
            {
                id: 2,
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                name: 'Conference name',
                previewMsg: 'Text text text',
                dateMsg: new Date(),
                type: 'conference',
                participantsId: [1, 2]
            },
            {
                id: 3,
                avatar: 'https://refactorsaurusrex.com/images/rawr-avatar.png',
                name: 'Project name',
                previewMsg: 'Another message...',
                dateMsg: new Date(),
                type: 'project',
                participantsId: [2, 3]
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
