import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/FoundPage/Layouts.vue"
import Main from "./components/FoundPage/Main/Main.vue"
import Login from "./components/FoundPage/Login/Login.vue"
import Signin from "./components/FoundPage/Signin/Signin.vue"
import My_main from "./components/FoundPage/My/My_main.vue"
import MyInfo from "./components/FoundPage/My/MyInfo.vue"
import MyCard from "./components/FoundPage/My/MyCard.vue"
import Cardrecommend from "./components/FoundPage/Card/Card_Recommend.vue"
import CardMain from "./components/FoundPage/Card/Card_Main.vue"
import CardInfor1 from "./components/FoundPage/Card/CardInfor/CardInfor1.vue"
import CardInfor2 from "./components/FoundPage/Card/CardInfor/CardInfor2.vue"
import CardInfor3 from "./components/FoundPage/Card/CardInfor/CardInfor3.vue"
import CardInfor4 from "./components/FoundPage/Card/CardInfor/CardInfor4.vue"
import CardInfor5 from "./components/FoundPage/Card/CardInfor/CardInfor5.vue"
import CardInfor6 from "./components/FoundPage/Card/CardInfor/CardInfor6.vue"
import CardInfor7 from "./components/FoundPage/Card/CardInfor/CardInfor7.vue"

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
                component: MyCard
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
                path: "card1",
                name: "cardinfor",
                component: CardInfor1
            },
            {
                path: "card2",
                name: "cardinfor",
                component: CardInfor2
            },
            {
                path: "card3",
                name: "cardinfor",
                component: CardInfor3
            },
            {
                path: "card4",
                name: "cardinfor",
                component: CardInfor4
            },
            {
                path: "card4",
                name: "cardinfor",
                component: CardInfor5
            },
            {
                path: "card5",
                name: "cardinfor",
                component: CardInfor5
            },
            {
                path: "card6",
                name: "cardinfor",
                component: CardInfor6
            },
            {
                path: "card7",
                name: "cardinfor",
                component: CardInfor7
            }
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes