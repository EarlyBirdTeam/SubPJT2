<template>
  <div id="app">
    <v-app id="inspire">
      <v-app id="inspire">
        <v-navigation-drawer
          v-model="drawer"
          app
          clipped
          >
          <v-list dense>
            <v-list-item @click.stop="nowDrawer = '메인'">
              <v-list-item-action>
                <v-icon>mdi-exit-to-app</v-icon>
              </v-list-item-action>
              <v-list-item-content>
                <v-list-item-title>메인</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
        <v-app-bar
          app
          clipped-left
          color="blue darken-3"
          dark
        >
          <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
          <v-toolbar-title
            style="width: 300px"
            class="ml-0 pl-4"
            >
            <span>Google Contacts</span>
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn icon>
            <v-icon>mdi-apps</v-icon>
          </v-btn>
          <v-btn icon>
            <v-icon>mdi-bell</v-icon>
          </v-btn>
          <v-btn
            icon
            large
          >
            <v-avatar
              size="32px"
              item
            >
              <v-img
                src="https://cdn.vuetifyjs.com/images/logos/logo.svg"
                alt="Vuetify"
              ></v-img></v-avatar>
          </v-btn>
        </v-app-bar>
        <v-main>
          <v-container
            class="fill-height"
            fluid
          >
            <v-row
              align="center"
              justify="center"
            >
              <v-col class="shrink">
              </v-col>
            </v-row>
          </v-container>
        </v-main>
        <v-btn
          bottom
          color="pink"
          dark
          fab
          fixed
          right
          @click="dialog = !dialog"
        >
          <v-icon>mdi-plus</v-icon>
        </v-btn>
        <v-dialog
          v-model="dialog"
          width="800px"
        >
          <v-card>
            <v-card-title class="grey darken-2">
              Create contact
            </v-card-title>
            <v-container>
              hh
            </v-container>
            <v-card-actions>
              <v-btn
                text
                color="primary"
              >More</v-btn>
              <v-spacer></v-spacer>
              <v-btn
                text
                color="primary"
                @click="dialog = false"
              >Cancel</v-btn>
              <v-btn
                text
                @click="dialog = false"
              >Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-app>
    </v-app>
  </div>
</template>

<script>
export default {
  data: () => ({
    nowDrawer: '메인',
    dialog: false,
    drawer: null,
    items: [
      { icon: 'mdi-contacts', text: 'Contacts' },
      { icon: 'mdi-history', text: 'Frequently contacted' },
      { icon: 'mdi-content-copy', text: 'Duplicates' },
      {
        icon: 'mdi-chevron-up',
        'icon-alt': 'mdi-chevron-down',
        text: 'Labels',
        model: true,
        children: [
          { icon: 'mdi-plus', text: 'Create label' },
        ],
      },
      {
        icon: 'mdi-chevron-up',
        'icon-alt': 'mdi-chevron-down',
        text: 'More',
        model: false,
        children: [
          { text: 'Import' },
          { text: 'Export' },
          { text: 'Print' },
          { text: 'Undo changes' },
          { text: 'Other contacts' },
        ],
      },
      { icon: 'mdi-cog', text: 'Settings' },
      { icon: 'mdi-message', text: 'Send feedback' },
      { icon: 'mdi-help-circle', text: 'Help' },
      { icon: 'mdi-cellphone-link', text: 'App downloads' },
      { icon: 'mdi-keyboard', text: 'Go to the old version' },
    ],
  }),
}
</script>

<style>

</style>