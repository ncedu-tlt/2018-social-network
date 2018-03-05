<template>
    <v-toolbar
        dark
        color="primary"
        fixed
        app
        :clipped-left="$vuetify.breakpoint.mdAndUp">
        <v-toolbar-title style="width: 300px">
            <v-toolbar-side-icon @click="clickHamburgerButton"/>
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
        clickHamburgerButton() {
            this.$emit('ClickHamburgerMenu');
        }
    }
};
</script>
