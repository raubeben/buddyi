<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="todo" href="/tabs/todo">
          <ion-icon :icon="flash" />
          <ion-label>Todo</ion-label>
        </ion-tab-button>
          
        <ion-tab-button tab="events" href="/tabs/events">
          <ion-icon :icon="apps" />
          <ion-label>Events</ion-label>
        </ion-tab-button>
        
        <ion-tab-button tab="profile" href="/tabs/profile">
          <ion-icon :icon="person" />
          <ion-label>Profil</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { flash, apps, person } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      flash, 
      apps, 
      person,
    }
  }
}
</script>