<template >
    <v-container>
        <v-row class="mb-5 mt-5 text-h6 font-weight-regular">
            <v-col>
                <table style="height: 60px; ">
                    <tr>
                        <th style="width:144px">고객명</th>
                        <td style=""> {{this.$store.state.auth.name}}</td>
                    </tr>
                </table>
            </v-col>
        </v-row>

        <v-row class="mb-5 mt-5 text-h6 font-weight-regular">
            <v-col cols="">
                <table>
                    <tr>
                        <th>ID</th>
                        <td>
                            {{this.$store.state.auth.member_id}}
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                            {{this.$store.state.auth.email}}
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>
                            {{this.$store.state.auth.birth}}
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td>
                            {{this.$store.state.auth.phone}}
                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            {{this.$store.state.auth.address}}
                        </td>
                    </tr>
                </table>

            </v-col> 
        </v-row>
    </v-container>
</template>

<script>
/* import axios from 'axios' */
export default {
    name:"myinfo_account",
    data:()=>({
        open: false,
        memberInfo : null,
        
    }),
    /* mounted() {
        this.getmemberInfo()
    }, */
    methods:{
        changeopen : function(){
           this.open = true
           
        },
        /* getmemberInfo(){
            axios.get(this.$store.state.apihost +"/member/memberinfo",{
                headers:{
                    Authorization:`Bearer ${sessionStorage.getItem('JSESSIONID')}`
                }
            })
            .then((res)=>{
                console.log(res.data);
                this.memberInfo = res.data
                console.log(this.memberInfo);
            })
            .catch((err)=>{
                console.log(err);
            })
        } */
    },
    props:{
        /* memberInfo : Array, */
    }
}
</script>

<style>

</style>
<style scoped>
table,
td,
tr {
  border: 1px solid rgb(196, 201, 209);
  border-collapse: collapse;
  border-left: none;
  border-right: none;
  border-top-color: black;
  height: 60px;
}
th {
  background: rgb(62, 62, 63);
  color: white;
  width: 144px;
  font-weight: 400;
  height: 60px;
}
table {
  width: 90%;
  font-size: 18px;
}
td{
  padding-left: 40px;
}
</style>