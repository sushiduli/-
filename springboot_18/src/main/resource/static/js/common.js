function menuClick(){
	var menus = document.getElementsByClassName("pure-menu-item"); 
	for (var int = 0; int < menus.length; int++) {
		menus[int].onclick = function(){
			 var classes = this.className.split(/\s+/);
			 classes.push('menu-item-divided');
			 classes.push('pure-menu-selected');
			 this.className = classes.join(' ');
		}
	}
}


function checkSession(){
	axGet('/pm/security/getCurrentSession',null,function(resp){
		if(resp == '' || resp == null){
			window.location.href = "/pm/login.html";
		}else{
			console.log('用户已经登录'+resp);
			//加载菜单
			$("#menu").load('left.html',function(){
				var path = window.location.pathname;
				var menus = document.getElementsByClassName("pure-menu-link"); 
				for (var int = 0; int < menus.length; int++) {
					var hreftext = menus[int].attributes.href.value;
					if(path.indexOf(hreftext)>-1){
						var element = menus[int].parentElement;
						 var classes = element.className.split(/\s+/);
						 classes.push('menu-item-divided');
						 classes.push('pure-menu-selected');
						 element.className = classes.join(' ');
					}
				}
			});
			
		}
	},function(error){
		window.location.href = "/pm/login.html";
	})
}
window.onload = checkSession;


