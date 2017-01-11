$(document).ready(function()
		{
	$("#mioModalPayment").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "PaymentController",
			data: $("#mioModalPayment").serialize(),
			dataType: "text",
			success: function(data, status, xhr)
			{
				$("#status").html("");
				if(xhr.responseText == "insertOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Pagamento effettuato con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "removeOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Eliminazione effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "exists"){
					$("#status").html("Messaggio: Il pagamento è stato effettuato precedentee precedentemente");
				}
				else if(xhr.responseText == "noExists"){
					$("#status").html("Messaggio: I dati del pagamento da effettuare non sono presenti all'interno del db");
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

			}
		});
		e.preventDefault();
			});
		});




function setChangePayment(value){
	
	var customer= document.getElementById("customer"+value).textContent;
	var service = document.getElementById("service"+value).textContent;
	var serviceType = document.getElementById("serviceType"+value).textContent;
	var amount	= document.getElementById("amount"+value).textContent;
	var date	= document.getElementById("date"+value).textContent;
	$('#modCustomerP').val(customer);
	$('#modServiceP').val(service);
	$('#modServiceTypeP').val(serviceType);
	$('#modAmountP').val(amount);
	$('#modDateP').val(date);
	
}
