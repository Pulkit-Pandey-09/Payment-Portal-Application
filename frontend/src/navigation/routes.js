import {
    Home,
    Login,
    Payment,
    Portal,
    Receipt
} from "../screens";


export const publicRoutes = [
    {
        path: "/home",
        component: Home,
    },
    {
        path: "",
        component: Home,
    },
    {
        path: "/login",
        component: Login,
    }
    
];

export const privateRoutes = [
    {
        path: "/payment",
        component: Payment,
    },
    {
        path: "/portal",
        component: Portal,
    },
    {
        path: "/receipt/:paymentId",
        component: Receipt,
    },
    {
        path: "/",
        component: Payment,
    },
];
