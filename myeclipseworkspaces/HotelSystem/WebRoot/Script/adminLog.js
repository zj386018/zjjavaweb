document.charSet="utf-8";
function check(){
		if(""==document.getElementById("username").value.trim()){
			alert("账号不能为空！");
			return false;
		}
		if(""==document.getElementById("password").value.trim()){
			alert("密码不能为空！");
			return false;
		}
		else
			return true;
	}