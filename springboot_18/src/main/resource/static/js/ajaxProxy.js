
var axPost = function(url,data,successfn,errorfn){
	ax(url, "POST", true, data, "application/json;charset=utf-8",successfn,errorfn);
}

var axPostSync = function(url,data,successfn,errorfn){
	ax(url, "POST", false, data, "application/json;charset=utf-8",successfn,errorfn);
}

var axGet = function(url,data,sucessfn,errorfn){
	ax(url, "GET", false, data, "application/json;charset=utf-8",sucessfn,errorfn);
};

var ax = function(url,method,async,data,contentType,successfn,errorfn){
    
	data = (data==null || data=="" || typeof(data)=="undefined")? {"date": new Date().getTime()} : data;
    
    async = (async==null || async=="" || typeof(async)=="undefined")? true : async;
    
    method = (method==null || method=="" || typeof(method)=="undefined")? 'GET' : method;
    
    var request = new XMLHttpRequest();
    
    request.open(method,url,async);
    
    if(contentType==null || contentType=="" || typeof(contentType)=="undefined"){
        //do noting 浏览器会根据参数数据自动设置
    }else{
        //"application/json;charset=utf-8"
        request.setRequestHeader("Content-Type",contentType);    
    }
    //响应：
    request.onreadystatechange = function(){
        if(request.readyState === 4 ){
            //响应完成
            //获取响应类型，服务器端给的
            var type = request.getResponseHeader("Content-Type");
            var resp = request.responseText;
            if(!!type && type.indexOf('xml') !==-1 && requset.responseXML){
                 resp = requset.responseXML;
            }else if(!!type && type.indexOf('json') !==-1 ){
                resp = JSON.parse(resp);
            }else{
                //text类型 返回
            }
            if(request.status === 200){
                //而且成功了
                successfn(resp);
            }else if(request.status > 399){
                //但是有错误
                errorfn(resp);
            }
        }
    }
    //request.overrideMimeType("application/json;charset=utf-8"); //强制响应类型为json
    if(contentType.indexOf('json') !==-1 || contentType.indexOf('JSON') !==-1){
        request.send(JSON.stringify(data));
    }else{
        request.send(data);
    }
};