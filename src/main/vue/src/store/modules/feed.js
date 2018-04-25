import { addPost, getPosts } from '../../api/rest/user.api';

const state = {
    posts: []
};

/* TODO : remove data for production */
let id = 3;

const mutations = {
    sendComment(state, {testComment, comment}) {
        const post = state.posts.find(p => p.id === comment.postId);
        if (post) {
            post.comments.push(testComment);
        }
    },
    setLikePost(state, like) {
        const post = state.posts.find(p => p.id === like.postId);
        if (post) {
            post.like = like.updateLike;
        }
    },
    setLikeComment(state, like) {
        state.posts.forEach(function (item) {
            item.comments.forEach(function (c) {
                if (c.id === like.commentId) {
                    c.like = like.updateLike;
                }
            });
        });
    },
    updatePosts(state, post) {
        state.posts = post;
    },
    addPost(state, post) {
        addPost(post);
    }
};

const actions = {
    sendComment({commit}, comment) {
        /* TODO : remove data for production */
        const testComment = {
            id: id += 1,
            date: new Date(),
            user: {
                id: 3,
                name: 'Jake Yellow',
                avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460'
            },
            like: false,
            content: comment.content
        };
        commit('sendComment', {testComment, comment});
    },
    setLikePost({commit}, like) {
        commit('setLikePost', like);
    },
    setLikeComment({commit}, like) {
        commit('setLikeComment', like);
    },
    async getPosts({commit}) {
        const response = await getPosts();
        const updatePosts = response.data;
        commit('updatePosts', updatePosts);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
