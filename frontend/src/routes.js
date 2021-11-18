import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/FoundPage/Layouts.vue"
import Main from "./components/FoundPage/Main/Main.vue"
import Login from "./components/FoundPage/Login/Login.vue"
import Signin from "./components/FoundPage/Signin/Signin.vue"
import My_main from "./components/FoundPage/My/MyMain/My_main.vue"
import MyInfo from "./components/FoundPage/My/MyInfo/MyInfo.vue"
import MyCard from "./components/FoundPage/My/MyCard/MyCard.vue"
import CardMain from "./components/FoundPage/Card/CardMain/Card_Main.vue"
import Cardrecommend from "./components/FoundPage/Card/CardRecommend/Card_Recommend.vue"
import CardApply from "./components/FoundPage/Card/CardApply/CardApply.vue"
import CardInfor0 from "./components/FoundPage/Card/CardInfor/CardInfor0.vue"

import Admin_Main from "./components/FoundPage/Admin/Admin_Main.vue"
import Admin_MainView from "./components/FoundPage/Admin/Admin_MainView.vue"
import Admin_Login from "./components/FoundPage/Admin/Admin_Login/Admin_Login.vue"
import Admin_User from "./components/FoundPage/Admin/Admin_User/Admin_User.vue"
import Admin_Card from "./components/FoundPage/Admin/Admin_Card/Admin_Card.vue"


const routes=[
    {
        path: "/",
        name: "Layouts",
        component: Layouts,
        children:[
            {
                path: "",
                name: "Main",
                component: Main
            },
            {
                path: "login",
                name: "login",
                component: Login
            },
            {
                path: "signin",
                name: "signin",
                component: Signin
            },
            {
                path: "my_main",
                name: "my_main",
                component: My_main
            },
            {
                path: "myinfo",
                name: "myinfo",
                component: MyInfo
            },
            {
                path: "mycard",
                name: "mycard",
                component: MyCard,
            },
            {
                path: "cardrecommend",
                name: "cardrecommend",
                component: Cardrecommend
            },
            {
                path: "card_main",
                name: "card_main",
                component: CardMain
            },
            {
                path: "cardapply",
                name: "cardapply",
                component: CardApply
            },
            {
                path: "card/:id",
                name: "card",
                component: CardInfor0,
                props: true,
            },
        ]
    },{
        path: "/admin",
        name: "admin_main",
        component: Admin_Main,
        children:[
            {
                path: "",
                name: "admin_main_view",
                component: Admin_MainView
            },
            {
                path: "login",
                name: "Login",
                component: Admin_Login
            },
            {
                path: "user",
                name: "admin_User",
                component: Admin_User
            },
            {
                path: "card",
                name: "admin_Card",
                component: Admin_Card
            },
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    },
    
]
export default routes