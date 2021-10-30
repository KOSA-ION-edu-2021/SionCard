import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/FoundPage/Layouts.vue"
import Main from "./components/FoundPage/Main/Main.vue"
import Login from "./components/FoundPage/Login/Login.vue"
import CardInfor from "./components/FoundPage/Card/CardInfor.vue"

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
                path: "cardinfor",
                name: "cardinfor",
                component: CardInfor
            }
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes