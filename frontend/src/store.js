import Vuex from "vuex";
import Vue from 'vue';
import axios from 'axios';

Vue.use(Vuex);
export default new Vuex.Store({
    state: {
        auth:null
    },
    getters: {
        updateAuth(state) {
            axios.get("http://si-on.net:8080/member/get_auth",
            {"Authorization":"Bearer "+sessionStorage.getItem('JSESSIONID')})
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
    mutations: {
        SET_DATA(state, payload) {
            console.log("mutations:SET_DATA", payload);
            sessionStorage.setItem("data", payload);
        },
        setJwt(state, data){
            sessionStorage.setItem('JSESSIONID',data);
        }
    },
    actions: {
        SET_DATA(context, payload) {
            console.log("actions:SET_DATA");
            context.commit("SET_DATA", payload);
        }
    }
});