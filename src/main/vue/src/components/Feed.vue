<template>
    <v-container grid-list-sm>
        <v-layout column>
            <v-flex>
                <v-slide-y-transition>
                    <div v-if="postCreateShow">
                        <PostCreate @postCancelClicked="postCancelClicked"/>
                    </div>
                </v-slide-y-transition>
            </v-flex>
            <v-flex v-for="post in posts" :key="post.id">
                <Post :post="post" @commentClicked="commentClicked"/>
                <v-slide-y-transition>
                    <div v-if="commentShow && post.id === postId">
                        <Comment v-for="comment in post.comments" :key="comment.id" :comment="comment" />
                        <CommentAdd :post-id="postId"/>
                    </div>
                </v-slide-y-transition>
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
import Post from '@/components/Post';
import PostCreate from '@/components/PostCreate';
import Comment from '@/components/Comment';
import CommentAdd from '@/components/CommentAdd';

export default {
    name: 'Feed',
    components: {
        Post,
        PostCreate,
        Comment,
        CommentAdd
    },
    props: {
        posts: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            commentShow: false,
            postCreateShow: true,
            postId: null
        };
    },
    methods: {
        commentClicked(postId) {
            this.commentShow = !this.commentShow;
            this.postId = postId;
        },
        postCancelClicked() {
            this.postCreateShow = !this.postCreateShow;
        }
    }
};
</script>

<style scoped>
    .container {
        padding: 6px;
    }
</style>
