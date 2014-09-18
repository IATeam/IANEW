/**---------------------------------------------------------------------------------------------
	@author: David Forbes
	Created Date: 13/09/2014
	Description: This js is for the pop up boxes that display after clicking a button
------------------------------------------------------------------------------------------------*/

/**
 * This function is used to display a pop up box depending on the button selected
 * @param message the message to be displayed
 * @param namespace the namespace of the page to be displayed
 * @param actionName the name of the action
 */
function confirmAction(message, namespace, actionName) {
	if(namespace == "home"){
		if (confirm(message) == true) 
			window.location.href = "http://localhost:8080/IANEW/home/home.jsp";
	}
	else if(actionName == "saveUpdateEnquiry"){
		if (confirm(message) == true) {
			
			validated();
			//ClientScriptManager cs = Page.ClientScript;
            //cs.RegisterStartupScript(this.GetType(), "showalert", "alert('Data Saved Successfully.')", true);		
			
        }
	}
	else{
		if (confirm(message) == true){ 
				$("#formDiv").load("/IANEW/" + namespace + "/" + actionName + ".action");
				return true;
		}else
			return false;
	}
}

