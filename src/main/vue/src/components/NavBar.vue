<template>
    <v-toolbar
        dark
        color="primary"
        fixed
        app
        clipped-left>
        <v-toolbar-title class="ml-0 pl-3">
            <v-toolbar-side-icon @click.stop="hamburgerNotification"/>
            <span class="hidden-xs-and-down">Dev Comrades</span>
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
        hamburgerNotification() {
            this.$emit('hamburgerClick');
        }
    }
};
</script>
