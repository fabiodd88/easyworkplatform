$(document).ready(function()
		{
	$("#mioModalService").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "ServiceController",
			data: $("#mioModalService").serialize(),
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
					$("#status").html("Messaggio: Servizio aggiunto con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "removeOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Eliminazione effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "exists"){
					$("#status").html("Messaggio: Il servizio è stato aggiunto precedentemente");
				}
				else if(xhr.responseText == "noExists"){
					$("#status").html("Messaggio: I dati del servizio non sono presenti all'interno del db");
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




function setChangeService(value){
	
	var name 	 = document.getElementById("name"+value).textContent;
	var customer = document.getElementById("customer"+value).textContent;
	var quantity = document.getElementById("quantity"+value).textContent;
	var variation= document.getElementById("variation"+value).textContent;
	var note	 = document.getElementById("note"+value).textContent;
	var receiptDate = document.getElementById("receiptDate"+value).textContent;
	var returnDate 	= document.getElementById("returnDate"+value).textContent;
	var employee = document.getElementById("employee"+value).textContent;
	$('#modNameS').val(name);
	$('#modCustomerS').val(customer);
	$('#modQuantityS').val(quantity);
	$('#modVariationS').val(variation);
	$('#modNoteS').val(note);
	$('#modReceiptDateS').val(receiptDate);
	$('#modReturnDateS').val(returnDate);
	$('#modEmployeeS').val(employee);

	
}

