<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Event Details: <i>{{ veranstaltung.activity }} in {{ veranstaltung.ort }}</i></ion-title>
        <ion-button slot="start">
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

      <ion-item color="primary">
        <ion-label> Sportart: {{ veranstaltung.activity }}</ion-label>
      </ion-item>
      <ion-item color="secondary">
        <ion-label> Beschreibung: {{ veranstaltung.beschreibung }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label> Ort: {{ veranstaltung.ort }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label> Datum und Zeit: {{ veranstaltung.datum }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label> Teilnehmer: </ion-label>
        <ul>
          <li :key="user" v-for="user in veranstaltung.users">
            {{ user.vorname }}
          </li>
        </ul>
      </ion-item>

      <ion-button color="success" @click="updateParticipant(veranstaltung); submitAlert(); reloadPage()">
        <strong>Am Event teilnehmen</strong>
      </ion-button>
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
        header: "Event-Anmeldung",
        subHeader: "",
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
    const {
      veranstaltung,
      getVeranstaltungId
    } = useVeranstaltungById();

    const {
      veranstaltungen,
      getVeranstaltungen,
      addVeranstaltung,
      updateParticipant,
    } = useVeranstaltungen();

    const route = useRoute();
    const { id } = route.params;
          console.log("URL-Eventdet.: ")
        console.log(route)
        console.log("PARAMETER-Eventdet.: ")
        console.log(id)

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