<template>
    <div>
        <v-app>
            <v-layout row>
                <v-flex xs4 order-md2 order-xs1>
                    <UserProfilePhoto/>
                    <ButtonSendMessage class="button-send-message"/>
                </v-flex>
                <v-flex xs4 order-md3 order-xs2>
                    <UserInfo/>
                </v-flex>
            </v-layout>
        </v-app>
    </div>
</template>

<script>
import UserProfilePhoto from '@/components/UserProfilePhoto';
import UserInfo from '@/components/UserInfo';
import ButtonSendMessage from '@/components/ButtonSendMessage';
export default {
    name: 'ProfileInfo',
    components: {
        UserProfilePhoto,
        UserInfo,
        ButtonSendMessage
    }
};
</script>
<style scoped>
    .button-send-message {
        background: transparent;
        position: absolute;
        margin-left: 180px;
        margin-top: -40px;
    }
</style>
