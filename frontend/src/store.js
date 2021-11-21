import Vuex from "vuex";
import Vue from 'vue';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        auth:null,
        apihost: "https://manage.si-on.net",
    },
    getters: {
        getAuth:state=>state.auth,
    },
    mutations: {
        SET_DATA(state, payload) {
            console.log("mutations:SET_DATA", payload);
            sessionStorage.setItem("data", payload);
        },
        setJwt(state, data){
            sessionStorage.setItem('JSESSIONID',data);
        },
        updateAuth(state, callback) {
            axios.get(state.apihost+"/member/get_auth",
                {
                    headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                    },
                }
            )
            .then(res=>{
                console.log(res.data)
                state.auth=res.data
                state.auth.expire = new Date(state.auth.expire);
                callback && callback(); //평가식 + 콜백함수
            })
            .catch(err=>{
                console.log("로그인이 되어 있지 않습니다.");
                console.log(err);
                state.auth=null;
                callback && callback();
            })
        },
    },
    actions: {
        SET_DATA(context, payload) {
            console.log("actions:SET_DATA");
            context.commit("SET_DATA", payload);
        },
    }
});