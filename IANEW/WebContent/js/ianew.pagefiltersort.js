/*----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/08/2014
	==============================================
	Updates: 
		16/08/2014 - 	Quang Nhan
						created file to move pagination functionality from list jsp files
		26/08/2014 -	Quang Nhan
						Added and implemented a changePage function where the user can
						specify the page number to navigate to.
	==============================================	
	Description: This js is for the pagination, filtering and Sorting functionalities of list 
				pages like enquiry and case lists
------------------------------------------------------------------------------------------------*/


//this prevents assocating the submit buttons in the formList
//to register and enter key pressed.
$('#listForm').bind("keyup keypress", function(e) { 
  var code = e.keyCode || e.which; 
  if (code  == 13) {          
    e.preventDefault();
    return false;
  }
});

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

function changePage(e){
	if(e.keyCode===13 ){
		var newPage = parseInt($("#pageTextField").val());
		var totalNumberOfPages = parseInt($("#totalNumberOfPagesDiv").text());
		var numberOfRecords = $("#numberOfRecords").val();
		if(newPage > 0 && newPage <= totalNumberOfPages){
			$("#page").val(newPage);
			$("#formDiv").load("enquiryList/updateEnquiryList.action?numberOfRecords=" + numberOfRecords +"&page=" + newPage);
		}
		else{
			alert("Please enter a page number between 1 and " + totalNumberOfPages);
		}
	}
}

//TO DO when the user specify the desired page number
//TO DO sorting and filtering