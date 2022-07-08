<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>
                <ion-button slot="start">
                    <ion-back-button default-href="/tabs/events"></ion-back-button>
                </ion-button>
                
                <!-- Profilbild -->
                <ion-item>
                    <!-- User Information via @/composables/useUserinformationen -->
                    <ion-label></ion-label>
                    <ion-avatar slot="end">
                        <ion-img src="assets/img/ppic.png"></ion-img>
                    </ion-avatar>
                    <ion-label slot="end"><i> Profil von {{ otherusrinform.vorname }}</i></ion-label>
                </ion-item>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <ion-header collapse="condense">
                <ion-title slot="end"><i>User-Info</i></ion-title>
            </ion-header>
            <ion-item color="primary">
                <ion-label> Name: {{ otherusrinform.vorname }} {{ otherusrinform.name }}</ion-label>
            </ion-item>
            <ion-item color="secondary">
                <ion-label> Geschlecht: {{ otherusrinform.geschlecht }}</ion-label>
            </ion-item>
            <ion-item>
                <ion-label> Kontakt: {{ otherusrinform.telefonnummer }}</ion-label>
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
    IonButton,
    IonBackButton,
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
        IonButton,
        IonBackButton
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