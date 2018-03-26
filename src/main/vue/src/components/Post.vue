<template>
    <v-card>
        <v-flex>
            <v-layout row wrap>
                <v-flex class="post__avatar">
                    <v-avatar :size="70" class="deep-purple">
                        <img :src="post.user.avatar">
                    </v-avatar>
                </v-flex>
                <v-flex xs9>
                    <v-card-title>
                        <span class="title deep-purple--text headline mb-0">
                            {{ post.user.name }}
                        </span>
                        <v-spacer />
                        <span class="post__type deep-purple white--text">
                            {{ post.type }}
                        </span>
                    </v-card-title>
                    <v-card-title>
                        <span class="grey--text">{{ post.date }}</span>
                    </v-card-title>
                </v-flex>
            </v-layout>
        </v-flex>
        <v-spacer/>
        <v-flex>
            <v-card-text>
                {{ post.content }}
            </v-card-text>
        </v-flex>
        <v-card-actions>
            <v-spacer />
            <v-btn flat icon color="black">
                <v-icon>favorite</v-icon>
            </v-btn>
            <v-btn flat icon color="black" @click="commentClicked">
                <v-icon>comment</v-icon>
            </v-btn>
            <v-btn flat icon color="black">
                <v-icon>share</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>
<script>
export default {
    name: 'Post',
    props: {
        post: {
            type: Object,
            required: false,
            default: null
        }
    },
    methods: {
        commentClicked() {
            this.$emit('commentClicked', this.post.id);
        }
    }
};
</script>

<style scoped>
    .card {
        max-width: 600px;
        min-height: 200px;
    }
    .post__avatar {
        max-width: 100px;
    }
    .card__title {
        padding: 2px;
    }
    .card__text {
        padding: 17px;
    }
    .post__type {
        font-size: 10px;
        width: 40px;
        text-align: center;
        border-radius: 5px;
    }
</style>
