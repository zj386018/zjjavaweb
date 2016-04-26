function checkReg(){
	if(""==document.getElementById("account").value.trim()){
		alert("账号不能为空！");
		return false;
	}
	
	if(document.getElementById("password1").value!=document.getElementById("password1").value){
		alert("两次输入的密码不相同！");
		return false;
	}
	
	if(""==document.getElementById("password1").value.trim()){
		alert("密码不能为空！");
		return false;
	}
	if(""==document.getElementById("password2").value.trim()){
		alert("重复密码不能为空！");
		return false;
	}
	if(""==document.getElementById("name").value.trim()){
		alert("姓名不能为空！");
		return false;
	}
	if(""==document.getElementById("phone").value.trim()){
		alert("联系方式不能为空！");
		return false;
	}
	if(""==document.getElementById("IdCard").value.trim()){
		alert("身份证不能为空！");
		return false;
	}else
		return true;
}

function checkPsw(){
	if(document.getElementById("password1").value!=document.getElementById("password2").value){
		document.getElementById("password2").style.backgroundColor="red";
	}
	else
		document.getElementById("password2").style.backgroundColor="";
}