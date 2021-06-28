<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Todos</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Todos</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list>
        <ion-item :key="todo" v-for="todo in todos">
          <ion-grid>
            <ion-row>
              <ion-col>
                {{ todo.title }}
              </ion-col>
              <ion-col>
                <ion-button
                  color="danger"
                  v-if="!todo.done && !todo.archived"
                  @click="finishTodo(todo)"
                  >Finish</ion-button
                >
                <ion-button
                  color="success"
                  v-if="todo.done && !todo.archived"
                  @click="archive(todo)"
                  >Archive</ion-button
                >
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>
      <!--       <ion-item>
        <ion-input
          type="text"
          placeholder="New Todo Title"
          v-model="newToDo.title"
        ></ion-input>
      </ion-item> -->
      <!--       <div padding>
        <ion-button @click="addToDo()">Add New ToDo</ion-button>
      </div> -->
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
} from /*   IonInput,
 */ "@ionic/vue";
import { useTodos } from "@/composables/useTodos";

export default {
  name: "Todo",
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
    /*     IonInput,
     */
  },
  setup() {
    const { todos, getTodos, addTodo, finishTodo } = useTodos();

    return { todos, getTodos, addTodo, finishTodo };
  },
};
</script>