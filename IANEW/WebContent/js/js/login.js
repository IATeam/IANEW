/**
 * 
 */
 
function unameEntered(e){
	
	//TO DO: add check to make sure that the query
	//is sent successfully
	//Search box pressed enter
	if(e.keyCode === 13){
		$('#username').hide();
		$('#password').show();
	}
}

function resetPressed(){
	
		$('#username').val('');
		$('#password').val('');
		$('#password').hide();
		$('#username').show();
}