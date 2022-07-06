<template>
  <ion-page>
    <ion-header>
      <ion-toolbar color="secondary">
        <ion-title>Create New Event</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Create New Event</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-list>
        <ion-item>
          <ion-grid>
            <ion-row>
              <ion-col>
                <ion-label> Titel </ion-label>
              </ion-col>
              <ion-col>
                <ion-input
                  type="text"
                  placeholder="Event Titel"
                  v-model="newVeranstaltung.activity"
                ></ion-input>
              </ion-col>
            </ion-row>
            <ion-row>
              <ion-col>
                <ion-label> Beschreibung </ion-label>
              </ion-col>
              <ion-col>
                <ion-input
                  type="text"
                  placeholder="Event Beschreibung"
                  v-model="newVeranstaltung.beschreibung"
                ></ion-input>
              </ion-col>
            </ion-row>
            <ion-row>
              <ion-col>
                <ion-label> Ort </ion-label>
              </ion-col>
              <ion-col>
                <ion-input
                  type="text"
                  placeholder="Eventlocation"
                  v-model="newVeranstaltung.ort"
                ></ion-input>
              </ion-col>
            </ion-row>
            <ion-row>
              <ion-col>
                <ion-label> Datum </ion-label>
              </ion-col>
              <ion-col>
                <ion-input
                  type="date"
                  placeholder="Event-Datum"
                  v-model="newVeranstaltung.datum"
                ></ion-input>
              </ion-col>
        
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>

      <div padding>
        <ion-button @click="addVeranstaltung()">Create</ion-button>
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
  IonButton,
  IonList,
  IonItem,
  IonGrid,
  IonRow,
  IonLabel,
  IonInput
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
    IonButton,
    IonList,
    IonItem,
    IonGrid,
    IonRow,
    IonLabel,
    IonInput
  },
  setup() {
    const { newVeranstaltung, veranstaltungen, getVeranstaltungen, addVeranstaltung } =
      useVeranstaltungen();

    return { newVeranstaltung, veranstaltungen, getVeranstaltungen, addVeranstaltung };
  },
};
</script>