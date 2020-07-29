
<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="290">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="white"
          dark
          v-bind="attrs"
          v-on="on"
        >
          로그인
        </v-btn>
      </template>
      <v-card>
        <v-card-title>로그인</v-card-title>
        <v-card-text><Login/></v-card-text>
        
      </v-card>
    </v-dialog>
  </v-row>
</template>
<script>
    import Login from '../page/user/Login'
    export default {
        components: {
            Login,
        },
    }
</script>

<style>

</style>