/**
 * 
 * @param x
 * @returns
 */
function icone(x){
	
	var cl = document.getElementById("iconsCliente");
	var art = document.getElementById("iconsArticolo");
	var ser = document.getElementById("iconsServizio");
	var pag = document.getElementById("iconsPagamento");

	if(x==0){
		cl.style.display = "inline";
		art.style.display = "none";
		ser.style.display = "none";
		pag.style.display = "none";
	}
	else if(x==1){
		cl.style.display = "none";
		art.style.display = "inline";
		ser.style.display = "none";
		pag.style.display = "none";
	}
	else if(x==2){
		cl.style.display = "none";
		art.style.display = "none";
		ser.style.display = "inline";
		pag.style.display = "none";
	}
	else if(x==3){
		cl.style.display = "none";
		art.style.display = "none";
		ser.style.display = "none";
		pag.style.display = "inline";
	}

}


function formNone(){
	var cl = document.getElementById("newCliente");
	var art = document.getElementById("newArticolo");
	cl.style.display = "none";
	art.style.display = "none"
}


