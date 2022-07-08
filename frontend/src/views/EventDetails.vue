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

      <ion-button v-if="!isHidden" color="success" @click="updateParticipant(veranstaltung); submitAlert(); hideButton()">
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
import { useUserinformationen } from "@/composables/useUserinformationen";
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

  data() {
    return {
      isHidden: false,
    };
  },

  methods: {
    async submitAlert() {
      const alert = await alertController.create({
        header: "Event-Anmeldung",
        subHeader: "",
        message: "Erfolgreich angemeldet! Sie werden in Kürze weitergeleitet.",
      });
      await alert.present();
      setTimeout(() => {this.reloadPage();},3000);
    },

    reloadPage() {
      window.location.reload();
    },

    hideButton(){
      this.getVeranstaltungId(this.id);
      this.getUserinform();
      for(let i = 0; i < Object.keys(this.veranstaltung.users).length; i++){
        let condition = false;
        
        if (this.usrinform.benutzername == this.veranstaltung.users[i].benutzername) {
          condition = true;
        }

        if (condition) {
          this.isHidden = true;
        }
      }
    },
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

    const {
      usrinform,
      getUserinform
    } = useUserinformationen();

    return {
      veranstaltung,
      getVeranstaltungId,
      id,
      updateParticipant,
      veranstaltungen,
      getVeranstaltungen,
      addVeranstaltung,
      usrinform,
      getUserinform,
    };
  },
  mounted() {
    this.getVeranstaltungId(this.id).then(this.hideButton);
  },
};
</script>