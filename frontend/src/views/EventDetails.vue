<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Event-Details</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Todos</ion-title>
        </ion-toolbar>
      </ion-header>
     
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
  
} from "@ionic/vue";
import { useTodos } from "@/composables/useTodos";
import { useRoute } from "vue-router";

export default {
  name: "Todo",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
  },
  setup() {
    const { newTodo, todos, getTodos, addTodo, finishTodo, archiveTodo } = useTodos();
    const route = useRoute();


    return { newTodo, todos, getTodos, addTodo, finishTodo, archiveTodo };
  },
};
</script>