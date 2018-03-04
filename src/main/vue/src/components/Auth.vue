<template>
    <div>
        <v-btn v-if="isAuthorized" flat @click="logout" :key="isAuthorized">{{ $t('auth.logout') }}</v-btn>
        <v-btn v-else flat href="login/github">{{ $t('auth.login') }}</v-btn>
    </div>
</template>
<script>
import * as api from '@/api/rest/user.api';

export default {
    name: 'Auth',
    data: () => ({
        isAuthorized: {
            type: Boolean,
            default: false,
            required: true
        },
        errors: []
    }),
    created() {
        this.setState();
    },
    methods: {
        logout() {
            api.logout();
        },
        setState() {
            api.getCurrentUser()
                .then(this.isAuthorized = true)
                .catch(e => {
                    this.isAuthorized = false;
                    this.errors.push(e);
                });
        }
    }
};
</script>
