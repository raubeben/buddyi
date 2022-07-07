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
        <ion-label> Sportart: {{ veranstaltung.activity }}</ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Beschreibung: {{ veranstaltung.beschreibung }}</ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Ort: {{ veranstaltung.ort }}</ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Datum und Zeit: {{ veranstaltung.datum }}</ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label>Teilnehmer:</ion-label>
        <ul>
          <li :key="user" v-for="user in veranstaltung.users">
            {{ user.vorname }}
          </li>
        </ul>
      </ion-item>

      <header>Am Event teilnehmen</header>
      <ion-button @click="updateParticipant(veranstaltung); submitAlert(); reloadPage()"
        >Anmelden</ion-button
      >
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
  IonItem,
  IonButton,
  IonBackButton,
  alertController,
} from "@ionic/vue";

import { useVeranstaltungById } from "@/composables/useVeranstaltungById";
import { useVeranstaltungen } from "@/composables/useVeranstaltungen";
import { useRoute } from "vue-router";

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

  methods: {
    async submitAlert() {
      const alert = await alertController.create({
        header: "Alert",
        subHeader: "Important message",
        message: "Erfolgreich angemeldet!",
        buttons: ["OK"],
      });

      await alert.present();
    },
    reloadPage() {
      window.location.reload();
    }
  },
  setup() {
    const { veranstaltung, getVeranstaltungId } = useVeranstaltungById();

    const {
      veranstaltungen,
      getVeranstaltungen,
      addVeranstaltung,
      updateParticipant,
    } = useVeranstaltungen();

    const route = useRoute();

    const { id } = route.params;

    return {
      veranstaltung,
      getVeranstaltungId,
      id,
      updateParticipant,
      veranstaltungen,
      getVeranstaltungen,
      addVeranstaltung,
    };
  },
  mounted() {
    this.getVeranstaltungId(this.id);
  },
  
};
</script>
