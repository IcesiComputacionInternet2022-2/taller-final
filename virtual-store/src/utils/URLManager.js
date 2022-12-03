
let BASE_BACK_PATH = "http://localhost:8080/"

let URLSessions = {
    LOGIN : BASE_BACK_PATH+"login",
    SIGNUP: BASE_BACK_PATH+"users",
}

let URLAdmin = {
    USER_LIST: BASE_BACK_PATH+"users",
    CREATE_ITEM: BASE_BACK_PATH+"items",
    ITEM_LIST: BASE_BACK_PATH+"items",
}


export {URLSessions, URLAdmin}

