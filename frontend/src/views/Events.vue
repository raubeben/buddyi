<template>
  <ion-page>
    <ion-header>
      <ion-toolbar color="secondary">
        <ion-title>Events</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Events</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-list>
        <ion-item>
          <ion-grid>
            <ion-row>
              <ion-col><b>ID</b></ion-col>
              <ion-col><b>Event</b></ion-col>
              <ion-col><b>Beschreibung</b></ion-col>
              <ion-col><b>Ort</b></ion-col>
              <ion-col><b>Teilnehmer</b></ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
        <ion-item :key="veran" v-for="veran in veranstaltungen" button :router-link="'events/' + veran.id">
          <ion-grid>
            <ion-row>
              <ion-col>
                {{ veran.id }}
              </ion-col>
              <ion-col>
                {{ veran.activity }}
              </ion-col>
              <ion-col>
                {{ veran.beschreibung }}
              </ion-col>
              <ion-col>
                {{ veran.ort }}
              </ion-col>
              <ion-col>
                <ul><li :key="user" v-for="user in veran.users">{{user.vorname}}</li></ul>
              </ion-col>
              
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>
      
      <div padding>
        <ion-button router-link="/tabs/events/create">Add New Event</ion-button>
      </div>
      <div padding>
        <ion-img src="assets/img/hintergrund_events.jpg"></ion-img>
      </div>
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
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonImg
} from "@ionic/vue";
import { useVeranstaltungen } from "@/composables/useVeranstaltungen";

export default {
  name: "Events",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCol,
    IonRow,
    IonGrid,
    IonItem,
    IonList,
    IonButton,
    IonImg,
  },
  setup() {
    const { newVeranstaltung, veranstaltungen, getVeranstaltungen, } =
      useVeranstaltungen();

    return { newVeranstaltung, veranstaltungen, getVeranstaltungen };
  }
};
</script>