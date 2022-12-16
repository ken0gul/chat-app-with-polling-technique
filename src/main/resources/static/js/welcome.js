


let user = {
    'username':`${prompt('What is your name: ')}`
}


if(!sessionStorage.getItem('user')) {

fetch('/welcome', {
    method:'POST',
    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify(user)
}).then(response => response.json()).then(data => {



sessionStorage.setItem('user',data)


}).catch(err=> console.log(err));
} else {
alert('This username is already taken');
}