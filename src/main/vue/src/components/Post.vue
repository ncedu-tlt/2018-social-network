<template>
    <v-container>
        <v-layout>
            <v-flex xs12 md5 offset-md2>
                <v-card class="post" hover>
                    <v-container class="post__title">
                        <v-layout>
                            <v-flex>
                                <v-avatar :size="70" class="post__avatar grey">
                                    <img :src="post.img_path">
                                </v-avatar>
                            </v-flex>
                            <v-flex xs12 align-start>
                                <v-card-title>
                                    <span class="headline mb-0">{{ post.name }}</span>
                                </v-card-title>
                                <v-card-text>
                                    <span>{{ post.date }}</span>
                                </v-card-text>
                            </v-flex>
                        </v-layout>
                    </v-container>
                    <v-card-text>{{ post.content }}</v-card-text>
                    <v-card-actions class="post__actions">
                        <v-btn flat icon color="black">
                            <v-icon>favorite</v-icon>
                        </v-btn>
                        <v-btn flat icon color="black" @click="isCommentClicked(post.id_post)">
                            <v-icon>comment</v-icon>
                        </v-btn>
                        <v-btn flat icon color="black">
                            <v-icon>share</v-icon>
                        </v-btn>
                    </v-card-actions>
                </v-card>
                <div v-if="commentShow">
                    <Comment
                        v-for="(comment, id_comment) in comments"
                        v-if="comment.id_post === post.id_post"
                        :key="id_comment"
                        :comment="comment" />
                    <CommentAdd :data="data"/>
                </div>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import Comment from '@/components/Comment';
import CommentAdd from '@/components/CommentAdd';

export default {
    name: 'Post',
    components: {
        Comment,
        CommentAdd
    },
    props: {
        post: {
            type: Object,
            required: false,
            default: null
        }
    },
    data() {
        return {
            commentShow: false,
            data: {}
        };
    },
    computed: {
        comments() {
            return this.$store.state.feed.comments;
        }
    },
    methods: {
        isCommentClicked(idPost) {
            this.commentShow = !this.commentShow;
            this.data.id_post = idPost;
        }
    }
};
</script>

<style scoped>
    .post {
        width: 700px;
    }
    .post__title {
        height: 110px;
    }
    .post__avatar {
        width: 400px;
        margin: 20px;
        justify-content: flex-start;
    }
    .post__actions {
        padding-left: 550px;
    }
</style>
