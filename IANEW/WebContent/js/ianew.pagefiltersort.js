/*----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/08/2014
	==============================================
	Updates: 
		16/08/2014 - 	Quang Nhan
						created file to move pagination functionality from list jsp files
	==============================================	
	Description: This js is for the pagination, filtering and Sorting functionalities of list 
				pages like enquiry and case lists
------------------------------------------------------------------------------------------------*/

/**
 * This function is called when the next button pressed for pagination
 */
function nextPage(){
	var currentPageNumber = parseInt($("#pageTextField").val());
	var totalNumberOfPages = parseInt( $("#totalNumberOfPagesDiv").text())
	
	if(currentPageNumber < totalNumberOfPages){ 
		var nextPageNumber = currentPageNumber + 1;
		$("#pageTextField").val(nextPageNumber);
		$("#page").val(nextPageNumber);
	}
}

/**
 * This function is called when the previous button pressed for pagination
 */
function prevPage(){
	var currentPageNumber = parseInt($("#pageTextField").val());
	
	if(currentPageNumber > 1 ){
		var prevPageNumber = currentPageNumber - 1;
		$("#pageTextField").val(prevPageNumber);
		$("#page").val(prevPageNumber);
	}
}

//TO DO when the user specify the desired page number
//TO DO sorting and filtering