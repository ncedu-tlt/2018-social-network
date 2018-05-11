<template>
    <v-container grid-list-xl text-xs-center>
        <v-layout row wrap>
            <v-flex>
                <div class="welcome logo">
                    <!--TODO logo-->
                    <!--<svg/>-->
                    <img src="../assets/logo.png" alt="Dev Comrades">
                </div>
            </v-flex>
            <v-flex>
                <div class="welcome message">
                    <div class="welcome text">
                        <p class="primary--text">Welcome to social network <br> for geeks!</p>
                    </div>
                    <div v-if="userName" class="button logout">
                        <v-btn
                            large
                            dark
                            color="primary"
                            @click="logout"
                            :key="+userName">{{ $t('auth.logout') }}</v-btn>
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
            <v-snackbar
                v-if="userDelete"
                :timeout="10000"
                v-model="userDelete"
                right
                color="error">
                <strong class="body-2">
                    {{ $t('account_remove') }}
                </strong>
                <v-icon class="material-icons">
                    done
                </v-icon>
            </v-snackbar>
        </v-layout>
    </v-container>

</template>
<script>
import { mapState } from 'vuex';

export default {
    name: 'AuthPage',
    data() {
        return {
            userDelete: this.$store.state.auth.removeUser
        };
    },
    computed: {
        ...mapState('auth', [
            'userName'
        ])
    },
    methods: {
        logout() {
            this.$store.dispatch('auth/logout');
            this.$router.push('/');
        }
    }
};
</script>
<style scoped>
    .welcome{
        margin-top: 10%;
    }
    .text{
        font: bold 2em Roboto, sans-serif;
    }
    .button{
        margin-top: 5%;
    }
</style>
