<template>
    <div>
        <!--<v-btn v-if="isAuthorized" flat @click="logout">{{ $t('auth.logout') }}</v-btn>-->
        <!--<v-btn v-else flat href="login">{{ $t('auth.login') }}</v-btn>-->

        <v-btn flat href="login">{{ $t('auth.login') }}</v-btn>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    name: 'Auth',
    data: () => ({
        isAuthorized: {
            type: Boolean,
            required: true
        },
        errors: []
    }),
    mounted() {
        this.setState();
    },
    methods: {
        logout() {
            axios.post('/logout')
                .then(response => {})
                .catch(e => {
                    this.errors.push(e);
                });
        },
        setState() {
            axios.get('https://api.github.com/user', {})
                .then(response => {
                    // in case that github returned 200, so everything is ok
                    this.isAuthorized = true;
                })
                .catch(e => {
                    // otherwise like 401, 404 etc.
                    this.isAuthorized = false;
                    this.errors.push(e);
                });
        }
    }
};
</script>
