<template>
    <v-navigation-drawer
        fixed
        :clipped="$vuetify.breakpoint.mdAndUp"
        app
        :mini-variant.sync="drawer-visible"
        @update:miniVariant="updateDrawerVisible"
    >
        <v-list>
            <v-list class="pa-0">
                <v-list-tile avatar>
                    <v-list-tile-avatar>
                        <img src="https://randomuser.me/api/portraits/men/85.jpg">
                    </v-list-tile-avatar>
                    <v-list-tile-content>
                        <v-list-tile-title>John Leider</v-list-tile-title>
                        <v-list-tile-sub-title>Leader dev</v-list-tile-sub-title>
                    </v-list-tile-content>
                    <v-list-tile-action/>
                </v-list-tile>
            </v-list>
            <v-divider/>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>dashboard</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>My projects</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>work</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>My messages</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>message</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>My feed</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>history</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>My contacts</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>settings</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>Preferences</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: 'Drawer',
    props: {
        /* is-drawer-visible: {
            type: Boolean,
            required: true
        } */
    },
    data() {
        return {
            drawer: true,
            right: null
        };
    },
    methods: {
        updateDrawerVisible() {
            this.$emit('update:is-drawer-visible', 'this.is-drawer-visible');
        }
    }
};
</script>
