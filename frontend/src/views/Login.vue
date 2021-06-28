<template>
  <ion-page>
    <ion-content :fullscreen="true" padding>
      <ion-grid>
        <ion-row justify-content-center>
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
            <div text-center>
              <h1>LeanTodo login</h1>
            </div>
            <div padding>
              <ion-item>
                <ion-input
                  type="text"
                  placeholder="Login Name"
                  v-model="username"
                ></ion-input>
              </ion-item>
              <ion-item>
                <ion-input
                  type="password"
                  placeholder="Password"
                  v-model="password"
                ></ion-input>
              </ion-item>
            </div>
            <div padding>
              <ion-button size="large" @click="login" expand="block"
                >Login</ion-button
              >
            </div>
          </ion-col>
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonPage,
  IonContent,
  IonInput,
  IonRow,
  IonCol,
  IonGrid,
  IonButton,
  IonItem,
} from "@ionic/vue";
import { useLogin } from "@/composables/useLogin";

export default {
  name: "Login",
  components: {
    IonContent,
    IonPage,
    IonInput,
    IonRow,
    IonCol,
    IonGrid,
    IonButton,
    IonItem,
  },

  setup() {
    const { username, password, login } = useLogin();
    return { username, password, login };
  },
};
</script>