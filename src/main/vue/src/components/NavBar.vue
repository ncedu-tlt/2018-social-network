<template>
    <v-toolbar dark color="primary" fixed app>
        <v-toolbar-side-icon @click="clickHamburgerButton"/>
        <v-toolbar-title>Dev Comrades</v-toolbar-title>
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
