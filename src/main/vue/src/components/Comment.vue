<template>
    <v-card class="mx-auto">
        <v-layout>
            <v-avatar :size="70" class="primary">
                <img :src="comment.user.avatar">
            </v-avatar>
            <v-flex>
                <v-card-title>
                    <span class="title primary--text"> {{ comment.user.name }} </span>
                </v-card-title>
                <v-card-title>
                    {{ comment.content }}
                </v-card-title>
                <v-card-title class="comment__bottom">
                    <span class="grey--text">{{ $d(comment.date, 'long') }}</span>
                    <v-spacer/>
                    <v-btn @click="likeClicked" flat icon color="black">
                        <v-icon color="black" v-if="!comment.like">
                            favorite_border
                        </v-icon>
                        <v-icon color="primary" v-else>favorite</v-icon>
                    </v-btn>
                </v-card-title>
            </v-flex>
        </v-layout>
    </v-card>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    name: 'Comment',
    props: {
        comment: {
            type: Object,
            required: true
        }
    },
    methods: {
        likeClicked() {
            const like = {
                commentId: this.comment.id,
                updateLike: !this.comment.like
            };
            this.setLikeComment(like);
        },
        ...mapActions('feed', [
            'setLikeComment'
        ])
    }
};
</script>

<style scoped>
    .card {
        margin-top: 3px;
        max-width: 600px;
        min-height: 100px;
    }
    .avatar {
        margin: 10px 10px 10px;
        width: 100px;
    }
    .card__title {
        padding: 2px;
    }
    .comment__bottom {
        align-items: center;
    }
    .title {
        padding-top: 10px;
    }
</style>
