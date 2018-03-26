<template>
    <v-card>
        <v-flex>
            <v-card-text class="deep-purple--text">Create new post</v-card-text>
            <v-form v-model="valid" ref="form" lazy-validation>
                <v-text-field
                    textarea
                    class="input-group__input"
                    v-model="text"
                    :rules="textRules"
                    :counter="1000"
                    @keyup.enter="addPost"
                    required
                />
            </v-form>
        </v-flex>
        <v-card-actions>
            <v-spacer />
            <v-btn flat icon color="black">
                <v-icon>add</v-icon>
            </v-btn>
            <v-btn @click="postCancelClicked" small flat class="deep-purple--text">Cancel</v-btn>
            <v-btn
                round
                small
                class="white--text deep-purple"
                :disabled="!valid"
                @click="addPost"
            >
                Create post
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    name: 'PostCreate',
    data() {
        return {
            valid: true,
            post: Object,
            text: '',
            textRules: [
                v => !!v || 'Post text is required',
                v => (v && v.length <= 1000) || 'Post text must be less than 1000 characters'
            ]
        };
    },
    methods: {
        addPost() {
            if (this.$refs.form.validate()) {
                this.post.content = this.text;
                this.sendPost(this.post);
                this.$refs.form.reset();
            }
        },
        postCancelClicked() {
            this.$emit('postCancelClicked');
        },
        ...mapActions('feed', [
            'sendPost'
        ])
    }
};
</script>

<style scoped>
    .card {
        max-width: 600px;
        min-height: 300px;
    }
    .input-group__input {
        padding: 10px;
    }
</style>
