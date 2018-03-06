<template>
    <v-container>
        <div id="head">
            <h1>{{ userName }}</h1>
            <h1>{{ userSurname }}</h1>
        </div>
        <div>
            <h2>Languages:</h2>
            <li v-for="language in languages" :key="language">
                {{ language.name }}
            </li>
        </div>
        <div>
            <h2>Preferred technologies:</h2>
            <li v-for="technology in technologies" :key="technology">
                {{ technology.name }}
            </li>
        </div>
        <div>
            <h2>Place of work:</h2>
            <p>{{ placeOfWork }}</p>
        </div>
        <div>
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
