<template>
  <ion-page>

    <ion-header>
      <ion-toolbar>
        <ion-title>Profil</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Profil</ion-title>
        </ion-toolbar>
      </ion-header>
    </ion-content>

  <ion-grid>

    <ion-row>
      <ion-col>
          <ion-list>
    <ion-item v-for="item in items" :key="item.src">
      <ion-thumbnail slot="start">
        <ion-img :src="item.src"></ion-img>
      </ion-thumbnail>
      <ion-label>{{item.text}}</ion-label>
    </ion-item>
  </ion-list>
      </ion-col>
    </ion-row>

    <ion-row>
      <ion-col>
        Name Vorname
      </ion-col>
    </ion-row>

    <ion-row>
      <ion-col>
        <ion-list-header>
          <ion-label>Bevorstehende Events</ion-label>
        </ion-list-header>
      </ion-col>
    </ion-row>

    <ion-row>
      <ion-col>
        <ion-list>
          <ion-item>
            <ion-label>Event Eintrag 1</ion-label>
          </ion-item>
          <ion-item>
            <ion-label>Event Eintrag 2</ion-label>
          </ion-item>
          <ion-item>
            <ion-label>Event Eintrag 3</ion-label>
          </ion-item>
        </ion-list>
      </ion-col>
    </ion-row>

  </ion-grid>

  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonListHeader, IonList, IonCol, IonGrid, IonRow,IonImg, IonItem, IonLabel, IonThumbnail } from '@ionic/vue';

export default {
  name: 'Profile',
  components: { IonHeader, IonToolbar, IonTitle, IonContent, IonPage, IonListHeader, IonList, IonCol, IonGrid, IonRow, IonImg, IonItem, IonLabel, IonThumbnail },
  setup() {
    const items = [{
      'text': 'Item 1',
      'src': '../public/assets/img/ppic.jpg'
    }];
    return { items }
  }
}
</script>