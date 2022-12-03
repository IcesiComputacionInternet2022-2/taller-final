import { getToken} from "./sessionManager";

let unsignedGet =  async (url)=>{
    let response = await fetch(url)
    let res = await response.json()
    return res;
}

let unsignedPost = async (url, data)=>{
    let config = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",

        },
        body: JSON.stringify(data)

    }

    let response = await fetch(url,config);
    return await response.json()
}

let signedPost = async (url, data)=>{
    let config = {
        method: "POST",
        headers: {
            "Authorization": "Bearer "+getToken(),
            "Content-Type":"application/json"
        },
        body: JSON.stringify(data)
    }

    let response = await fetch(url,config)
    return await response.json()
}


export {unsignedGet, unsignedPost, signedPost}


