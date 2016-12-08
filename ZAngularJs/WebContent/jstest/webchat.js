window.onload = function(){
	
	var nick = prompt("who are you?");
	var input = document.getElementById("input");
	input.focus();
	var div = document.createElement("div");
	
	document.body.insertBefore(div, input);
	
	var socket = new WebSocket("ws://10.7.6.7:80/");
	input.onchange = function(){
		var msg = nick+":"+input.value;
		scoket.send(msg);
		var node = document.createTextNode(msg);
		div.appendChild(node);
		input.value = "";
	};
	
	socket.onmessage = function(event){
		var msg = event.data;
		var node = document.createTextNode(msg);
		div.appendChild(node)
		input.scrollIntoView();
	};
}