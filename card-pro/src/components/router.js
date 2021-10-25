import Vue from 'vue'
import Router from 'vue-router'

// 연결할 컴포넌트 import
// import App from '../App.vue'
import CardImf from '../CardImf.vue'

// 필수
Vue.use(Router)
export default new Router({
    mode: 'history', // history 모드는 자연스러운 url 가능, 지정하지 않으면 해시(#)기호로 url 사용
    routes: [
        // {
        //     path: "/", // 경로
        //     name: "App", // 해당 경로의 이름 
        //     component: App // 이동할 컴포넌트
        // },   
        {
            path: "/about", // 경로
            name: "CardImf", // 해당 경로의 이름 
            component: CardImf // 이동할 컴포넌트
        },    
    ]
})