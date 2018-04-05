const state = {
    /* TODO : remove data for production */
    posts: [
        {
            id: 1,
            date: new Date(),
            type: 'Post',
            content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ' +
            's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ' +
            'type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, ' +
            'remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing ' +
            'Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions ' +
            'of Lorem Ipsum.',
            isLiked: false,
            user: {
                id: 1,
                name: 'Jake White',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            comments: [
                {
                    id: 1,
                    date: new Date(),
                    user: {
                        id: 1,
                        name: 'Jake White',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    isLiked: false,
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                },
                {
                    id: 2,
                    date: new Date(),
                    user: {
                        id: 2,
                        name: 'Jake Black',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    isLiked: false,
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ' +
                    's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a'
                }
            ]
        },
        {
            id: 2,
            date: new Date(),
            type: 'Commit',
            content: 'New commit [link]',
            isLiked: false,
            user: {
                id: 1,
                name: 'Jake White',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            comments: [
                {
                    id: 1,
                    date: new Date(),
                    user: {
                        id: 1,
                        name: 'Jake White',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    isLiked: false,
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                },
                {
                    id: 2,
                    date: new Date(),
                    user: {
                        id: 3,
                        name: 'Jake Yellow',
                        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
                    },
                    isLiked: false,
                    content: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'
                }
            ]
        }
    ]
};

/* TODO : remove data for production */
let id = 3;

const mutations = {
    addComment(state, comment) {
        /* TODO : remove data for production */
        const testComment = {
            id: id += 1,
            date: new Date(),
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
    setLike(state, like) {
        const post = state.posts.find(p => p.id === like.postId);
        const comment = post.comments.find(c => c.id === like.commentId);
        if (post) {
            post.isLiked = like.isLiked;
        }
        if (comment) {
            comment.isLiked = like.isLiked;
        }
    }
};

const actions = {
    async sendComment({commit}, comment) {
        commit('addComment', comment);
    },
    async setLike({commit}, like) {
        commit('setLike', like);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
