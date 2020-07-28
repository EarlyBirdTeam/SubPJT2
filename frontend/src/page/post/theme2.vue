<template>
  <v-app id="inspire">
    <v-app id="inspire">
        <v-navigation-drawer
          v-model="drawer"
          app
          clipped
        >
          <v-list nav dense>
            <v-list-item link @click.down="tabName='메인'">
              <v-list-item-icon>
                <v-icon>mdi-clipboard-outline</v-icon>
              </v-list-item-icon>
              <v-list-item-title>메인</v-list-item-title>
            </v-list-item>
            <v-list-item link @click.down="tabName='게시판'">
              <v-list-item-icon>
                <v-icon>mdi-newspaper-variant-outline</v-icon>
              </v-list-item-icon>
              <v-list-item-title>게시판</v-list-item-title>
            </v-list-item>
            <v-list-item link>
              <v-list-item-icon>
                <v-icon>mdi-account-multiple</v-icon>
              </v-list-item-icon>
              <v-list-item-title>멤버</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>

      <v-app-bar
        app
        clipped-right
        dark
        src="https://picsum.photos/1920/1080?random"
      >
        <template v-slot:img="{ props }">
          <v-img
            v-bind="props"
            gradient="to top right, rgba(100,115,201,.7), rgba(25,32,72,.7)"
          ></v-img>
        </template>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>이거 모임</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn icon>
          <v-icon>mdi-login</v-icon>
        </v-btn>
        <v-menu
          bottom
          left
          >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              icon
              v-bind="attrs"
              v-on="on"
            >
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>
  
          <v-list>
            <v-list-item
              v-for="(item, i) in items"
              :key="i"
            >
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
  
      </v-app-bar>
      <v-main>
        <v-container
          class="fill-height"
          fluid
          style="display: block"
        >
          <!-- 화이트 보드 -->
          <Board v-if="tabName === '메인'" style="margin-left: 50px; width: 80vw"></Board>
          <Article v-else-if="tabName === '게시판'"></Article>
        </v-container>
      </v-main>
    </v-app>
  </v-app>
</template>
        <!-- <template v-slot:extension>
          <!-- 모임 이동 패널
          <v-expansion-panels
            class="panels" 
            style="width: 300px">
            <v-expansion-panel>
              <v-expansion-panel-header>
                모임 1
              </v-expansion-panel-header>
              <v-expansion-panel-content>
                <v-list>
                  <v-list-item
                    v-for="(moim, i) in moimList"
                    :key="i"
                  >
                    <v-list-item-content>
                      {{ moim }}
                    </v-list-item-content>
                  </v-list-item>
                </v-list>
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels>
        </template> -->
<script>
import Board from './Test_Board.vue'
import Article from './article.vue'

export default {
  name: 'theme2',
  components: {
    Board,
    Article
  },
  data: () => ({
    drawer: false,
    group: null,
    items: [
      { title: '프로필' },
      { title: 'Click Me' },
      { title: 'Click Me' },
      { title: 'Click Me 2' },
    ],
    moimList: [
      "모임 1",
      "모임 2",
    ],
    tabName: "메인",
  }),
  methods: {
    createText() {
      this.counter.textC.push(0);
    },
    createScheduler() {
      this.counter.schedulerC.push(0);
    },
    createCanvas() {
      this.counter.canvasC.push(0);
    },
  },
}
</script>

<style>
.board {
  height: 500px;
  background-color: #ECEFF1;
}

</style>