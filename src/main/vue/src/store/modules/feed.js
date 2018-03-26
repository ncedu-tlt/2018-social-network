const state = {
    /* TODO : remove data for production */
    posts: [
        {
            id: 1,
            date: '23 January 2018 at 19:30 pm',
            type: 'Post',
            content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ' +
            's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ' +
            'type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, ' +
            'remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing ' +
            'Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions ' +
            'of Lorem Ipsum.',
            user: {
                id: 1,
                name: 'Jake White',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            comments: [
                {
                    id: 1,
                    postId: 1,
                    date: '23 January 2018 at 20:30 pm',
                    user: {
                        id: 1,
                        name: 'Jake White',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                },
                {
                    id: 2,
                    postId: 2,
                    date: '23 January 2018 at 21:31 pm',
                    user: {
                        id: 2,
                        name: 'Jake Black',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ' +
                    's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a'
                }
            ]
        },
        {
            id: 2,
            date: '21 January 2018 at 19:30 pm',
            type: 'Commit',
            content: 'New commit [link]',
            user: {
                id: 1,
                name: 'Jake White',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            comments: [
                {
                    id: 1,
                    postId: 2,
                    date: '21 January 2018 at 20:30 pm',
                    user: {
                        id: 1,
                        name: 'Jake White',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                },
                {
                    id: 2,
                    postId: 2,
                    date: '21 January 2018 at 20:31 pm',
                    user: {
                        id: 3,
                        name: 'Jake Yellow',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                }
            ]
        }
    ]
};

/* TODO : remove data for production */
let ID = 3;

const mutations = {
    addComment(state, comment) {
        /* TODO : remove data for production */
        const testComment = {
            id: ID += 1,
            postId: comment.postId,
            date: '21 January 2018 at 9:20 pm',
            user: {
                id: 3,
                name: 'Jake Yellow',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            content: comment.content
        };
        const post = state.posts.find(p => p.id === comment.postId);
        if (post) {
            post.comments.push(testComment);
        }
    },
    addPost(state, post) {
        /* TODO : remove data for production */
        const testPost = {
            id: ID += 1,
            date: '21 January 2018 at 9:20 pm',
            type: 'Post',
            content: post.content,
            user: {
                id: 3,
                name: 'Jake Yellow',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            comments: []
        };
        state.posts.push(testPost);
    }
};

const actions = {
    async sendComment({commit}, comment) {
        commit('addComment', comment);
    },
    async sendPost({commit}, post) {
        commit('addPost', post);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
