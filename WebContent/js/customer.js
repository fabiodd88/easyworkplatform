
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
					$("#status").html("Modifica effettuata con successo");
				}
				else if(xhr.responseText == "insertOk"){
					$("#status").html("Inserimento effettuata con successo");
				}
				else if(xhr.responseText == "removeOk"){
					$("#status").html("Eliminazione effettuata con successo");
				}
				else if(xhr.responseText == "exists"){
					$("#status").html("Elemento già esistente");
				}
				else if(xhr.responseText == "noExists"){
					$("#status").html("Non sono presenti all'interno del db");
				}
				else if(xhr.responseText == "empty"){
					$("#status").html("Nessun elemento presente");
				}
				else if(xhr.responseText == "regExpError"){
					$("#status").html("Rispettare il formato");
				}
				else if(xhr.responseText == "emptyList"){
					$("#status").html("Nessun elemento presente");
				}
				else if(xhr.responseText == "cError"){
					$("#status").html("Errore Di Connessione");
				}
				else if(xhr.responseText == "dbError"){
					$("#status").html("Errore di connessione al Database");
				}
				else{
					$("#status").html("Errore Generico");
				}
				
			}
		});


	}
}



function setChangeCustomer(value){

	var id = document.getElementById("id"+value).textContent;
	var name = document.getElementById("name"+value).textContent;
	var surname = document.getElementById("surname"+value).textContent;
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
	$('#idCustomer').val(id);
	$('#modNameCl').val(name);
	$('#modSurnameCl').val(surname);
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
	
	var id		 = document.getElementById("id"+value).textContent;
	var name 	 = document.getElementById("name"+value).textContent;
	var customer = document.getElementById("customer"+value).textContent;
	var quantity = document.getElementById("quantity"+value).textContent;
	var variation= document.getElementById("variation"+value).textContent;
	var note	 = document.getElementById("note"+value).textContent;
	var receiptDate = document.getElementById("receiptDate"+value).textContent;
	var returnDate 	= document.getElementById("returnDate"+value).textContent;
	var employee = document.getElementById("employee"+value).textContent;
	
	$('#modCodS').val(id);
	$('#modAidS').val(name);
	$('#modCustomerS').val(customer);
	$('#modQuantityS').val(quantity);
	$('#modVariationS').val(variation);
	$('#modNoteS').val(note);
	$('#modReceiptDateS').val(receiptDate);
	$('#modReturnDateS').val(returnDate);
	$('#modEmployeeS').val(employee);

	
}

