<template>
    <v-card>
        <v-flex>
            <v-layout>
                <v-flex class="comment__avatar">
                    <v-avatar :size="70" class="deep-purple">
                        <img :src="comment.user.avatar">
                    </v-avatar>
                </v-flex>
                <v-flex xs9>
                    <v-card-title>
                        <span class="title deep-purple--text headline mb-0">
                            {{ comment.user.name }}
                        </span>
                    </v-card-title>
                    <v-card-title>
                        {{ comment.content }}
                    </v-card-title>
                </v-flex>
            </v-layout>
        </v-flex>
        <v-card-actions>
            <v-card-text>
                <span class="grey--text">{{ comment.date }}</span>
            </v-card-text>
            <v-spacer />
            <v-btn flat icon color="black">
                <v-icon>favorite</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>
<script>
export default {
    name: 'Comment',
    props: {
        comment: {
            type: Object,
            required: false,
            default: null
        }
    }
};
</script>

<style scoped>
    .card {
        margin: 2px;
        max-width: 600px;
        min-height: 100px;
    }
    .comment__avatar {
        max-width: 100px;
    }
    .card__title {
        padding: 2px;
    }
    .card__text {
        padding: 17px;
    }
</style>
