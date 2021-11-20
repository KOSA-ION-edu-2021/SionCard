<template>
  <v-container>
    <v-row>
      <v-col>
        <v-sheet class="grey lighten-4 text-h4 font-weight-bold">
          새 비밀번호 입력
        </v-sheet>
      </v-col>
    </v-row>
    
    
    <v-row class="text-h6 font-weight-regular mb-3">
      <v-col cols="">
        <table>
          <tr>
            <th>새 비밀번호</th>
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
          <tr>
            <th>비밀번호 확인</th>
            <td>
              <v-text-field
                style="width: 30%"
                label="PW Check"
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
    name: "webpw_2step",
    data: () => ({
    }),
    methods:{

    }

};
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