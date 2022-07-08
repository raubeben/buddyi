<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>
                <ion-button slot="start">
                    <ion-back-button default-href="/tabs/events"></ion-back-button>
                </ion-button>
                <ion-title slot="end"><i>{{ otherusrinform.vorname }}</i></ion-title>
                <!-- Profilbild -->
                <ion-item>
                    <!-- User Information via @/composables/useUserinformationen -->
                    <ion-label></ion-label>
                    <ion-avatar slot="end">
                        <ion-img src="assets/img/ppic.png"></ion-img>
                    </ion-avatar>
                </ion-item>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <ion-header collapse="condense">
                <ion-title slot="end"><i></i></ion-title>
            </ion-header>
            <!-- Event-Titel -->
            <ion-item>
                <ion-list-header color="primary"><b>Eingetragene Events</b></ion-list-header>
            </ion-item>
            <!-- Liste der Events -->
            <ion-list>
                <ion-item>
                    <ion-grid>
                        <!-- Ueberschrift der Listenelemente-->
                        <ion-row>
                            <ion-col><b>Sportart</b></ion-col>
                            <ion-col><b>Beschreibung</b></ion-col>
                            <ion-col><b>Wo</b></ion-col>
                            <ion-col><b>Wann</b></ion-col>
                            <ion-col><b>{{otherusrinform}}</b></ion-col>
                        </ion-row>
                    </ion-grid>
                </ion-item>
            </ion-list>
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
    IonListHeader,
    IonButton,
    IonBackButton
} from '@ionic/vue';
import { useUserinformationen } from '@/composables/useUserinformationen';
import { useRoute } from "vue-router";

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
        IonListHeader,
        IonButton,
        IonBackButton
    },
    methods: {
        reloadPage() {
            window.location.reload();
        },
    },
    setup() {
        const {
            otherusrinform,
            getOtherUserinform
        } = useUserinformationen();

        const route = useRoute();
        const { otheruserid } = route.params;

        return {
            otherusrinform,
            getOtherUserinform,
            otheruserid
        }
    },
    mounted() {
        this.getOtherUserinform(this.otheruserid);
    },
};
</script>