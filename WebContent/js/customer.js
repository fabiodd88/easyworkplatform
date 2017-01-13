
function sendForm(type, form){
	{
		$.ajax({
			type: "POST",
			url: type+"Controller",
			data: $(form).serialize(),
			dataType: "text",
			success: function(data, status, xhr)
			{
				$("#status").html("");
				if(xhr.responseText == "updateOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Modifica effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "insertOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Registrazione effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "removeOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Eliminazione effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "exists"){
					$("#status").html("Messaggio: Il cliente è stato registrato precedentemente");
				}
				else if(xhr.responseText == "noExists"){
					$("#status").html("Messaggio: I dati del cliente non sono presenti all'interno del db");
				}
				else if(xhr.responseText == "empty"){
					$("#status").html("Messaggio: Compilare tutti i campi");
				}
				else if(xhr.responseText == "regExpError"){
					$("#status").html("Messaggio: Rispettare il formato");
				}
				else if(xhr.responseText == "emptyList"){
					$("#status").html("Messaggio: Lista vuota");
				}
				else if(xhr.responseText == "cError"){
					$("#status").html("Messaggio: Errore");
				}
				else if(xhr.responseText == "dbError"){
					$("#status").html("Messaggio: Database Error");
				}
				else{
					$("#status").html("Messaggio: Errore Generico");
				}
				
			}
		});


	}
}



function setChangeCustomer(value){

	var id = document.getElementById("id"+value).textContent;
	var name = document.getElementById("name"+value).textContent;
	var surename = document.getElementById("surename"+value).textContent;
	var birth = document.getElementById("birth"+value).textContent;
	var place = document.getElementById("place"+value).textContent;
	var address = document.getElementById("address"+value).textContent;
//	var civicNumber = document.getElementById("civicNumber"+value).textContent;
	var city = document.getElementById("city"+value).textContent;
	var province = document.getElementById("province"+value).textContent;
	var cap = document.getElementById("cap"+value).textContent;
	var phone = document.getElementById("phone"+value).textContent;
	var email = document.getElementById("email"+value).textContent;
	var cap1= parseInt(cap);
	$('#modIdCl').val(id);
	$('#modNameCl').val(name);
	$('#modSurenameCl').val(surename);
	$('#modBirthCl').val(birth);
	$('#modPlaceCl').val(place);
	$('#modAddressCl').val(address);
//	$('#modCivicNumberCl').val(civicNumber);
	$('#modCityCl').val(city);
	$('#modProvinceCl').val(province);
	$('#modCapCl').val(cap1);
	$('#modPhoneCl').val(phone);
	$('#modEmailCl').val(email);

}



function setChangeArticle(value){
	
	var id = document.getElementById("id"+value).textContent;
	var name = document.getElementById("name"+value).textContent;
	var price = document.getElementById("price"+value).textContent;
	var description = document.getElementById("description"+value).textContent;
	var duration = document.getElementById("duration"+value).textContent;
	$('#modIdA').val(id);
	$('#modName').val(name);
	$('#modPrice').val(price);
	$('#modDescription').val(description);
	$('#modDuration').val(duration);
	
}



function setChangePayment(value){
	
	var id = document.getElementById("id"+value).textContent;
	var customer= document.getElementById("customer"+value).textContent;
	var service = document.getElementById("service"+value).textContent;
	var serviceType = document.getElementById("serviceType"+value).textContent;
	var amount	= document.getElementById("amount"+value).textContent;
	var date	= document.getElementById("date"+value).textContent;
	$('#modIdP').val(id);
	$('#modCustomerP').val(customer);
	$('#modServiceP').val(service);
	$('#modServiceTypeP').val(serviceType);
	$('#modAmountP').val(amount);
	$('#modDateP').val(date);
	
}


function setChangeService(value){
	
	var id = document.getElementById("id"+value).textContent;
	var name 	 = document.getElementById("name"+value).textContent;
	var customer = document.getElementById("customer"+value).textContent;
	var quantity = document.getElementById("quantity"+value).textContent;
	var variation= document.getElementById("variation"+value).textContent;
	var note	 = document.getElementById("note"+value).textContent;
	var receiptDate = document.getElementById("receiptDate"+value).textContent;
	var returnDate 	= document.getElementById("returnDate"+value).textContent;
	var employee = document.getElementById("employee"+value).textContent;
	$('#modIdS').val(id);
	$('#modNameS').val(name);
	$('#modCustomerS').val(customer);
	$('#modQuantityS').val(quantity);
	$('#modVariationS').val(variation);
	$('#modNoteS').val(note);
	$('#modReceiptDateS').val(receiptDate);
	$('#modReturnDateS').val(returnDate);
	$('#modEmployeeS').val(employee);

	
}

