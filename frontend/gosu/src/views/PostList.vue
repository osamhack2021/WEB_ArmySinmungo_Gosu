<template lang="">
  <v-app>
    <v-container>
      <v-row>
        <v-col>
          <h1>{{ boardTitle }}</h1>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-spacer />
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <PostListView />
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
export default {
  props:{
    boardTitle:{
      type:String,
      default:"props error"
    },
    boardId:{
      type: String
    }
  },
  data(){
      return{

          writeMode:false,
          itemsPerPage:5,
          page: 1,
          pageCount:0,
          headers:[
              {
                  text:"공감",
                  align:'start',
                  value:'sympothy'

              },
              {
                  text:"분류",
                  value:'category',
              },
              {
                  text:"제목",
                  sortable:false,
                  value:"title"
              },
              {
                  text:"작성일",
                  sortable:false,
                  value:'writeDate'
              },
              {
                  text:"조회수",
                  value:"viewNumber"
              }
          ],
          opions:[
              {
                  sympothy:'3',
                  category:'인사',
                  title:"안녕하세요",
                  writeDate:'2021-10-04',
                  viewNumber:'1'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
              {
                  sympothy:'1',
                  category:'인사',
                  title:"안녕하십니까?",
                  writeDate:'2021-10-04',
                  viewNumber:'3'
              },
          ]
      }
  },
  computed:{
    // boardTitle(){
    //   return this.$route.params.boardTitle
    // }

  },
  created(){
    console.log("route",this.$route)
    console.log("router",this.$router)

  },
  method:{
  }
}
</script>

<style lang="">

</style>
