
function sendForm(type, form, mod){
	{
		if(type == "Customer"){		
			
			var name 		= document.getElementById(mod+"NameCl").value;
			var surname		= document.getElementById(mod+"SurnameCl").value;
			var birthDate 	= document.getElementById(mod+"BirthCl").value;
			var birthPlace 	= document.getElementById(mod+"PlaceCl").value;
			var address 	= document.getElementById(mod+"AddressCl").value;
			var civicNumber = document.getElementById(mod+"CivicNumberCl").value;
			var city 		= document.getElementById(mod+"CityCl").value;
			var province 	= document.getElementById(mod+"ProvinceCl").value;
			var cap 		= document.getElementById(mod+"CapCl").value;
			var phone 		= document.getElementById(mod+"PhoneCl").value;
			var email 		= document.getElementById(mod+"EmailCl").value;
			
			if( name==""	||surname==""	||birthDate==""		||birthPlace==""||
				province==""||address==""	||civicNumber==""	||city==""		||
				phone==""	||prov==""		||cap==""			||email==""			)
			{
				alert("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
				return;		
			}
			
			
		}
		else if(type == "Article"){	
			
			var name		= document.getElementById(mod+"NameA").value;
			var price		= document.getElementById(mod+"PriceA").value;
			var description = document.getElementById(mod+"DescriptionA").value;
			var duration 	= document.getElementById(mod+"DurationA").value;
			
			if(name=="" || price=="" || description==""||duration==""){
				alert("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
				return;
			}
			
		}
		else if(type == "Service"){	
			
			var codService	= document.getElementById(mod+"CodS").value;
			var customer	= document.getElementById(mod+"CustomerS").value;
			var quantity	= document.getElementById(mod+"QuantityS").value;
			var variation	= document.getElementById(mod+"VariationS").value;
			var note	 	= document.getElementById(mod+"NoteS").value;
			var date		= document.getElementById(mod+"ReceiptDateS").value;
			var rest	 	= document.getElementById(mod+"ReturnDateS").value;
			var employee	= document.getElementById(mod+"EmployeeS").value;
			var articleId	= document.getElementById(mod+"AidS").value;
			
			
			if( codService==""	||customer==""	||quantity==""	||variation==""	||
				note==""		||date==""		||rest==""		||employee==""	|| articleId==""){
				alert("<strong>Warning!</strong>  Campi vuoti o non conformi!!");				
				return;
			}	
		}
		else if(type == "Payment"){		
			
			var customer	= document.getElementById(mod+"CustomerP").value;
			var service		= document.getElementById(mod+"ServiceP").value;
			var serviceType	= document.getElementById(mod+"ServiceTypeP").value;
			var amount		= document.getElementById(mod+"AmountP").value;
			var date		= document.getElementById(mod+"DateP").value;

			if(custome==""||service==""||serviceType==""||amount==""||date==""){
				alert("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
				return;
			}
		}
		
			$.ajax({
				type: "POST",
				url: type+"Controller",
				data: $(form).serialize(),
				dataType: "text",
				success: function(data, status, xhr)
				{
					$('.modal').modal('hide');
					$('#modalConf').modal('show');
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
			e.preventDefault();
		
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
	$('#modNameA').val(name);
	$('#modPriceA').val(price);
	$('#modDescriptionA').val(description);
	$('#modDurationA').val(duration);
	
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
