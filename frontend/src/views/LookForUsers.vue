<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Look for Users</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <p>{{ fessa }}</p>
      <ion-searchbar
        type="text"
        v-model="this.searchable"
        @ionInput="
          searchInput = $event.target.value;
          onInput$.next($event.target.value);
        "
        @ionClear="searchCleared($event)"
      >
      </ion-searchbar>
      <p>{{ selectedUser }}</p>
      <ion-list>
        <ion-item v-bind:key="user" v-for="user in filterByName">{{
          user.benutzername
        }}</ion-item>
      </ion-list>
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
  IonSearchbar,
  IonItem,
  IonList,
} from "@ionic/vue";
//import { useLookForUsers } from "@/composables/useLookForUsers";

export default {
  name: "LookForUsers",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonSearchbar,
    IonItem,
    IonList,
  },
  data() {
    return {
      searchable: "",
      users: [
        { benutzername: "user", name: "Mario" },
        { benutzername: "derMensch", name: "Paulo" },
        { benutzername: "derAlien", name: "Erika" },
      ],
    };
  },

  methods: {
    
  },

  computed: {
    filterByName(){
      return this.users.filter(user => user.benutzername.includes(this.searchable))
    }
  },

  setup() {
    //const {selectedUser} = useLookForUsers;

    return {
      //selectedUser
    };
  },
};
</script>