import { useState } from 'react'
import './App.css'


const socket=new WebSocket("ws:/localhost:9999");

let message_sent;


socket.onopen=()=>{
	console.log("Connected to Server");
	
	socket.send("Hello Server");
	
};

socket.onmessage=(event)=>{
	console.log("Message:",event.data);
}

socket.onerror=(error)=>{
	console.log("Error:",error)
}

socket.onclose=()=>{
	console.log("Disconnected From Server");
}

function get_text(){

	message_sent=document.getElementById("user_input").value;

}

function update(){

	get_text();
	if(message_sent!==""){
	
	}
	
	
}












let height=window.innerHeight
let width=window.innerWidth

function App() {
  const [num,setNum] = useState("Bama")



  return (
	  <>
	  <div style={{display:"flex",
		justifyContent:"flex-start",
		alignsItems:"flex-start",
		flexDirection:"row",
		height:height,
		width:width}}>
	<div style={{height:"99%",width:"30%",display:"flex",flexDirection:"column",border:"2px solid black"}}>
	  	<h2>Chats</h2>
	  <Chat child="Hell"/>
	  <Chat child="Thing"/>
	  </div>

	  <div style={{color:"white",display:"flex",flexDirection:"column",height:height,
			  width:"70%"}}>
			<h2>Chat Area</h2>
			<div id="chat" style={{display:"flex",flexDirection:"column",
			justifyContent:"flex-end",alignItems:"flex-end",
			height:height}}>
			
			<Message messa="Anand:Message"/>

			<Message messa="Ayush:adasdad"/>
			</div>

	  
			<div style={{height:"9%",width:"100%",display:"flex",borderRadius:"100px"}}>
	  
			<input id="user_input" type="text" placeholder="Write message" style={{width:"100%",height:"83%",borderRadius:"100px",fontSize:"100%"}}/>
	  
			<button onClick={()=>"update()"} style={{width:"8%",borderRadius:"100px",display:"flex",
			justifyContent:"center",
			alignItems:"center"}}>Send</button>
		</div>

		</div>

	  
	  </div>
	</>
	)
}

function Box({children}){
	return (
	<div style={{background:"red",padding:"20px",fontSize:"30px"}}>{children}</div>
	);
}


function Chat({child}){
	return (
	<div className="box" onClick={update} style={{display:"flex",color:"white",height:100,border:"2px solid black",justifyContent:"center"}}>
		{child}</div>
	);
}

function Message({messa}){
	return (
	<div style={{display:"flex",color:"white",justifyContent:"center",minWidth:"5%",minHeight:"5%",
		background:"#444",alignItems:"center",borderRadius:"100px",border:"2px solid black",padding:"10px"}}>
		{messa}</div>
	);
}
export default App
