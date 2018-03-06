<template>
    <v-toolbar dark color="primary" fixed app>
        <v-toolbar-side-icon/>
        <v-toolbar-title>Dev Comrades</v-toolbar-title>
        <v-spacer/>
        <v-btn icon>
            <v-icon>search</v-icon>
        </v-btn>
        <Auth/>
    </v-toolbar>
</template>
<script>
import Auth from '@/components/Auth';

export default {
    name: 'NavBar',
    components: { Auth }
};
</script>
