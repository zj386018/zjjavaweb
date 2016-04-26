function checkOrder(){
	re = /^[1-5](0[1-9]|10)$/;
	if(!re.test(document.getElementById("roomId").value)){
		alert("请输入正确的房间号，如：501");
		return false;
	}
	else
		return true;
}
