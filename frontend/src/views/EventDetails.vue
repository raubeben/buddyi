<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Event-Details Test</ion-title>
        <ion-button>
          <ion-back-button default-href="/tabs/events"></ion-back-button>
        </ion-button>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Event-Details</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-item color="secondary">
        <ion-label> Sportart </ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Beschreibung </ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Ort </ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Datum und Zeit </ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Teilnehmende </ion-label>
      </ion-item>

      <header>Am Event teilnehmen</header>
      <ion-button>Anmelden</ion-button>
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
  IonItem,
  IonButton,
  IonBackButton,
} from "@ionic/vue";

export default {
  name: "Profile",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonItem,
    IonButton,
    IonBackButton,
  },
};
</script>
