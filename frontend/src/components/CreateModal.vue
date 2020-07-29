<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" scrollable max-width="300px">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="white"
          
          v-bind="attrs"
          v-on="on"
        style="width:0px padding:0"
        >
        
           <v-icon dark>mdi-plus</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>모임 생성</v-card-title>
        <v-divider></v-divider>
        <v-card-text style="height: 300px;">
            <create/>
        </v-card-text>

      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
    import create from '../page/post/Create_Community'
    export default {
        components: {
            create,
        },
    }
</script>

<style>

</style>