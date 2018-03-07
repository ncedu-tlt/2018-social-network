<template>
    <v-container>
        <div class="header">
            <h1>{{ userName }}</h1>
            <h1>{{ userSurname }}</h1>
        </div>
        <div class="link-github-profile">
            <a>View profile on GitHub</a>
        </div>
        <div class="languages-list">
            <h2>Languages:</h2>
            <li v-for="language in languages" :key="language">
                {{ language.name }}
            </li>
        </div>
        <div class="list-technologies">
            <h2>Preferred technologies:</h2>
            <li v-for="technology in technologies" :key="technology">
                {{ technology.name }}
            </li>
        </div>
        <div class="info-job-block">
            <h2>Place of work:</h2>
            <p>{{ placeOfWork }}</p>
            <h2>Job:</h2>
            <p>{{ job }}</p>
        </div>
    </v-container>
</template>

<script>
export default {
    name: 'UserInfo',
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
h1 {
    display: inline;
}
li {
    display: inline;
}
</style>
