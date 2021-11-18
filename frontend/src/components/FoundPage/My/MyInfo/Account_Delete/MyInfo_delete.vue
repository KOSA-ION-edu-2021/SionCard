<template>
    <v-container>
         <v-row class="mt-5">
          <v-col class="text-h4 font-weight-bold">
            본인 인증
          </v-col>
        </v-row>

        <v-row class="text-h6 font-weight-regular">
            <v-col cols="">
                <table>
                    <tr>
                        <th>ID</th>
                        <td>
                          <v-text-field
                            style="width: 30%"
                            label="ID"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                          <v-text-field
                            style="width: 30%"
                            label="E-MAIL"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </td>
                    </tr>
                    
                    <tr>
                        <th>비밀번호</th>
                        <td>
                          <v-text-field
                            style="width: 30%"
                            label="PW"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </td>
                    </tr>
                </table>

            </v-col> 
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'myinfo_delete',
    data:() => ({
      
    }),
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