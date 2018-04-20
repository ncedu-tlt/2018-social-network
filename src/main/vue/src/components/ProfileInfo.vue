<template>
    <v-container>
        <v-layout align-center column>
            <v-flex>
                <v-card class="card-width card-height">
                    <v-card-media
                        height="180px"
                        src="https://vuetifyjs.com/static/doc-images/cards/docks.jpg"
                    />
                    <v-layout align-center column class="name-area-position">
                        <h1 class="display-1" color="deep-purple darken-4">
                            {{ profile.name }}
                        </h1>
                        <a class="subheading" color="deep-purple darken-0">
                            View profile on GitHub
                        </a>
                    </v-layout>
                </v-card>
            </v-flex>
            <div class="card-width div-position">
                <v-layout row justify-space-around align-center>
                    <v-flex xs2 class="ml-5 mb-2">
                        <v-btn fab dark color="deep-purple darken-4">
                            <v-icon dark>add</v-icon>
                        </v-btn>
                    </v-flex>
                    <v-flex xs2 algin-center class="avatar-position mb-3">
                        <v-avatar size="150px">
                            <img src="https://vuetifyjs.com/static/doc-images/john.jpg">
                        </v-avatar>
                    </v-flex>
                    <v-flex xs2 class="mb-2">
                        <v-btn fab dark color="deep-purple darken-4">
                            <v-icon dark>message</v-icon>
                        </v-btn>
                    </v-flex>
                </v-layout>
            </div>
            <v-flex>
                <v-card class="card-width">
                    <v-list two-line>
                        <v-list-tile avatar>
                            <v-list-tile-content>
                                <v-list-tile-title class="title">
                                    Languages:
                                </v-list-tile-title>
                                <v-list-tile-sub-title
                                    v-for="language in profile.languages"
                                    :key="language"
                                    class="body-2">
                                    {{ language }}
                                </v-list-tile-sub-title>
                            </v-list-tile-content>
                        </v-list-tile>
                        <v-list-tile avatar>
                            <v-list-tile-content>
                                <v-list-tile-title class="title">
                                    Preferred technologies:
                                </v-list-tile-title>
                                <v-list-tile-sub-title
                                    v-for="technology in profile.technologies"
                                    :key="technology"
                                    class="body-2">
                                    {{ technology }}
                                </v-list-tile-sub-title>
                            </v-list-tile-content>
                        </v-list-tile>
                    </v-list>
                </v-card>
            </v-flex>
            <v-flex>
                <v-card class="card-width">
                    <v-card-text>
                        <h2 class="title" color="deep-purple darken-3">Place of work</h2>
                        <p class="body-2">{{ profile.placeOfWork }}</p>
                        <h2 class="title" color="deep-purple darken-3">Job</h2>
                        <p class="body-2">{{ profile.job }}</p>
                    </v-card-text>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: 'ProfileInfo',
    computed: {
        ...mapState('profile', ['profile'])
    }
};
</script>

<style scoped>
    .div-position {
        position: absolute;
        margin-top: 100px;
    }
    .name-area-position {
        margin-top: 80px;
    }
    .avatar-position {
        margin-right: 80px;
    }
    .card-width {
        width: 700px;
        max-width: 100%;
    }
    .card-height {
        height: 700px;
        max-height: 100%;
    }
</style>
