


let user = {
    'username':`${prompt('What is your name: ')}`
}
fetch('/welcome', {
    method:'POST',
    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify(user)
}).then(response => response.json()).then(data => console.log(data)).catch(err=> console.log(err));