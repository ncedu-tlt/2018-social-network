<template>
    <v-navigation-drawer
        fixed
        clipped
        app
        :mini-variant.sync="visible"
        :permanent="minify"
        @update:miniVariant="updateDrawerVisible"
    >
        <v-list subheader>
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
                    <v-list-tile-title>{{ $t('projects') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>work</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('messages') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>message</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('feed') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>history</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('contacts') }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-action>
                    <v-icon>settings</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ $t('preferences') }}</v-list-tile-title>
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
            type: Boolean,
            default: true
        }
    },
    data() {
        return {
            minify: false
        };
    },
    watch: {
        visible: function () {
            if (this.$vuetify.breakpoint.mdAndDown) {
                this.minify = !this.minify;
            }
        }
    },
    methods: {
        updateDrawerVisible() {
            this.$emit('update:visible', this.visible);
        }
    }
};
</script>
