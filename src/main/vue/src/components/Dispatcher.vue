<template><div/></template>
<script>
import { mapActions, mapGetters } from 'vuex';
import router from '@/router';

export default {
    name: 'Dispatcher',
    computed: {
        ...mapGetters({
            authCheck: 'auth/getAuthCheck'
        })
    },
    async created() {
        await this.actionAuthCheck();
        if (this.authCheck === true) {
            router.push('/feed');
        } else {
            router.push('/welcome');
        }
    },
    methods: {
        ...mapActions({
            actionAuthCheck: 'auth/actionAuthCheck'
        })
    }
};
</script>
