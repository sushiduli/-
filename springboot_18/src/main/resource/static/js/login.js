function createCode(){
            var seed = new Array(
                    'abcdefghijklmnopqrstuvwxyz',
                    'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
                    '0123456789'
            ); //创建需要的数据数组
            var idx,i;
            var result = '';   //返回的结果变量
            for (i=0; i<5; i++)
            {
                idx = Math.floor(Math.random()*3); //获得随机数据的整数部分-获取一个随机整数
                result += seed[idx].substr(Math.floor(Math.random()*(seed[idx].length)), 1);//根据随机数获取数据中一个值
                result +=" ";
            }
            return result; //返回随机结果
}

function check() {
			var ewcode = document.getElementById('ewcode');
			var classes = ewcode.className.split(/\s+/);
			if(classes.indexOf('hidden')>-1){
				return true;
			}
            var inputRandom=document.getElementById("inputRandom").value;
            var autoRandom=document.getElementById("autoRandom").value;
            if(inputRandom==''){
            	alert('请输入验证码');
            	return false;
            }else if(inputRandom.toUpperCase() == autoRandom.replace(/\s/g,"").toUpperCase()) {
              	return true;
            } else {
               return false;
            }
}
function writeCode(){
	var erCode = createCode();
	document.getElementById("autoRandom").value= erCode;
};
window.onload = writeCode;
function logon(){
	if(check()){
		
		var name = document.getElementById('username').value;
		var pwd = document.getElementById('password').value;
		if(pwd=='' || name==''){
			alert("用户名或密码不能为空");
		}else{
			axPost('/pm/security/logon',{username:name,password:pwd},function(resp){
				var url = 'index.html';
				window.location.href = url;
				console.log(url);
			},function(error){
				alert(error.message);
			});
		}
	}else{
		alert("验证码输入错误!")
		writeCode();
	}
}