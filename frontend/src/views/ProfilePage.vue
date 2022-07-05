<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Profil</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Profil</ion-title>
        </ion-toolbar>
      </ion-header>
      <!-- Profilbild -->
      <ion-item>
        <ion-avatar slot="start">
          <ion-img src="assets/img/ppic.png"></ion-img>
        </ion-avatar>
        <!-- User Information via @/composables/useUserinformationen -->
        <ion-label>{{ usrinform.vorname }} {{ usrinform.name }}</ion-label>
      </ion-item>
      <!-- Badge -->
      <!-- TODO: Anzahl Events als Counter -->
      <ion-item>
        <ion-badge color="success"> Anzahl eingetragener Events: </ion-badge>
      </ion-item>
      <!-- Event-Titel -->
      <ion-item>
        <ion-list-header color="primary"><b>Bevorstehende Events</b></ion-list-header>
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
            </ion-row>
          </ion-grid>
        </ion-item>
        <!-- Alle eingetragenen Events als Liste via @/composables/useVeranstaltungenUser -->
        <!-- TODO: Router link noch einfügen: :router-link="'/tabs/tasks/' + task._id" bsp. von task-list-->
        <ion-item button v-bind:key="uevent" v-for="uevent in veranstaltungen">
          <ion-label>{{ uevent.activity }}</ion-label>
          <ion-label>{{ uevent.beschreibung }}</ion-label>
          <ion-label>{{ uevent.ort }}</ion-label>
          <ion-label>{{ uevent.datum }}</ion-label>
        </ion-item>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonImg,
  IonLabel,
  IonBadge,
  IonItem,
  IonAvatar,
  IonListHeader
} from '@ionic/vue';
import { useVeranstaltungenUser } from '@/composables/useVeranstaltungenUser';
import { useUserinformationen } from '@/composables/useUserinformationen';

export default {
  name: 'Profile',
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonImg,
    IonLabel,
    IonBadge,
    IonItem,
    IonAvatar,
    IonListHeader
  },
  setup() {
    const {
      veranstaltungen,
      getVeranstaltungen
    } = useVeranstaltungenUser();

    const {
      usrinform,
      getUserinform
    } = useUserinformationen();

    return {
      veranstaltungen,
      getVeranstaltungen,
      usrinform,
      getUserinform
    }
  },
};
</script>