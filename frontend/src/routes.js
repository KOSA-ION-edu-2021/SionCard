import NotFoundPage from "./components/NotFoundPage.vue"
import Layouts from "./components/Layouts.vue"
import Main from "./components/Main.vue"

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
        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes