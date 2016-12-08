onmessage = function(e){
	console.log(e);
	postMessage(computerNum(e.data));
};

function computerNum(numData){
	console.log(numData);
	var num = 1;
	for (var int = 1; int < 100000; int++) {
		for (var int2 = 0; int2 < 100000; int2++) {
			num = int+num;
		}
	}
	return num;
}

