let container = document.querySelector('.container');
let userData = sessionStorage.getItem('user');
let user = JSON.parse(userData);
let textArea = document.querySelector('textArea');
let id = document.querySelector('textarea[data-id]')
let endPointId = id.getAttribute('data-id');
let textP = document.querySelector('#text');

// user.channelId = endPointId;


if(userData == null) {
    window.location.href='http://localhost:8080/welcome'
}

let text = "";
// Get the current Channel first

let msgs = [];
let receivedMsgs=[];

let myArr = [];


let isDone = true;

    
    async function fetchData() {
        
        let response = await fetch(`/channels/${endPointId}/messages`);
        let data = await response.json();
        
        let isTrue = checkData(data);
        if(isTrue) addText();
     
    }
    
    setInterval(fetchData,500);



 
function checkData(data) {
     if(data.length > myArr.length) {
       myArr.length = 0;
       let newArr = []

       newArr.push(...data);
       myArr = newArr;
                 
       return true;
                 
	} 
	else {              
       return false;
         }
    }

function addText() {
    
    let p = document.createElement('p');
    container.innerHTML = '';
   	
   		for(let d of myArr) {
        
       		p.innerHTML +=  `<span>${d[0]}:${d[1]}</span><br/>`;
    }   
    container.appendChild(p);
    
}


       

textArea.addEventListener('keydown', e => {
   
    // let userData = sessionStorage.getItem('user');
   	// user = JSON.parse(userData);
  
    if (e.keyCode == 13 ) {
	
        let message = textArea.value;
       
  
        msgs.push(message);
        let usr = {
            "id":user.id,
            "username":user.username,
            "messages": msgs,
            "channelId":endPointId
        }
       
   
	// FETCH - POST
    fetch(`/channels/${endPointId}`,{
        method:'POST',
        headers:{
            'Content-Type':'application/JSON'
        },
        body:JSON.stringify(usr)
    })
    
    .then(response => response.json())
    .then(data=> {    
      
      textArea.value = '';
    })

}});

