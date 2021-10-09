<template>
  <v-app>
    <v-app-bar
      scroll-target="#scrolling-techniques-7"
      elevate-on-scroll
    >
      <v-app-bar-nav-icon
        v-if="$vuetify.breakpoint.mobile"
      />
      <h1
        class="font-weight-bold text-h2 basil--text"
        align="right"
      >
        GOSU
      </h1>
      <v-spacer />
      <!-- <v-tabs
        v-model="tab"
        background-color="transparent"
        color="basil"
        right
        >
        <v-menu
            open-on-hover
            bottom
            offset-y
        >
        <template v-slot:activator="{ on, attrs }">
            <v-tab
                v-for="menu in menus"
                :key="menu"
                :to="menu.to"
                v-bind="attrs"
                v-on="on"
            >
            {{menu.title}}
            </v-tab>
        </template>
            <v-list>
                <v-list-item
                v-for="(sub, index) in menu.subs"
                :key="index"
                v-bind="attrs"
                v-on="on"
                >
                <v-btn
                :to = "sub.to">{{sub.subtitle}}</v-btn>
                </v-list-item>
            </v-list>
          </v-menu> -->
      <v-tabs
        v-model="tab"
      >
        <v-menu
          v-for="(menu,index) in menus"
          :key="index"
          open-on-hover
          bottom
          offset-y
        >
          <!-- attrs object 속성에서 삭제 -->
          <template v-slot:activator="{ on}">
            <v-tab
              color="primary"
              dark
              v-on="on"
            >
              {{ menu.title }}
            </v-tab>
          </template>
          <v-list>
            <v-list-item
              v-for="(sub, idx) in menu.subs"
              :key="idx"
              color="transparent"

              v-on="on"
              router :to="{
                name: sub.boardId,
                params:{boardId:sub.boardId}
                }"
              >
              {{ sub.subtitle }}
            </v-list-item>
            <!-- </v-list-item> -->
          </v-list>
        </v-menu>
      </v-tabs>
    </v-app-bar>
    <v-main>
      <v-container>
        <v-row>
          <v-col><v-spacer /></v-col>
          <v-col />
        </v-row>
        <router-view />
      </v-container>
    </v-main>
    <v-footer />
  </v-app>
</template>

<script>
export default {
  name: 'App',
  tab : true,
  data(){
     return {
        tab: null,
        menus: [
        {
        title:'Home',
        to : '/',
        subs:[
        ]
        },
        {
        title:'게시판',
        to : '/postList',
        subs:[
            {
              subtitle:'자유게시판',
              boardId: 'free'
            },
            {
                subtitle:'소통게시판',
                boardId:'talk'
            },
            {
                subtitle:'부대게시판',
                boardId:'local'
            }
        ]
        }
        ],
    }
  },
};
</script>

<style>
/* Helper classes */
.basil {
  background-color: #FFFBE6 !important;
}
.basil--text {
  color: #356859 !important;
}
</style>
