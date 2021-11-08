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
                            label="ID"
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
                            label="ID"
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
        e1: 1,
    }),
}
</script>

<style>

</style>