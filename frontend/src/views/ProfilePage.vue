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

      <!-- Profil Page Layout -->
      <!-- Profilbild -->
      <ion-img style="width: 100px; height: 100px;" src="assets/img/ppic.png"></ion-img>

      <!-- User Information (ev. Name auslesen aus DB) -->
      <ion-item>
        <p>Vorname</p>
        <p>Nachname</p>
      </ion-item>

      <!-- Event Titel mit Badge -->
      <ion-item>
        <ion-label><b>Bevorstehende Events</b></ion-label>
        <ion-badge slot="end">Anzahl eingetragener Events: </ion-badge>
      </ion-item>

      <!-- Liste der Events -->
      <ion-list>
        <ion-item>
          <ion-grid>
            <!-- Beschreibung der Listenelemente-->
            <ion-row>
              <ion-col><b>Sportart</b></ion-col>
              <ion-col><b>Beschreibung</b></ion-col>
              <ion-col><b>Wo</b></ion-col>
              <ion-col><b>Wann</b></ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
        <!-- Alle eingetragenen Events als Liste-->
        <!-- Router link noch einfügen: :router-link="'/tabs/tasks/' + task._id" bsp. von task-list-->
        <ion-item button v-bind:key="uevent" v-for="uevent in veranst">
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
  IonItem
} from '@ionic/vue';
import { getVeranstaltung } from '@/composables/getVeranstaltung';

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
    IonItem
  },
  setup() {
    const { veranst } = getVeranstaltung();

    return { veranst }
  },
};
</script>