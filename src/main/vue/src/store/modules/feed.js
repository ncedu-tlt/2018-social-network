const state = {
    posts: [
        {
            id_post: 1,
            name: 'Post Name One',
            img_path: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
            date: '10.01.1996',
            id_type_post: 1,
            content: 'Post one some text',
            id_user: 1,
            id_parent: 1
        },
        {
            id_post: 2,
            name: 'Post Name Two',
            img_path: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
            date: '10.01.1992',
            id_type_post: 1,
            content: 'Post two some text',
            id_user: 2,
            id_parent: 2
        }
    ],
    comments: [
        {
            id_comment: 1,
            id_user: 1,
            name: 'Comment One',
            img_path: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
            content: 'Comment one some text',
            date: '1.01.1111',
            id_post: 1
        },
        {
            id_comment: 2,
            id_user: 2,
            name: 'Comment Two',
            img_path: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
            content: 'Comment two some text',
            date: '1.02.1111',
            id_post: 2
        }
    ]
};

const getters = {
};

const mutations = {
    addComment(state, data) {
        state.comments.push({
            id_comment: 1,
            id_user: 1,
            img_path: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
            name: 'name',
            content: data.content,
            date: '1.11.1999',
            id_post: data.id_post
        });
    }
};

const actions = {
    sendComment({ commit }, data) {
        // Call some API in order to send a message
        commit('addComment', data);
    }
};

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
};
