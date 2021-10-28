import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/Layouts.vue"
import Main from "./components/Main.vue"
import Login from "./components/Login.vue"
import Cardrecommend from "./components/Card_Recommend.vue"

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
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes