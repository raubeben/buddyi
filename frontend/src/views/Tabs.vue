<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="todo" href="/tabs/todo">
          <ion-icon :icon="flash" />
          <ion-label>Todo</ion-label>
        </ion-tab-button>
          
        <ion-tab-button tab="projects" href="/tabs/projects">
          <ion-icon :icon="apps" />
          <ion-label>Projects</ion-label>
        </ion-tab-button>
        
        <ion-tab-button tab="timerecord" href="/tabs/timerecord">
          <ion-icon :icon="send" />
          <ion-label>Timerecord</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { flash, apps, send } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      flash, 
      apps, 
      send,
    }
  }
}
</script>