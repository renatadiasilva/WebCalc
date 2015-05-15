//var chatE = document.getElementById("formChat:refreshChat");
//var button=document.getElementById("getServer:refresh");

setInterval(function () {refresh()}, 500);

function refresh(){
//	 chatE.click();
	$('#refreshChat').click();
}

//setInterval("nextMessage()", 200); //update the chart every 200 ms               
//
//function updateMessages(xhr, status, args) {
//    if(!args.ok) return;
//    $('#chat').append('<div>[' +args.date+ '] <strong>'+args.user+'</strong>: '+args.message+'</div>');
