
let users = sessionStorage.getItem('user');
let userx = JSON.parse(users);

let user;

let username;

if(userx == null) {

username = prompt('What is your name?');
user = {
    'username':username
    
}
getUser();
} 





async function getUser() {

    try {

        let response = await fetch('/welcome', {
            method:'POST',
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(user)
        });
        
        return await response.json().then(data => sessionStorage.setItem('user',JSON.stringify(data)))
    }catch(error) {
        console.error(error);
    }
        
 
    




}
// fetch('/welcome', {
//     method:'POST',
//     headers:{
//         "Content-Type":"application/json"
//     },
//     body:JSON.stringify(user)
// }).then(response => response.json()).then(data => {


// console.log(data)
// sessionStorage.setItem('user',JSON.stringify(data))



// }).catch(err=> console.log(err));

