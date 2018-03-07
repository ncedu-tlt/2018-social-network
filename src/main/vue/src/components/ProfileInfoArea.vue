<template>
    <v-container>
        <UserInfo/>
        <ButtonSendMessage/>
    </v-container>
</template>

<script>
import UserInfo from '@/components/UserInfo';
/* import UserPhoto from '@/components/UserPhoto'; */
import ButtonSendMessage from '@/components/ButtonSendMessage';
export default {
    name: 'ProfileInfo',
    components: {
        UserInfo,
        ButtonSendMessage
    }
};
</script>
