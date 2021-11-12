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
    },
    {
        path: "*",
        component: NotFoundPage
    },
    
]
export default routes