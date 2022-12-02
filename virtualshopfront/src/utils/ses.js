
function saveCookie(data){
    document.cookie = `token = ${data.token}; max-age = ${60*20}; path =/; samesite=strict`
    document.cookie = `role = ${data.role}; max-age = ${60*20}; path =/; samesite=strict`
    document.cookie = `userId = ${data.userId}; max-age = ${60*20}; path =/; samesite=strict`

   console.log(document.cookie.split(";"))
}

function search(ck){
   let cookies = document.cookie.split(";")
   if (cookies.length > 2){
       for (let i = 0;  i < cookies.length; i++){
           let aux = cookies[i].split("=")
           if (aux[0] === " "+ck){
               return aux[1]
           }
       }
   }

   return "notLogged"




}




function getRole(){
   return search("role")

}

function getToken(){
   return search("token")
}

function  getUserId(){
   return search("UserId")
}

export {saveCookie , getRole, getToken, getUserId }
