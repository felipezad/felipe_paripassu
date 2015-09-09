/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var uri = "ws://" + document.location.host +  "/felipe/wspass";
var websocket = new WebSocket(uri);
var passElement = document.getElementById("passCurrentValue");

websocket.onopen = function(e){
    onOpen(e);
};

function onOpen(){
    console.log("Connected with " + uri);
};

websocket.onmessage = function(data) {
    console.log(data.data);
    passElement.innerHTML = data.data;
};

function onMess(e) {
    websocket.send(e);
};