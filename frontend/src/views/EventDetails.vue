<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Event Details - {{ veranstaltung.activity }} in {{ veranstaltung.ort }}</ion-title>
        <ion-back-button slot="start" default-href="/tabs/events"></ion-back-button>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Event-Details</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list-header class="basicHeader"> Sportart: {{ veranstaltung.activity }}</ion-list-header>
      <ion-item>
        <ion-label><b>Beschreibung:</b> {{ veranstaltung.beschreibung }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label><b>Ort:</b> {{ veranstaltung.ort }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label><b>Datum und Zeit:</b> {{ new Date(veranstaltung.datum).toString().split('G')[0] }}</ion-label>
      </ion-item>
      <ion-item>
        <ion-label><b>Teilnehmer: </b>
          <ul>
            <li :key="user" v-for="user in veranstaltung.users">
              {{ user.vorname }} {{ user.name }}
            </li>
          </ul>
        </ion-label>
      </ion-item>

      <ion-button class="basicButton" v-if="!isHidden"
        @click="updateParticipant(veranstaltung); submitAlert(); hideButton()">
        <strong>Teilnehmen</strong>
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
        header: "Erfolgreich!",
        subHeader: "",
        message: "Erfolgreich angemeldet! Sie werden in Kürze weitergeleitet...",
      });
      await alert.present();
      setTimeout(() => { this.reloadPage(); }, 2000);
    },

    reloadPage() {
      window.location.reload();
    },

    hideButton() {
      this.getVeranstaltungId(this.id);
      this.getUserinform();
      for (let i = 0; i < Object.keys(this.veranstaltung.users).length; i++) {
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
    console.log("URL-Eventdet.: ")
    console.log(route)
    console.log("PARAMETER-Eventdet.: ")
    console.log(id)

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