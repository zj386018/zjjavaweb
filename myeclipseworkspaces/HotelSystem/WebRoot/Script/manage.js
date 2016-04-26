	function checkOut(){
		re = /^[1-5](0[1-9]|10)$/;
		if(!re.test(document.getElementById("checkOutId").value)){
				alert("请输入正确的房间号，如：501");
				return false;
		}
		if(confirm("确认退房吗？"))
			return true;
		else 
			return false;
	};
	
	function checkIn(){
		if(""==document.getElementById("name").value.trim())
		{
			alert("姓名不能为空！");
			return false;
		}
		
		if(""==document.getElementById("IdCard").value)
		{
			alert("身份证不能为空");
			return false;
		}
		
		if(""==document.getElementById("phone").value)
		{
			alert("电话不能为空");
			return false;
		}
		re = /^[1-5](0[1-9]|10)$/;
		if(!re.test(document.getElementById("checkInId").value)){
				alert("请输入正确的房间号，如：501");
				return false;
		}
	}
	