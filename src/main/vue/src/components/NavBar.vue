<template>
    <v-toolbar
        dark
        color="primary"
        fixed
        app
        :clipped-left="$vuetify.breakpoint.mdAndUp">
        <v-toolbar-title>
            <v-toolbar-side-icon @click.native.stop="uncoverDrawer"/>
            <span>Dev Comrades</span>
        </v-toolbar-title>
        <v-spacer/>
        <v-btn icon>
            <v-icon>search</v-icon>
        </v-btn>
    </v-toolbar>
</template>

<script>
export default {
    name: 'NavBar',
    methods: {
        uncoverDrawer() {
            this.$emit('OpenDrawer');
        }
    }
};
</script>
