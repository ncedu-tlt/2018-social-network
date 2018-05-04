<template>
    <v-card tile height="100%">
        <v-card-title primary-title>
            <div v-if="chatId">
                {{ chatId }}
            </div>
            <div v-else>
                Select chat...
            </div>
        </v-card-title>
    </v-card>
</template>
<script>
export default {
    name: 'Chat',
    props: {
        chatId: {
            type: String,
            required: false,
            default: ''
        }
    }
};
</script>
