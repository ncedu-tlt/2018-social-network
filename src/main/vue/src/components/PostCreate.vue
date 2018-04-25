<template>
    <v-card class="mx-auto">
        <v-card-title class="primary--text pa-2">
            {{ $t('create new post') }}
        </v-card-title>
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
                <v-btn flat class="primary--text" @click="cancel">{{ $t('cancel') }}</v-btn>
                <v-btn round class="white--text primary" type="submit">
                    {{ $t('create post') }}
                </v-btn>
            </v-card-actions>
        </v-form>
    </v-card>
</template>

<script>
export default {
    name: 'PostCreate',
    $_veeValidate: {
        validator: 'new'
    },
    data() {
        return {
            valid: false,
            text: '',
            idNext: 1
        };
    },
    methods: {
        validateBeforeSubmit() {
            this.$validator.validateAll().then((result) => {
                if (result) {
                    this.idNext++;
                    const post = {
                        id: this.idNext,
                        userId: 1,
                        date: new Date(),
                        content: this.text,
                        type: 'Post',
                        like: false
                    };
                    this.$store.commit('feed/addPost', post);
                    this.cancel();
                }
            });
        },
        cancel() {
            this.text = '';
            this.$validator.reset();
            this.$emit('cancelClicked');
        }
    }
};
</script>

<style scoped>
    .card {
        width: 600px;
        max-width: 100%;
    }
</style>
