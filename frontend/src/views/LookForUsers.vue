<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Look for Users</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-searchbar></ion-searchbar>
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
  IonSearchbar
} from "@ionic/vue";

export default {
  name: "LookForUsers",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonSearchbar
  },
  dummyData: "Dummy",
  data() {
    return {
      users: [
        { benutzername: "user", name: "Mario" },
        { benutzername: "derMensch", name: "Paulo" },
        { benutzername: "derAlien", name: "Erika" },
      ],
    };
  },
  setup() {
    //const { } = useTodos();

    return {};
  },
};
</script>