<template>
    <v-container>
        <v-layout>
            <ProfileInfo/>
        </v-layout>
    </v-container>
</template>

<script>
import ProfileInfo from './ProfileInfo';
export default {
    name: 'ProfilePage',
    components: {
        ProfileInfo
    }
};
</script>
