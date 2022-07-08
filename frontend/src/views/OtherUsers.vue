<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>         
                    <ion-back-button slot="start" default-href="/tabs/events"></ion-back-button>            
                <!-- Profilbild -->
                <ion-item class="basicProfile">
                    <!-- User Information via @/composables/useUserinformationen -->
                    <ion-avatar slot="end">
                        <ion-img src="assets/img/ppic.png"></ion-img>
                    </ion-avatar>
                    <ion-label slot="end"> Profil von {{ otherusrinform.vorname }}</ion-label>
                </ion-item>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <ion-header collapse="condense">
                <ion-title slot="end"><i>User-Info</i></ion-title>
            </ion-header>
                <ion-list-header class="basicHeader"> {{ otherusrinform.vorname }} {{ otherusrinform.name }}</ion-list-header>
            <ion-item>
                <ion-label><b>Geschlecht: </b> {{ otherusrinform.geschlecht }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label> <b>Kontakt: </b>{{ otherusrinform.telefonnummer }}</ion-label>
            </ion-item>
        </ion-content>
    </ion-page>
</template>

<script>
import {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonImg,
    IonLabel,
    IonItem,
    IonAvatar,
    IonBackButton,
    IonListHeader
} from '@ionic/vue';
import { useUserinformationen } from '@/composables/useUserinformationen';
import { useRoute } from 'vue-router';

export default {
    name: 'OtherUsers',
    components: {
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonPage,
        IonImg,
        IonLabel,
        IonItem,
        IonAvatar,
        IonBackButton,
        IonListHeader
    },
    setup() {
        const route = useRoute();
        const { user } = route.params;

        const {
            otherusrinform,
            getOtherUserinform
        } = useUserinformationen();

        return {
            otherusrinform,
            getOtherUserinform,
            user
        }
    },
    mounted() {
        this.getOtherUserinform(this.user);
    },
};
</script>