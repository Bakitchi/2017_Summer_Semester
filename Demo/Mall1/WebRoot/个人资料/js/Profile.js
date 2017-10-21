function setDftAdd(){
	var div_len = document.getElementById("add-container").getElementsByTagName("div").length;
	alert(div_len);
	var add_array = new Array(div_len);
	for (var i = div_len; i >= 1; i--) {
		alert(i);
		// var id = 'add-'+i;
		
		// add_array[i].style.backgroundImage='url(./img/mail.jpg)';
		// add_array[i].style.backgroundRepeat = 'no-repeat';
	}
	alert("1");
	this.style.background='url(./img/mail_1.jpg)';
	this.style.backgroundRepeat = 'no-repeat';
	alert("0");
}
function phone_tip(){
	var phone=document.getElementById("contact_email").value;
	if(phone==""){
		alert("不能为空");
		return false;
	}else if(!/^1[3|4|5|7|8][0-9]{9}$/.test(phone)) {  
				alert("格式不正确");
				return false;  
			}else{return true;}

	
}