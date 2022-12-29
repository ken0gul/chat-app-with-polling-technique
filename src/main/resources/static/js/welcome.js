
let users = sessionStorage.getItem('user');
let userx = JSON.parse(users);

let user;



if(userx == null) {

username = prompt('What is your name?');

} 

user = {
    'username':username
    
    
}



fetch('/welcome', {
    method:'POST',
    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify(user)
}).then(response => response.json()).then(data => {


console.log(data)
sessionStorage.setItem('user',JSON.stringify(data))



}).catch(err=> console.log(err));

