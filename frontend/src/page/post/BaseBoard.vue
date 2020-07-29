<template>
    <div>
        <!-- <h2>{{Moim.profile}}</h2>
        <h2>{{Moim.name}}</h2> -->
        <h3></h3>
    </div>
</template>

<script>
import Testboard from "./Test_Board"
export default {
    components:[ Testboard ],
    data: () => ({
        Moim:[]
    }),
    methods: {
        // getMoim() {
        //     const API_MOIM_URL = API_BASE_URL + '/board'
        //     const config ={}
        //     this.$axios.get(API_MOIM_URL, config)
        //     .then(res => {
        //         this.members = res.data
        //     })
        //     .catch(err => {
        //         console.error(err)
        //     })            
        // }
    },
    created() {
        this.getMoim()
    }

}
</script>

<style>

</style>