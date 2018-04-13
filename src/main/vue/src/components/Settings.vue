<template>
    <v-card class="mx-5 mt-5">
        <v-card-title>
            <div>
                <v-label>Show/Hide params on profile-page</v-label>
            </div>
        </v-card-title>
        <v-divider/>
        <v-card-title>
            <div>
                <v-btn class="success" @click="showLanguage = !showLanguage">Language</v-btn>
            </div>
        </v-card-title>
        <v-select v-show="showLanguage"/>
        <v-divider/>
        <v-card-title>
            <v-btn class="error" @click="showDelete = !showDelete">Delete Profile</v-btn>
        </v-card-title>
        <v-text-field label="Enter DELETE ACCOUNT to confirm." v-show="showDelete"/>
    </v-card>
</template>

<script>
export default {
    name: 'Settings',
    data() {
        return {
            showDelete: false,
            showLanguage: false
        };
    }
};
</script>

<style scoped>
</style>
