<template>
    <v-container>
        <v-layout row wrap align-center>
            <v-flex xs12 md5 offset-md2>
                <v-card class="comment" hover>
                    <v-container class="comment__title">
                        <v-layout>
                            <v-flex>
                                <v-avatar :size="70" class="comment__avatar grey">
                                    <img :src="comment.img_path">
                                </v-avatar>
                            </v-flex>
                            <v-flex xs12 align-start>
                                <v-card-title>
                                    <span class="headline mb-0">{{ comment.name }}</span>
                                </v-card-title>
                            </v-flex>
                        </v-layout>
                    </v-container>
                    <v-card-text>{{ comment.content }}</v-card-text>
                    <v-card-actions>
                        <v-card-text>
                            <span>{{ comment.date }}</span>
                        </v-card-text>
                        <v-btn flat icon color="black">
                            <v-icon>favorite</v-icon>
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
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
    .comment {
        width: 630px;
    }
    .comment__title {
        height: 110px;
    }
    .comment__avatar {
        width: 400px;
        margin: 20px;
        justify-content: flex-start;
    }
</style>
