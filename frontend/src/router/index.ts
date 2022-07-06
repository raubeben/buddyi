import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '../views/Tabs.vue'
import Login from '../views/Login.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login,
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: '/tabs/profile'
      },
      {
        path: 'lookforusers',
        component: () => import('@/views/LookForUsers.vue')
      },
      {
        path: 'events',
        component: () => import('@/views/Events.vue')
      },
      {
        path: 'profile',
        component: () => import('@/views/ProfilePage.vue')
      },
      {
        path: 'events/:id',
        component: () => import('@/views/EventDetails.vue')
      },
      {
        path: 'events/create',
        component: () => import('@/views/CreateEventDetails.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
