<template>
<div>
  <h2>멤버현황</h2>
  <v-card
    class="mx-auto"
    max-width="800"
  >
    <v-container >
      <v-row dense>
        <v-col
          v-for="member in members"
          :key="member.name"
  
        >
          <v-card>
            <v-img
              :src="member.profile"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="200px"
            >
              <v-card-title v-text="member.name"></v-card-title>
            </v-img>

            <v-card-actions>
              <v-spacer></v-spacer>

            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
  </div>
</template>




<script>
  export default {
    data: () => ({
      members: [
        { name: '김강현', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '정용우', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        { name: '배민규', profile: 'https://image.flaticon.com/icons/svg/992/992675.svg', flex: 1 },
        ],
    }),
  //   methods: {
  //     getMembers() {
  //       const API_MEMBER_LIST_URL = API_BASE_URL + '/board/members'
  //       const config = {}
  //       this.$axios.get(API_MEMBER_LIST_URL, config)
  //       .then(res => {
  //         this.members = res.data
  //       })
  //       .catch(err => {
  //         console.error(err)
  //       })
  //     }
  //   },
  //   created() {
  //   this.getMembers()
  // },
  }
</script>