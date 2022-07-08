<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Look for Users</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-searchbar type="text" v-model="this.searchable" show-cancel-button="focus" @ionInput="
        searchInput = $event.target.value;
      onInput$.next($event.target.value);" @ionClear="searchCleared($event)">
      </ion-searchbar>
      <ion-list>
        <ion-item :key="user" v-for="user in filterByName" button :router-link="'lookforusers/' + user.benutzername">
          {{ user.vorname }} {{ user.name }}
        </ion-item>
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
import { useUserinformationen } from '@/composables/useUserinformationen';

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
    };
  },

  computed: {
    filterByName() {
      return this.almostalluser.filter(user => user.vorname.concat(" ").concat(user.name).includes(this.searchable))
    }
  },

  setup() {
    const { getUserAlmostAll, almostalluser} = useUserinformationen();

    return {
      getUserAlmostAll,
      almostalluser
    };
  },
};
</script>