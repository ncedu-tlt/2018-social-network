<template>
    <v-container>
        <v-layout row>
            <v-flex xs12>
                <ProjectList :user-name="authed"/>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import ProjectList from './ProjectList';
import { mapState } from 'vuex';

export default {
    name: 'ProjectsPage',
    components: {
        ProjectList
    },
    computed: {
        ...mapState('auth', [
            'authed'
        ])
    }
};
</script>

<style scoped>

</style>
