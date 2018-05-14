<template>
    <v-navigation-drawer
        fixed
        clipped
        app
        :mini-variant="!visible.desktop"
        :permanent="visible.mobile"
        v-if="auth"
    >
        <v-list subheader>
            <v-list class="pa-0">
                <v-list-tile avatar class="secondary">
                    <v-list-tile-avatar>
                        <img :src="userData.avatar">
                    </v-list-tile-avatar>
                    <v-list-tile-content>
                        <v-list-tile-title>{{ userData.realName }}</v-list-tile-title>
                        <v-list-tile-sub-title v-if="userData.organization !== null">{{ userData.organization }}</v-list-tile-sub-title>
                    </v-list-tile-content>
                    <v-list-tile-action/>
                </v-list-tile>
            </v-list>
            <v-divider/>
            <v-list-tile :to="{ name: 'ProjectsPage' }" @click="mobileRedirect">
                <v-list-tile-action>
                    <v-icon>call_merge</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('projects') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile :to="{ name: 'ChatPage' }" @click="mobileRedirect">
                <v-list-tile-action>
                    <v-icon>message</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('messages') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile :to="{name: 'FeedPage'}" @click="mobileRedirect">
                <v-list-tile-action>
                    <v-icon>view_headline</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('feed') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile @click="mobileRedirect">
                <v-list-tile-action>
                    <v-icon>contacts</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('contacts') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile :to="{name: 'Settings'}" @click="mobileRedirect">
                <v-list-tile-action>
                    <v-icon>settings</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('preferences') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile @click="logout" class="button_logout">
                <v-list-tile-action>
                    <v-icon>exit_to_app</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('logout') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: 'Drawer',
    props: {
        visible: {
            type: Object,
            default() {
                this.visible.desktop = false;
                this.visible.mobile = false;
            }
        }
    },
    computed: {
        auth() {
            return this.$store.state.auth.userName;
        },
        userData() {
            return {
                realName: this.$store.state.auth.userRealName ? this.$store.state.auth.userRealName : this.$store.state.auth.userName,
                avatar: this.$store.state.auth.userAvatar ? this.$store.state.auth.userAvatar : 'https://pbs.twimg.com/profile_images/787106179482869760/CwwG2e2M_400x400.jpg',
                organization: this.$store.state.auth.userOrganisation ? this.$store.state.auth.userOrganisation : null
            };
        }
    },
    methods: {
        logout() {
            this.$store.dispatch('auth/logout');
            this.$router.push('/auth');
        },
        mobileRedirect() {
            if (this.$vuetify.breakpoint.mdAndDown) {
                this.visible.mobile = false;
            }
        }
    }
};
</script>
<style scoped>
    .button_logout{
        position: absolute;
        bottom: 5px;
        width: 300px;
    }
</style>
