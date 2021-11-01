import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/Layouts.vue"
import Main from "./components/Main.vue"
import Login from "./components/Login.vue"
import Cardrecommend from "./components/Card_Recommend.vue"
import CardMain from "./components/Card_Main.vue"

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
                path: "cardrecommend",
                name: "cardrecommend",
                component: Cardrecommend
            },
            {
                path: "card_main",
                name: "card_main",
                component: CardMain
            },
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes