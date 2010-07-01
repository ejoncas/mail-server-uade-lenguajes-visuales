/**
* Aca irian todas las funciones que use la aplicacion web
*/

function validarLogin(){
	if($("#usuario").val()==""){
		alert("Debe ingresar un usuario");
	}
	else if($("#passwd").val()==""){
		alert("Debe ingresar una password");
	}else{//Todo ok
		var u = $("#usuario").val();
		var p = $("#passwd").val();
		var pEncoded = hex_md5(p);
		$("#passwd").val(pEncoded);//replace password by MD5 Hash
		$("#loginForm").submit();
	}
}

function validarMail(){
	//TODO -Validate fields
	
	$("#mailForm").submit();
}

function validateNuevoMail(){
	var r = true;
	if($("#inputTo").val()==""){
		alert('debe ingresar un destinatario');
		r = false;
	}else if($("#inputSubject").val()==""){
		alert('debe ingresar un subject');
		r = false;
	}
	return r;
}

function split(val) {
	return val.split(/,\s*/);
}
function extractLast(term) {
	return split(term).pop();
}