<template>
    <div class="post">
        <div class="wrapB">
            <h2>전체글</h2>

            <section class="post-list">

                <button>Created</button>
                <button>Join</button>

            </section>
        </div>
        

    </div>
</template>
 
<script>
    import '../../assets/css/post.scss'
    import constants from '../../lib/constants'

    export default {
        name:"Post",
        components:{
        },
        watch: {
        },
        created() {
        },
        methods: {
        },
        data: () => {
            return {
                constants
            }
        }
    }
</script>