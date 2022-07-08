<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Profil</ion-title>
        <ion-item class="basicProfile" slot="end">
          <ion-avatar>
            <ion-img src="assets/img/ppic.png"></ion-img>
          </ion-avatar>
          <!-- User Information via @/composables/useUserinformationen -->
          <ion-label slot="end"
            >{{ usrinform.vorname }} {{ usrinform.name }}</ion-label
          >
        </ion-item>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Profil</ion-title>
        </ion-toolbar>
      </ion-header>
      <!-- Profilbild -->

      <!-- Badge -->
      <!-- TODO: Anzahl Events als Counter -->

      <!-- Event-Titel -->

      <ion-list-header class="basicHeader">Bevorstehende Events: {{ veranstaltungen.length }}
        </ion-list-header>

      <!-- Liste der Events -->
      <ion-list>
        <ion-item>
          <ion-grid>
            <!-- Ueberschrift der Listenelemente-->
            <ion-row>
              <ion-col><b>Sportart</b></ion-col>
              <ion-col><b>Beschreibung</b></ion-col>
              <ion-col><b>Wo</b></ion-col>
              <ion-col><b>Wann</b></ion-col>
              <ion-col><b>Event entfernen</b></ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
        <!-- Alle eingetragenen Events als Liste via @/composables/useVeranstaltungenUser -->
        <ion-item v-bind:key="uevent" v-for="uevent in veranstaltungen">
          <ion-grid>
            <ion-row>
              <ion-col>
                {{ uevent.activity }}
              </ion-col>
              <ion-col>
                {{ uevent.beschreibung }}
              </ion-col>
              <ion-col>
                {{ uevent.ort }}
              </ion-col>
              <ion-col>
                {{ new Date(uevent.datum).toString().split('G')[0] }}
              </ion-col>
              <ion-col>
                <ion-button class="basicButton"
                  @click="
                    delParticipant(uevent.id);
                    reloadPage();
                  "
                >
                  Löschen
                </ion-button>
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>
      <div padding>
        <ion-img style="width: auto; height: 500px;" src="assets/img/profile.png"></ion-img>
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
  IonImg,
  IonLabel,
  IonItem,
  IonAvatar,
  IonListHeader,
  IonGrid,
  IonRow,
  IonCol,
} from "@ionic/vue";
import { useVeranstaltungenUser } from "@/composables/useVeranstaltungenUser";
import { useUserinformationen } from "@/composables/useUserinformationen";
import { delUser } from "@/composables/delUser";

export default {
  name: "Profile",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonImg,
    IonLabel,
    IonItem,
    IonAvatar,
    IonListHeader,
    IonGrid,
    IonRow,
    IonCol,
  },
  methods: {
    reloadPage() {
      window.location.reload();
    },
  },
  setup() {
    const { veranstaltungen, getVeranstaltungen } = useVeranstaltungenUser();

    const { usrinform, getUserinform } = useUserinformationen();

    const { delParticipant } = delUser();

    return {
      veranstaltungen,
      getVeranstaltungen,
      usrinform,
      getUserinform,
      delParticipant,
    };
  },
};
</script>