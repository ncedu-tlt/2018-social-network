<template>
    <div>
        <v-app>
            <v-layout row>
                <v-flex xs4 order-md2 order-xs1>
                    <v-card>
                        <v-card-media
                            height="400px"
                            src="https://vuetifyjs.com/static/doc-images/cards/docks.jpg"
                        />
                    </v-card>
                    <v-btn
                        fab
                        dark
                        large
                        color="purple darken-4"
                        class="button-send-message">
                        <v-icon dark>message</v-icon>
                    </v-btn>
                </v-flex>
                <v-flex xs4 order-md3 order-xs2>
                    <v-card height="400px">
                        <v-card-text>
                            <div class="header">
                                <h1>{{ userName }}</h1>
                                <h1>{{ userSurname }}</h1>
                            </div>
                            <div class="link-github-profile">
                                <a>View profile on GitHub</a>
                            </div>
                            <div class="info-area">
                                <div class="list-area">
                                    <div class="list-label">
                                        <h2>Languages:</h2>
                                    </div>
                                    <div class="list">
                                        <li v-for="language in languages" :key="language">
                                            {{ language.name }}
                                        </li>
                                    </div>
                                </div>
                            </div>
                            <div class="list-area">
                                <div class="list-label">
                                    <h2>Preferred technologies:</h2>
                                </div>
                                <div class="list">
                                    <li v-for="technology in technologies" :key="technology">
                                        {{ technology.name }}
                                    </li>
                                </div>
                            </div>
                            <div class="info-job-area">
                                <div class="info-job-label">
                                    <h2>Place of work:</h2>
                                </div>
                                <div class="info-job">
                                    <p>{{ placeOfWork }}</p>
                                </div>
                            </div>
                            <div class="info-job-area">
                                <div class="info-job-label">
                                    <h2>Job:</h2>
                                </div>
                                <div class="info-job">
                                    <p>{{ job }}</p>
                                </div>
                            </div>
                        </v-card-text>
                        <v-card-actions class="profile-action-buttons">
                            <v-btn flat small color="purple darken-4">Follow</v-btn>
                            <v-btn flat small color="purple darken-4">Add to friends</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-app>
    </div>
</template>

<script>
export default {
    name: 'ProfileInfo'
};
</script>
<style scoped>
    h1 {
        margin-right: 3px;
        font-size: 30pt;
        font-family: Arial;
        color: #4A148C;
    }
    h1, li {
        display: inline;
    }
    h2 {
        font-size: 13pt;
        color: #7B1FA2;
    }
    li, p {
        font-size: 13pt;
        color: #8E24AA;
    }
    a {
        color: #6A1B9A;
    }
    .list-label, .list, .info-job-label, .info-job {
        display: inline-block;
        margin-right: 5px;
    }
    .link-github-profile {
        margin-left: 20px;
    }
    .info-area {
        margin-left: 3px;
        margin-top: 10px;
    }
    .profile-action-buttons{
        margin-left: 90px;
        margin-top: 50px;
    }
    .button-send-message {
        background: transparent;
        position: absolute;
        margin-left: 180px;
        margin-top: -40px;
    }
</style>
