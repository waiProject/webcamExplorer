function required(){  
	var benutzer = document.forms["login"]["benutzer"].value;
	var pass = document.forms["login"]["password"].value;
	if (benutzer == ""){  
		alert("Benutzer Feld darf nicht leer sein");
		
		return false;  
   }else if(pass == ""){
	   	alert("Passwort Feld darf nicht leer sein");	   	
		return false;
   }else{
	   document.getElementByName("login").submit();
	   return true;   
   }  
}  