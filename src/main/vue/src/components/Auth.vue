<template>
    <div>
        <v-btn v-if="authCheck" flat @click="logout" :key="+authCheck">{{ $t('auth.logout') }}</v-btn>
        <v-btn v-else flat href="/login">{{ $t('auth.login') }}</v-btn>
    </div>
</template>
<script>
import { isAuthorized, logout } from '@/api/rest/user.api';

export default {
    name: 'Auth',
    data: () => ({
        authCheck: false
    }),
    async mounted() {
        this.authCheck = await isAuthorized();
    },
    methods: {
        async logout() {
            await logout();
            this.$router.push('/');
            this.authCheck = false;
        }
    }
};
</script>
