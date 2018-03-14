<template>
    <v-container>
        <v-layout row wrap align-center>
            <v-flex offset-md2>
                <v-card class="comment" hover>
                    <v-container fill-height fluid>
                        <v-flex>
                            <v-avatar :size="70" class="comment__avatar grey">
                                <img :src="data.img_path">
                            </v-avatar>
                        </v-flex>
                        <v-flex xs9>
                            <v-text-field
                                v-model="text"
                                @keyup.enter="sendComment"
                                name="input-7-1"/>
                            <div v-if="error.length" class="error">{{ error }}</div>
                        </v-flex>
                        <v-btn type="button" @click="sendComment">Send</v-btn>
                    </v-container>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
export default {
    name: 'CommentAdd',
    props: {
        data: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            error: '',
            text: ''
        };
    },
    methods: {
        sendComment() {
            this.data.content = this.text;
            if (!this.data.content) {
                this.error = 'Text can`t be empty!';
            } else {
                this.error = '';
                this.$store.commit('feed/addComment', this.data);
                this.text = '';
            }
        }
    }
};
</script>

<style scoped>
    .comment {
        width: 630px;
    }
    .comment__avatar {
        width: 400px;
        margin: 20px;
        justify-content: flex-start;
    }
</style>
