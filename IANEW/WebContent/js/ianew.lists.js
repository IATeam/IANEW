/**
 * @author Quang
 * added new functions
 */

/* Activity Lists Uses local storage */

function saveNewActivity(item){
	updateStorage();
	
}


/**
 * Called when first load the local storage.
 * @param item 
 */
function displayActivities(){
	//loadListFromLocalStorage();
	var activityLength = $('#artActivityList ol li').size();
	var storageLength = localStorage.length;
	if(activityLength > 0){
		clearActivityList();
	}
	
	if(activityLength < storageLength)
		for(var i = storageLength; i > 0; --i){
			displayAnItem(localStorage.getItem(i));
			alert(i + ", " + localStorage.getItem(i));
		}
}

function clearActivityList(){
	$('#artActivityList ol li').remove();
}

function displayAnItem(item){
	var activityLength = $('#artActivityList ol li').size();
	//TO DO: need to check if an item is in the list already
	//if it is delete the old item and add the current item to the top of the list
	
	if(activityLength > 4){
		$('#artActivityList ol li:last').remove();
	}
	
	if(activityLength === 0) //first item to beinserted in the list
		$('#artActivityList ol').append("<li><a data-sql=''>" + item + "</a></li>");
	else //insert at the beginning of the list
		$('#artActivityList ol').prepend("<li><a data-sql=''>" + item + "</a></li>");
}

function addActivity(item, e){
	//TO DO: add check to make sure that the query
	//is sent successfully
	//Search box pressed enter
	if(e.keyCode === 13 && item !== ""){
		displayAnItem(item);
		updateStorage(item);
	}
}

function deleteLocalStorage(){
	localStorage.clear();
	clearActivityList();
}

function updateStorage(item){
	
	
	//activity list contains maximum of 5 items
	if(localStorage.length == 0){
		localStorage.setItem("1", item);
	}else{
		var listItems = $("#artActivityList ol li");
		listItems.each(function(idx, li){
			localStorage.setItem(idx+1, $(li).text());
		});
	}
	
}


/**
 * This method is called by both caselist and enquirylist
 * @param {} btn
 */
function loadList(btn){
	var formTitle = ($("#formTitle").text()); //used to check if it is either an enquirylist or case list
	var firstName, lastName, createdDateStart, createdDateEnd, updatedDateStart, updatedDateEnd, theStatus;
	var sortField, ascending;
	var goAhead = false;
	var dash = "-";

	var namespace, loadingDiv;
	switch(formTitle){
	case "Enquiry List": namespace = "/IANEW/enquiryList"; loadingDiv = "#iterEnquiryList"; break;
	case "Case List":	namespace = "/IANEW/caseList"; loadingDiv = "#iterCaseList" ;break;
	default:;
	}
	
	if($("#descending").val() == 1)			descending = false;
	else									descending = true;

	
	if($("#firstname").val().trim().length > 0){
		firstName = $("#firstname").val().trim();
	}else{
		//firstName = "";
	}
	
	if($("#lastname").val().trim().length > 0){
		lastName = $("#lastname").val().trim();
	}else{
		//lastName = "";
	}
	
	if($("#createdDateStart").val() != "" || $("#createdDateEnd").val() != ""){
		createdDateStart = getDateSearchFormat("#createdDateStart");
		createdDateEnd = getDateSearchFormat("#createdDateEnd");
	}

	if($("#updatedDateStart").val() != "" || $("#updatedDateEnd").val() != ""){
		updatedDateStart = getDateSearchFormat("#updatedDateStart"); 
		updatedDateEnd = getDateSearchFormat("#updatedDateEnd"); 
	}

	//get the sortfield
	if($("#radioid").is(":checked"))				sortField = "id";
	else if($("#radiocreateddate").is(":checked"))	sortField = "createdDateTime";
	else if($("#radioupdateddate").is(":checked"))	sortField = "updatedDateTime";
	else if($("#radiofirstname").is(":checked"))	sortField = "contact.firstname";
	else 											sortField = "contact.lastname";

	
	if($("#descending").val() == 1)			descending = false;
	else									descending = true;

	if($("#recordsPerPage").val() == "")	recordsPerPage = 0;
	else									recordsPerPage = $("#recordsPerPage").val();

	if($("#startIndex").val() == "")		startIndex = 0;
	else									startIndex = $("#startIndex").val();

	if($("#currentPage").val() == "")		currentPage = 0;
	else									currentPage = parseInt($("#currentPage").val()); 

	theStatus = $("select[name='theStatus']").val();

	var totalPage;
	if($("#totalNumberOfPagesDiv").text() == "")
		$("#totalNumberOfPagesDiv").text("0");
	
	totalPage = parseInt($("#totalNumberOfPagesDiv").text());

	var url = '';
	if($(btn).attr('id') == "btnFilterSort"){
		url = namespace + "/loadFilterSortResult.action";
		goAhead = true;
	}
	else if($(btn).attr('id') == "btnNext"){
		url = namespace + "/getNextPage.action";
		if(currentPage < totalPage)
			goAhead = true;
	}
	else if($(btn).attr('id') == "btnPrev"){
		
		url = namespace + "/getPrevPage.action";
		if(currentPage > 1)
			goAhead = true;
	}
	else{ //for when the user input a number for page change
		url = namespace + "/getPage.action";
		if(currentPage > 0 && currentPage <= totalPage)
			goAhead = true;
	} 
	var submitData = {
		'firstName' 		: firstName,
		'lastName'			: lastName,
		'descending'		: descending,
		'sortField'			: sortField,
		'startIndex'		: startIndex,
		'recordsPerPage'	: recordsPerPage,
		'currentPage'		: currentPage,
		'createdDateStart' 	: createdDateStart,
		'createdDateEnd'	: createdDateEnd,
		'updatedDateStart'	: updatedDateStart,
		'updatedDateEnd'	: updatedDateEnd,
		'theStatus'			: theStatus
	};

	if(goAhead){
		$.post(url, 
			submitData, 
			function(data){
				$(loadingDiv).html(data);
			}
		);
	}
}

