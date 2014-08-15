/*----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 20/07/2014
	==============================================
	Updates: 
		15/08/2014 - added functionality after the user press enter after inputing a password.
	==============================================	
	Description: This js is for the login screen used to create the functionality
	for pressing enter after typing username and password to login and submit the form
	as well as switching (hiding and showing) username and password input field
------------------------------------------------------------------------------------------------*/

/**
 * event after user input a username and pressed enter
 * @param {} e
 */
function unameEntered(e){
	
	//TO DO: add check to make sure that the query
	//is sent successfully
	//Search box pressed enter
	if(e.keyCode === 13){
		$('#username').hide();
		$('#password').show();
		$('#password').focus();
		
	}
}

/**
 * event after user input a password and pressed enter
 * @param {} e
 */
function pwordEntered(e){
	if(e.keyCode==13){
		$("#loginForm").submit();
	}
}

/**
 * event after user pressed reset button. it clears all values
 * and shows the username input field again
 */
function resetPressed(){
	
		$('#username').val('');
		$('#password').val('');
		$('#password').hide();
		$('#username').show();
}