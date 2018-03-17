<template>
    <div class="user-info-area">
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
        </div>
    </div>
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
        margin-right: 3px;
        font-size: 30pt;
        color: #4A148C;
    }
    h1, li {
        display: inline;
    }
    h2 {
        color: #7B1FA2;
    }
    li, p {
        font-size: 14pt;
        color: #8E24AA;
    }
    a {
        color: #6A1B9A;
    }
    span {
        font-style: normal;
        color: #FFFFFF;
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
</style>
