<template>
    <v-layout align-center column>
        <v-card class="card-width">
            <v-card-media
                class="cover"
                height="180px"
                src="https://vuetifyjs.com/static/doc-images/cards/docks.jpg"
            >
                <v-btn
                    v-if="profile.name != userName"
                    color="deep-purple darken-4"
                    dark
                    absolute
                    bottom
                    left
                    fab
                >
                    <v-icon dark>add</v-icon>
                </v-btn>
                <v-btn
                    v-if="profile.name != userName"
                    color="deep-purple darken-4"
                    dark
                    absolute
                    bottom
                    right
                    fab
                >
                    <v-icon dark>message</v-icon>
                </v-btn>
                <v-layout align-center column class="avatar-position">
                    <v-avatar size="145px">
                        <img src="https://vuetifyjs.com/static/doc-images/john.jpg">
                    </v-avatar>
                </v-layout>
            </v-card-media>
            <v-layout align-center column class="name-area-position">
                <h1 class="display-2 primary--text darken-4">
                    {{ profile.name }}
                </h1>
                <a class="subheading primary--text darken-0">
                    View profile on GitHub
                </a>
            </v-layout>
        </v-card>
        <v-card class="card-width mt-3">
            <v-list subheader>
                <v-subheader class="title primary--text darken-3">
                    Languages
                </v-subheader>
                <v-list-tile
                    v-for="language in profile.languages"
                    :key="language"
                >
                    <v-list-tile-content>
                        <v-list-tile-title class="body-1 primary--text darken-0">{{ language }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-card>
        <v-card class="card-width mt-3">
            <v-list subheader>
                <v-subheader class="title primary--text darken-3">
                    Preferred technologies
                </v-subheader>
                <v-list-tile
                    v-for="technology in profile.technologies"
                    :key="technology"
                >
                    <v-list-tile-content>
                        <v-list-tile-title class="body-1 primary--text darken-0">{{ technology }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-card>
        <v-card class="card-width mt-3">
            <v-list subheader>
                <v-subheader class="title primary--text darken-3">
                    Place of work
                </v-subheader>
                <v-list-tile>
                    <v-list-tile-content>
                        <v-list-tile-title class="body-1 primary--text darken-0">{{ profile.placeOfWork }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-card>
        <v-card class="card-width mt-3">
            <v-list subheader>
                <v-subheader class="title primary--text darken-3">
                    Job
                </v-subheader>
                <v-list-tile>
                    <v-list-tile-content>
                        <v-list-tile-title class="body-1 primary--text darken-0">{{ profile.job }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-card>
    </v-layout>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: 'ProfileInfo',
    computed: {
        ...mapState('profile', ['profile']),
        ...mapState('auth', ['userName'])
    }
};
</script>

<style scoped>
    .avatar-position {
        margin-top: 100px;
    }
    .name-area-position {
        margin-top: 70px;
    }
    .card-width {
        width: 700px;
        max-width: 100%;
    }
    .cover {
        overflow: inherit;
    }
</style>
