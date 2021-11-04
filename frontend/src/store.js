import Vuex from "vuex";
import Vue from 'vue';
import axios from 'axios';

Vue.use(Vuex);
export default new Vuex.Store({
    state: {
        auth:null
    },
    


/////////////////
// Accept: application/json, text/plain, *
// Authorization: Bearer null
// Referer: http://localhost/
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36
    getters: {
    },
    mutations: {
        SET_DATA(state, payload) {
            console.log("mutations:SET_DATA", payload);
            sessionStorage.setItem("data", payload);
        },
        setJwt(state, data){
            sessionStorage.setItem('JSESSIONID',data);
        },
        updateAuth(state) {
            axios.get("http://si-on.net:8080/api/test")
            .then(res=>{
                console.log(res.data)
            })
            .catch(err=>{
                console.log("로그인이 되어 있지 않습니다.");
                console.log(err);
                state.auth=null;
            })
            axios.get("http://si-on.net:8080/member/get_auth",{
                headers:{
                    "Authorization" :"Bearer "+sessionStorage.getItem('JSESSIONID'),
                    "Accept":	"*/*",
                    "Cookie":"_xsrf=2|46f93d73|0da6b496abcc8b1c6a20313515af633c|1636005201",
                    "Accept-Encoding":	"gzip, deflate",
                    "Accept-Language":	"ko,en-US;q=0.9,en;q=0.8"
                }
            })
            .then(res=>{
                state.auth=res.data;
                console.log("로그온이 되어 있습니다.")
            })
            .catch(err=>{
                console.log("로그인이 되어 있지 않습니다.");
                console.log(err);
                state.auth=null;
            })
        }
    },
    actions: {
        SET_DATA(context, payload) {
            console.log("actions:SET_DATA");
            context.commit("SET_DATA", payload);
        }
    }
});