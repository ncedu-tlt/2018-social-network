import {
    addComment,
    createPost,
    getComments,
    getPosts,
    updateCommentLike,
    updatePostLike
} from '../../api/rest/feed.api';

const state = {
    posts: [],
    comments: []
};

const mutations = {
    sendComment(state, comment) {
        const post = state.posts.find(p => p.id === comment.postId);
        if (post) {
            addComment(comment);
        }
    },
    setLikePost(state, like) {
        const updateLike = state.posts.find(p => p.id === like.postId);
        if (updateLike) {
            const newLike = {
                likeValue: like.updateLike,
                postId: like.postId
            };
            updatePostLike(newLike);
        }
    },
    setLikeComment(state, like) {
        const updateLike = state.comments.find(c => c.id === like.commentId);
        if (updateLike) {
            const newLike = {
                likeValue: like.updateLike,
                commentId: like.commentId
            };
            updateCommentLike(newLike);
        }
    },
    updatePosts(state, post) {
        state.posts = post;
    },
    updateComments(state, comment) {
        state.comments = comment;
    }
};

const actions = {
    sendComment({commit}, comment) {
        commit('sendComment', comment);
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
    },
    async getComments({commit}) {
        const response = await getComments();
        const updateComments = response.data;
        commit('updateComments', updateComments);
    },
    async createPost({commit}, post) {
        await createPost(post);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
