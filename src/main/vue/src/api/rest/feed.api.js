import client from '@/api/rest/client';

export function getPosts() {
    return client.get('/posts');
}

export function getComments() {
    return client.get('/comments');
}

export function addComment(comment) {
    return client.post('/comments', comment);
}

export function createPost(post) {
    return client.post('/posts', post);
}

export function updatePostLike(like) {
    return client.patch('/posts/likes', like);
}

export function updateCommentLike(comment) {
    return client.patch('/comments/likes', comment);
}
