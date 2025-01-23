import {createRouter, createWebHashHistory} from 'vue-router'
import LoginForm from '../components/LoginForm.vue'
import ContentList from '../components/ContentList.vue'
import RegisterForm from "@/components/RegisterForm.vue";

const routes = [
  { path: '/', redirect: '/login' },
  { path: "/register", component: RegisterForm },
  { path: '/login', name: 'Login', component: LoginForm },
  { path: '/content', name: 'Content', component: ContentList }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router