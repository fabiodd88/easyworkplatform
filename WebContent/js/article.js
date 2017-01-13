$(document).ready(function()
		{
	$("#mioModalArticle").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "ArticleController",
			data: $("#mioModalArticle").serialize(),
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
					$("#status").html("Messaggio: Articolo aggiunto con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "removeOk"){
					$("#modalTitle").html("Messaggio:");
					$("#status").html("Messaggio: Eliminazione effettuata con successo");
					window.location.href="attivita.jsp";
				}
				else if(xhr.responseText == "exists"){
					$("#status").html("Messaggio: L'articolo è stato aggiunto precedentemente");
				}
				else if(xhr.responseText == "noExists"){
					$("#status").html("Messaggio: I dati dell'articolo non sono presenti all'interno del db");
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
