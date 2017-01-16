function showyd(){
				
			var info = document.getElementById("yd").innerHTML;
			if(info=='引导页'){
				document.getElementById("div0").style.display = 'block';
				document.getElementById("yd").innerHTML = '隐藏引导页';
			}else{
				document.getElementById("div0").style.display = 'none';
				document.getElementById("yd").innerHTML = '引导页';
			}			
}

function showchart(e) {

	for(var i=1;i<4;i++){
		
		$("#td"+i).removeClass();
		$("#div"+i).removeClass();
		if(e==i){
			$("#td"+i).addClass("nav1td2");
			$("#div"+i).css("display","block");
		}else{
			$("#td"+i).addClass("nav1td3");
			$("#div"+i).css("display","none");;
		}
		
	}
}

setTimeout("showchart(1)", 200);