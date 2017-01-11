$(document).ready(function()
		{
	$("#mioModal").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "CustomerController",
			data: $("#mioModal").serialize(),
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

			}
		});
		e.preventDefault();
			});
		});



function setChangeCustomer(value){
	
	var name = document.getElementById("name"+value).textContent;
	var surename = document.getElementById("surename"+value).textContent;
	var birth = document.getElementById("birth"+value).textContent;
	var place = document.getElementById("place"+value).textContent;
	var address = document.getElementById("address"+value).textContent;
//	var civicNumber = document.getElementById("civicNumber"+value).textContent;
	var city = document.getElementById("city"+value).textContent;
	var province = document.getElementById("province"+value).textContent;
	var cap = document.getElementById("cap"+value).textContent;
	var cap1= parseInt(cap);
	$('#modNameCl').val(name);
	$('#modSurenameCl').val(surename);
	$('#modBirthCl').val(birth);
	$('#modPlaceCl').val(place);
	$('#modAddressCl').val(address);
//	$('#modCivicNumberCl').val(civicNumber);
	$('#modCityCl').val(city);
	$('#modProvinceCl').val(province);
	$('#modCapCl').val(cap1);
	
}
