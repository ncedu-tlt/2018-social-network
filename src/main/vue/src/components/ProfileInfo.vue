<template>
    <v-app>
        <div class="profile-info-area">
            <div class="user-profile-photo-area">
                <UserProfilePhoto/>
            </div>
            <div class="user-info-area">
                <UserInfo/>
            </div>
            <div class="button-send-message-area">
                <ButtonSendMessage/>
            </div>
            <div class="action-profile-buttons">
                <ActionButtonsProfile/>
            </div>
        </div>
    </v-app>
</template>

<script>
import UserInfo from '@/components/UserInfo';
import ButtonSendMessage from '@/components/ButtonSendMessage';
import UserProfilePhoto from '@/components/UserProfilePhoto';
import ActionButtonsProfile from '@/components/ActionButtonsProfile';
export default {
    name: 'ProfileInfo',
    components: {
        UserInfo,
        ButtonSendMessage,
        UserProfilePhoto,
        ActionButtonsProfile
    }
};
</script>
<style scoped>
.profile-info-area {
    width: auto;
    height: 450px;
    padding: 10px;
    margin: auto;
    box-shadow: 5px 3px 3px lightgrey;
}
.user-info-area {
    margin-left: 15px;
    float: right;
}
.button-send-message-area {
    position: absolute;
    margin-top: 320px;
    margin-left: 50px;
}
.user-profile-photo-area {
    float: left;
    margin-top: 10px;
}
.action-profile-buttons {
    position: relative;
    bottom: -120px;
    right: 0px;
    left: 120px;
}
</style>
