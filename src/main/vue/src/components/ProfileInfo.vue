<template>
    <v-app>
        <v-container>
            <v-flex xs7 offset-xs0 offset-md2 offset-lg5>
                <div class="header">
                    <h1>{{ userName }}</h1>
                    <h1>{{ userSurname }}</h1>
                </div>
                <div class="link-github-profile">
                    <a>View profile on GitHub</a>
                </div>
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
                        <h3>{{ placeOfWork }}</h3>
                    </div>
                </div>
                <div class="info-job-area">
                    <div class="info-job-label">
                        <h2>Job:</h2>
                    </div>
                    <div class="info-job">
                        <h3>{{ job }}</h3>
                    </div>
                </div>
            </v-flex>
        </v-container>
    </v-app>
</template>

<script>
export default {
    name: 'ProfileInfo',
    data() {
        return {
            userName: 'Temp',
            userSurname: 'Temp',
            languages: [
                {name: 'Java'},
                {name: 'PHP'},
                {name: 'JavaScript'}
            ],
            technologies: [
                {name: 'Spring'},
                {name: 'Vue'},
                {name: 'Hibernate'}
            ],
            placeOfWork: 'Some company',
            job: 'Software Engineer'
        };
    }
};
</script>
<style scoped>
h1, li {
    display: inline;
}
.list-label, .list, .info-job-label, .info-job {
    display: inline-block;
}
</style>
