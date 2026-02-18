let message_sent;
let sen=0;
let name;
const socket= new WebSocket("ws://localhost:9999");


function get_text()
{
    message_sent=document.getElementById("input").value;
}

function update()
{
    if(message_sent!=="")
    {
    document.getElementById("label").innerHTML += `<div>You:${message_sent}</div>`;
    }
}

function send()
{
    get_text();
    update();

    if(message_sent!="")
    {
    socket.send(message_sent);
    }
    document.getElementById("input").value="";
    
}

function nickname()
{
    
    const name=document.getElementById("nick").value;
    
    if(name.trim()==="")
        {
            
        alert("Nick Name required!");
        return;
    }   
    
    document.getElementById("overlay").remove();
    
    
    socket.send(name);
}

socket.onopen=function()
{
    console.log("Server connected");
    
}

socket.onmessage=function(event)
{

    const json=JSON.parse(event.data);

    if(json.type=="new_user")
    {
        document.getElementById("connected_user").innerHTML+=`<div>${json.message} </div>`;
    }
    else if(json.type=="message")
    {   
        document.getElementById("label").innerHTML+=`<div> ${json.user}:${json.message} </div>`;
    }

}
