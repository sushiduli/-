 function openPdf(){
		    	try {
			    	var ret = 
			    		//window.open("http://www.baidu.com");
			    		window.open('/ZAngularJs/FileServlet');
					console.log(ret);
				} catch (e) {
					console.log(e);
				}
}
/*var x = 0.3- 0.2;
var y = 0.2- 0.1;
alert(x == y);
var x = 3- 2;
var y = 2- 1;
alert(x == y);
var y;
var x= null;
alert(x == y);
var arr = {first:"hh","second":"gg",third:null};
alert(arr.first+"=="+arr["second"]+"=="+arr["third"]+"=="+arr.fourth);
*/
//console.log(new Date);
/*var  data = {x:'hh',y:'gg'};
console.log(data && data.x);
data = null;
console.log(data && data.x)
data = {x:'lihaile'};
function sysout(){
	console.log('来啊，互相伤害啊');
	return 'niubi';
}
console.log(data && sysout());
var arr  = [1,23,45,6,7,8];
console.log(arr);
arr.length = 7;
console.log(arr);
console.log(arr.pop());
console.log(arr.pop());
console.log(arr);
arr.length = 3;
console.log(arr);
var  data = {x:'hh',y:'gg',z:'jj',1:'333','22x':'niu'};
var keys = Object.keys(data);
console.log(keys.join().split());
console.log(keys);
console.log(keys.join());
console.log(keys.join().split());
console.log(keys.reverse());
console.log(keys);
var arr  = [1,23,45,6,7,8];
console.log(arr.concat(3,-1));
console.log(arr);
var arr  = [1,3,5,6,7,9];
var sum = arr.reduce(function(x,y){
	return x+y;
});
console.log(sum)
ff(10,2);
function ff(x){
	console.log(x*20); 
	try{
		if(x==10){
			throw Error('不能等于'+x);
		}	
	}catch(e){
		console.log('获取到了第二个参数'+arguments[1]+arguments[0]+arguments[2]);
	}
}
var scope = "global";
function checkscope(){
	var scope = 'local';
	function f(){ return scope;}
	return f;
}
console.log(checkscope()());

console.log('javascript'.search('script'));
console.log('javascript'.search(/script/));
console.log('ni shi 1 tashi 2 shuishi 3'.match(/\d+/g));
console.log('ni shi 1 tashi 2 shuishi 3'.match(/\d+/));
var url = /(\w+):\/\/([\w.]+)\/(\S*)/;
var text = 'http://www.baidu.com/_sa tai che lw';
console.log(text.match(url));

var pattern = /Java/g;
var text = 'JavaS is not JavaSp!';
console.log(pattern.exec(text));
console.log(pattern.test(text));
var ret ;
while((ret = pattern.exec(text)) !=null){
	console.log(ret);
}*/
/*
$.ajaxSetup({
	contentType:'application/json', // 指定请求的HTTP Content-Type头；
	dataType:'json', //指定响应数据的预期类型及jQuery处理该数据的方式[text,html,script,json,xml...]
	timeout:2000, //超时时间，单位ms,默认0,若设置此项,规定时间未完成请求，请求被取消并触发error回调，状态码timeout;
	cache:false, // 禁用浏览器缓存，对于GET请求设置false时，url会添加“_=当前时间的毫秒数”;
	asyn:true,  //是否异步请求，默认是true,设置false.可以阻塞当前进程直到响应，等同于同步请求;
	
});
//设置ajax请求地址与回调函数
$.ajax({
	type:'GET', //HTTP请求方法，默认GET 其他有POST DELETE PUT等;
	url:'url...', //请求的URL
	data:{},  //发送请求是传递的数据，可以是字符串或对象，放到url中或请求内容体中;
	beforeSend:function(xhr){}, //指定Ajax请求发送前的回调函数;两个参数XMLHttpRequest对象与该请求的选项对象;
								//主要用于设置xhr对象上自定义http头，返回false时，请求将取消;
	success:function(response,statusCode,xhr){}, // 请求成功时的回调函数;三个参数:服务器返回的数据、jQuery状态码
												 //及发送改请求的XMLHttpRequest对象，一般只需要第一个参数; 
	error:function(xhr,statusCode,error){}, //请求不成功时的回调函数;三个参数：发送该请求的XMLHttpRequest对象
											//jQuery状态码、抛出的Error对象;
	complete:function(xhr,statusCode){}// 请求完成时(调用sucess或error后)激活的回调函数; 只有两个参数,一般不用;
});*/
/*localStorage.test = '';
delete localStorage.test;
$(function(){
	for(var name in localStorage){
		$("div>p").append(name+':'+localStorage[name]+'<br/>')
	}
})*/
/* //保存cookie:
function setCookie(name,value){
	//对value值进行表面,转义分号，逗号和空白符;
	var cookie = name+""+encodeURIComponent(value);
	cookie += "; max-age="+3000;//设置有效期 毫秒数;
	cookie += ";path=/";        //设置作用域路径
	cookie += ";domain="+domain;//作用域域名 只能是当前服务器的域;
	cookie += "; secure"; //设置此属性，则只有通过HTTPS或其他安全协议连接是才能传递cookie;
	
	document.cookie = cookie; //保存
}
//改变与删除cookie都要使用相同的名字、路径和域; 改变时,值设为新的; 删除时，设置max-age=0;
//读取所有cookie值
function getCookie(){
	var cookies = {};
	var all = document.cookie;
	if(all === ""){
		return cookies;
	}
	var list = all.split("; ");
	for(var i in list){
		var cookie = list[i];
		var p = cookie.indexOf("=");
		cookies[cookie.substring(0,p)] = decodeURLComponent(cookie.substring(p+1));
	}
	return cookies;
}*/
//new Audio("BY2.mp3").play();
/*var video =  $("#mp")[0];
video.play();
for(var name in video){
	console.log(name+":"+video[name]);	
}*/

