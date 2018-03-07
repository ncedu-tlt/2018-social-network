<template>
    <v-container grid-list-md text-xs-center>
        <v-layout row wrap>
            <v-flex xs6>
                <div class="welcome logo">
                    <!--TODO logo-->
                    <!--<svg/>-->
                    <img src="../assets/logo.png" alt="Dev Comrades">
                </div>
            </v-flex>
            <v-flex xs6>
                <div class="welcome message">
                    <div class="welcome text">
                        <p>Welcome to social network <br> for geeks!</p>
                    </div>
                    <div v-if="authCheck" class="button logout">
                        <v-btn
                            large
                            dark
                            color="primary"
                            @click="logout"
                            :key="+authCheck">{{ $t('auth.logout') }}</v-btn>
                    </div>
                    <div v-else class="button login">
                        <v-btn
                            large
                            dark
                            color="primary"
                            href="/login">{{ $t('auth.login') }}</v-btn>
                    </div>
                </div>
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';

export default {
    name: 'AuthPage',
    computed: {
        ...mapGetters({
            authCheck: 'auth/getAuthCheck'
        })
    },
    async mounted() {
        await this.actionAuthCheck();
    },
    methods: {
        ...mapActions({
            actionAuthCheck: 'auth/actionAuthCheck',
            logout: 'auth/actionLogout'
        })
    }
};
</script>
<style scoped>
    .welcome{
        margin-top: 10%;
    }
    .text{
        font: bold 2em Roboto, sans-serif;
        color: mediumpurple;
    }
    .button, .login, .logout{
        margin-top: 5%;
    }
</style>
