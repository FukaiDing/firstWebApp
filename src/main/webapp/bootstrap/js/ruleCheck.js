
function leaveDoSubmit(){
	alert(1);
	if(doCheck("StartTime") && doCheck("EndTime") && doCheckReason()){
		return true;
	}
	return false;
}

function doCheck(id){
	var value = document.getElementById(id).value;
	var reg = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
	if(reg.exec(value) == null){
		document.getElementById("checkMessage").innerHTML = "<font color='red'>" + id + " format is wrong, Example 2013-06-06 11:11:11</font>";
		return false;
	}
	document.getElementById("checkMessage").innerHTML = "";
	return true;
}

function doCheckReason(){
	var value = document.getElementById("reason").value;
	if(value != null && value.trim() != ""){
		document.getElementById("checkMessage").innerHTML = "";
		return true;
	}
	document.getElementById("checkMessage").innerHTML = "<font color='red'>Leave reason can not be empty</font>";
	return false;
}

function test(){
	alert(1);
}