import NotFoundPage from "./components/NotFoundPage.vue"
import Main from "./components/Main.vue"

const routes=[
    {
        path: "/",
        name: "Main",
        component: Main,
        children:[


        ]
    },
    {
        path: "*",
        component: NotFoundPage
    }
]
export default routes