function updateTime(){
	var now = new Date();
	var second = now.getSeconds();
	var min = now.getMinutes();
	var hour= (now.getHours()%12)+min/60;
	var secondangele = second*6; //6°是一秒钟 
	var minangle = min*6; //6°是一分钟
	var hourangle= hour*30; //30°是一小时
	$("#hourhand").attr("transform","rotate("+hourangle+",50,50)");
	$("#minutehand").attr("transform","rotate("+minangle+",50,50)");
	$("#secondhand").attr("transform","rotate("+secondangele+",50,50)");
} 
$(function(){
	setInterval("updateTime()", 1000);
});

/*
var c = $("#my_canvas")[0].getContext('2d');
c.beginPath();
c.moveTo(0,0);
c.lineTo(50,0);
c.lineTo(0,50);
c.closePath();
setInterval(function(){
	c.fillStyle="#ccc";
	c.fill();
	c.stroke();
	c.scale(1.1,1.1)},6000);
function rads(x){ return Math.PI*x/180};
c.moveTo(100,100);
c.arc(100,100,80,0,rads(360),false);

c.fillStyle="#ccc";
c.fill();
c.stroke();
*/
function loc(){

	if(navigator.geolocation){
		var options = {
			timeout:50000
		};
		var successCallback = function(pos){
			$("#loc").html(pos.coords.accuracy+" meters latitude: "+
					pos.coords.latitude+" longitude:"+ pos.coords.longitude);
		};
		var errorCallback = function(e){
			$("#loc").html(e.code+":"+e.message);
		};
		
		navigator.geolocation.watchPosition(successCallback, errorCallback, options)
	}
};
loc();

function computer(){
	var start= new Date().getTime();
	var num = 1;
	for (var int = 1; int < 100000; int++) {
		for (var int2 = 0; int2 < 100000; int2++) {
			num = int+num;
		}
	}
	var end = new Date().getTime();
	$("#result").html("计算结果:" +num + "==耗时："+ (end-start));
}

function computerWorker(){
	var start = new Date().getTime();
	var worker = new Worker('myworker.js');
	worker.postMessage(100000);
	var end = new Date().getTime();
	worker.onmessage = function(e){
		var num = e.data;
		$("#resultWorker").html("计算结果:" +num + "==耗时："+ (end-start));
	}
	
}
function fileInfo(files){
	for (var int = 0; int < files.length; int++) {
		var reader = new FileReader();
		reader.readAsText(files[int]);
		reader.onload = function(){
			console.log(reader.result);
		};
		reader.onerror= function(e){
			console.log("Error",e);
		};
	}
}

/*window.onload = function(){
	var dragImg = document.getElementById("dragImg");
	dragImg.ondragenter = function(){
		console.log('来了。。。。。。');
	};
	//不好用啊
	dragImg.ondrop = function(e){
		var file = e.dataTransfer.files[0];
		var img = document.createElement("img");
		img.src = window.webkitURL.createObjectURL(file) ;
		img.onload = function(){
			dragImg.appendChild(this);
		};
	};
}*/
/*var filesystem;
window.requestFileSystem(TEMPORARY,50*1024*1024,function(fs){
   filesystem = fs;
}, function error(e){
   console.log(e);
});

function listFile(path){
	if(!path){
		getFiles(filesystem.root);
	}else{
		
	}
	function getFiles(dir){
		console.log(dir);
	}
	
}*/