/**
 * Due to time constraint we did not have enough time to investigate the reason
 * to this slight hickup, the date needed to be set back 2 days to return correct
 * result
 * 
 */
function getDateSearchFormat(date){
	if($(date).val() === "")
		return "*";
	else{
		var d = new Date($(date).val());
		d.setDate(d.getDate() - 2);
		return formatDate(d) + "*";
	}
}

/**
 * returns the string as yyyymmdd format
 * @param {} obj
 * @return {}
 */
function formatDate(obj) {
  var dates = ['00','01','02','03','04','05','06','07','08','09','10',
         	   '11','12','13','14','15','16','17','18','19','20',
         	   '21','22','23','24','25','26','27','28','29','30','31']
  var months = ['01','02','03','04','05','06',
               '07','08','09','10','11','12'];  
    
  return obj.getFullYear() + months[obj.getMonth()] + dates[obj.getDate()];
}

function openCaseEnquiry(){
 
	if($("#hiddenid").val() != ""){
		if($("#formTitle").text() == "Case List")
			$.post('/IANEW/case/getExistingCase.action', 
				$('#caseListForm').serialize(), function(data){
				$('#formDiv').html(data);}
			);
		else
			$.post('/IANEW/enquiry/getEnquiry.action', 
				$('#enquiryListForm').serialize(), function(data){
				$('#formDiv').html(data);}
			);
	}
}

//initially hide all description from the list
$(".toggled").hide();

$('#new').click(function(){
	//alert($('#enquiryID').val())
});

function bandSelected(selectedDiv){
	deselectAll();
	$(selectedDiv).addClass("listSelected");
	
	$(selectedDiv).children("div").last().slideToggle();
	
	//for contact list setting the clicked band id value
	if($(selectedDiv).parent().attr("id") == "contactList"){
		$("#selectedContact").val($(selectedDiv).find('.id').text());
	}else if($(selectedDiv).parent().attr("id") == "planContactList") {
		// for contact list setting to search for support or authorised person
		$("#selectedPlanContact").val($(selectedDiv).find('.id').text());
	}else {
		$("#hiddenid").val($(selectedDiv).find('.id').text());
	}
		
}

function deselectAll(){
	$('.list').children().removeClass("listSelected");
	if($('.toggled').is(':visible')){
		$('.toggled').hide('slide');
	}
}

function checkHiddenID(){
	if($("#hiddenid").val() == ''){
		alert("No enquiry has been selected! Please select an enquiry.");
		return false;
	}else
		var check = confirmAction('Are you sure you want to open the selected enquiry?', 'enquiry', 'getEnquiry');
		if(check)return true;
		else return false;
	}