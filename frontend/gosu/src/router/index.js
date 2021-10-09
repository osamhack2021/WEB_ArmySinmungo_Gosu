import Vue from 'vue'
import VueRouter from 'vue-router'
import FreeBoard from '../views/FreeBoard'
import Home from '../views/Home'
import CommunicateBoard from '../views/communicateBoard'
import PostDetail from '../views/PostDetail'
import PostCreate from '../views/PostCreate'
import PostList from '../views/PostList'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
      path:'/free',
      name: 'freeBoard',
      component:FreeBoard
    },
    {
        path: '/postList/:boardId',
        name: 'PostList',
        component: PostList,
        props: true,
        children:[
            {
                path:'/create',
                component:PostCreate
            },

        ]

    },
    {
        path: '/communicateBoard',
        name: 'CommunicateBoard',
        component: CommunicateBoard
    },

]

const router = new VueRouter({
    mode:'history',
    routes
})

export default router
