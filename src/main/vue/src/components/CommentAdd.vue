<template>
    <v-card class="mx-auto mt-1" flat>
        <v-form @submit.prevent="validateBeforeSubmit">
            <v-text-field
                v-model="text"
                textarea
                class="input-group__input pa-2"
                :error-messages="errors.collect('text')"
                v-validate="'required|max:400'"
                data-vv-name="text"
                :counter="400"
                required
            />
            <v-card-actions>
                <v-spacer/>
                <v-btn flat class="primary--text" @click="clear">{{ $t('clear') }}</v-btn>
                <v-btn round class="white--text primary" type="submit">
                    {{ $t('add comment') }}
                </v-btn>
            </v-card-actions>
        </v-form>
    </v-card>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    name: 'CommentAdd',
    $_veeValidate: {
        validator: 'new'
    },
    props: {
        postId: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            valid: false,
            text: ''
        };
    },
    methods: {
        validateBeforeSubmit() {
            this.$validator.validateAll().then((result) => {
                if (result) {
                    const comment = {
                        postId: this.postId,
                        content: this.text
                    };
                    this.sendComment(comment);
                    this.clear();
                }
            });
        },
        clear() {
            this.text = '';
            this.$validator.reset();
        },
        ...mapActions('feed', [
            'sendComment'
        ])
    }
};
</script>

<style scoped>
    .card {
        max-width: 600px;
        min-height: 200px;
    }
</style>
