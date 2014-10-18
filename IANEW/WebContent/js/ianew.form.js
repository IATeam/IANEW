/**---------------------------------------------------------------------------------------------
	@author: Quang Nhan
	Created Date: 02/09/2014
	==============================================
	Updates: 
		06/08/2014 -	Quang Nhan
						Modified addNewRecord function to cater for textarea and select
						tags that does not get fully copied called by JQuery's clone function.
		14/08/2014 -	Quang Nhan
						Revised the remove null function to include removing null sections in the iterators to
						cover scenarios that allow auto update the index of the list if a null 
						secion is between two non null sections
		16/08/2014 -	Quang Nhan
				 		Added functionality to delete a section dynamically using ajax and load
		29/08/2014 -	Quang Nhan
						Amended undo button to properly to set the id -1 if existing to allow
						proper deletion on the action class
						Revised removeSecNull to accommodate the id = -1 condition
		06/08/2014 -	Quang Nhan - update addNewRecord to remove all validation aftereffect if cloning
						is done after submit and error was returned from validation function.
	==============================================	
	Description: This js is for the common functions in the forms
------------------------------------------------------------------------------------------------*/

//$(document).ready(function(){
//	$("#enquiryForm").find("option[value='-1']").each(function(){
//		alert($(this).val());	
//	});
//});
$("#enquiryForm").find("option[value='-1']").css("background-color", "pink");

/**
 * Add a new Component/record to the list
 * 
 * @param {} article
 * @param {} size
 * @param {} iterator
 */
function addNewRecord(article, size, iterator){ 
	$("#" + article + " section").clone().appendTo("#" + iterator);
//	var articleEle = document.getElementById(article);
//	var sizeEle = document.getElementById(size);
//	var iteratorEle = document.getElementById(iterator);
//	
//	//if article is not hidden then add to iterator
//	if(!$(articleEle).hasClass("hidden")){
//		
//		//search for elements with tagname textarea. if it has then 
//		//put it in a list to be copied over 
//		var textarea = $(articleEle).find("textarea");
//		var select = $(articleEle).find("select");
//		var tArray = []; var sArray = [];
//		
//		$(textarea).each(function(){
//			tArray.push(textarea.val());
//		});
//		$(select).each(function(){
//			sArray.push(select.val());
//		});
//		
//		//get section in article, clone and put in iterator
//		$("#" + article + " section").clone().appendTo("#"+iterator);
//		
//		//grab the last section added to the iterator and place the
//		//place the new value back into the textarea
//		var section = $("#"+iterator + " section").last();
//		textarea = $(section).find("textarea");
//		select = $(section).find("select");
//		
//		$(textarea).each(function(index, element){
//			$(element).val(tArray[index]);
//		});
//		
//		$(select).each(function(index, element){
//			$(element).val(sArray[index]);
//		});
//		
//		updateIndex(articleEle, sizeEle);
//		
//						
//	}else{
//		$(articleEle).removeClass("hidden");
//	}
}

/**
 * Update the hidden field value that represents the element's size to + 1
 * and assign that value as an index to the compoment's elements
 * 
 * @param {} articleEle
 * @param {} sizeEle
 */
function updateIndex(articleEle, sizeEle ){ 
	var ele = $(articleEle).find("[name]");
	var sizeInt = parseInt($(sizeEle).val());
	
	$(sizeEle).val(sizeInt + 1);
	
	newIndex = "[" + $(sizeEle).val() + "]";
	alert("new index: " + newIndex)
	//replaces the old index with the new one and clear the content
	$(ele).each(function(){ 
		var oldIndex = $(this).attr('name').match(/\[.\]/);
		var newName = $(this).attr('name').replace(oldIndex, newIndex);
		
		var oldIdNum = $(this).attr('id').match(/[0-9]+/);
		var newIdNum = $(this).attr('id').replace(oldIdNum, $(sizeEle).val());
		
		$(this).attr('name', newName);
		$(this).attr('id', newIdNum);
		if(this.nodeName === "SELECT")
			$(this).val(-1);
		else
			$(this).val(null);
		
		//removes class error if it has
		$(this).removeClass("error");
	});
	
	//removes any cloned error message validation
	$(articleEle).find("label[class='error']").remove();
}

/**
 * This method is called before submit form used to remove all
 * compoenents (address, disabiities, etc) that has all field
 * as null value
 * 
 * @param {} articleEle
 */
function removeNullAndUpdateIndex(articleEle, iterator, sizeEle){
	
	var section = $(iterator).find("section");
	var ele = $(articleEle).find("[name]");
	var counter = 0;
	
	//removes any null in the iterator
	for(var i = 0; i < section.length; i++){
		var itEle = $(section[i]).find("[name]");
		counter = removeSecNull(itEle, section[i], counter);
	}
	
	//removes the artcleEle if null
	counter = removeSecNull(ele, articleEle, counter);
	
	$(sizeEle).val(counter);
}

/**
 * This function will check and  removes null sections if all named attributes
 * has empty values (or in the case of select tags, -1)
 * 
 * @param {} ele
 * @param {} section
 * @param {} index
 * @return {}
 */
function removeSecNull(ele, section, index){ 
	var isAllNull = true; 
	$(ele).each(function(){ 
		//ignore input tag with type radio
		if(!$(this).is("input:radio")){
			
			//set isAllNull if tag input has id of value -1 this is for
			//deleting bands in the action class
			if($(this).is("input[name*='.id']") && $(this).val() == -1)
				isAllNull = false;
				
			//ignore input tag of type hidden
			else if(!$(this).is("input:hidden")){
				
				//set isAllNull = false if is select tag and 
				//is not of -1 as an option
				if(this.nodeName == "SELECT"){
					if ($(this).val() != -1){
						isAllNull = false;
					}
				//set isAllNull if input has some value
				}else if( $(this).val().length > 0){
					isAllNull = false;
				}
			}
		}
	});
	//return index to update the hidden field size value
	if(isAllNull === true){
		$(section).remove();
		return index;
	}else{
		updateNameIndex(ele, index);
		index++;
		return index;
	}
}

/**
 * This function will update the index of named attribute values
 * when clearing null sections
 * 
 * @param {dom Array} ele 
 * @param {Number} index 
 */
function updateNameIndex(ele, index){
	//include an if statement to find index == value
	var newIndex = "[" + index + "]";
	
	$(ele).each(function(){
		var oldIndex = $(this).attr('name').match(/\[.\]/);
		var newName = $(this).attr('name').replace(oldIndex, newIndex);
		$(this).attr('name', newName);
	});
}

/**
 * the button evokes this function to remove a band/section within 
 * an iterator. The result of the deletion is then reload into the list.
 * @param {} button
 */
function deleteSection(button){ 

	//grab this index, iterate through the bands below and change the index
	
//	var hidden =  $(button).parent().find("input:hidden").first();
//	var index = $(hidden).attr('name').match(/[0-9]+/g);
//	var listType = $(hidden).attr('name').match(/\.(.*)\[/);
//	var url = "enquiry/deleteFromList.action?deleteFrom=" + listType[1] + "&index=" + index + "&hiddenid=" + $("#hiddenid").val();
//		
//	//load the specified dom
//	if(hidden.val() == ""){
//		
//		var section = $(button).parent();
//		var parent = $(section).parent();
//		if($(parent).prop('id').match(/it.*/))
//			$(section).remove();
//		else{
//			$(parent).addClass("hidden");
//			//TODO: not completely working at the moment
//			setEmpty($(parent).find("[name]"));
//		}
//	}else{
//		if(listType[1] === "enquiryIssuesList")	$("#itIssue").load(url);
//		else{
//			var refinedType = listType[1].match(/contact.(.*)/)
//			url = "enquiry/deleteFromList.action?deleteFrom=" + refinedType[1] + "&index=" + index + "&hiddenid=" + $("#hiddenid").val();
//	
//			if(refinedType[1] === "addressesList")				$("#itAddress").load(url);
//			else if(refinedType[1] === "disabilitiesList")		$("#itDisability").load(url);
//			else if(refinedType[1] === "employmentsList")		$("#itEmployment").load(url);
//		}
//	}
	
	
}

/**
 * TODO: bug needs fixing
 * @param {} elements
 */
function setEmpty(elements){
	$(elements).each(function(){ 
		if(!$(this).is("input:radio") && !$(this).is("input:hidden")){
			if(this.nodeName == "SELECT"){
				if ($(this).val() != -1){
					$(this).val('-1')
				}
			}else if( $(this).val().length != ""){
				
				$(this).val('');
			}
		}
	});
}

//$(document).on("click", ".undoButton", function(event) {
//	//$(this).parent().remove();
//	$(selectedDiv).parent("section").children("input[name*='.id']").val("-1");
//});

function importantDiv(selectedDiv){
	
	var section = $(selectedDiv).closest("section");
	var isImportant = $(section).find(":hidden[name*='importantFlag']").val();
	var button = $(section).find("input[name='importantFlag']");
	if (isImportant == "Y") {
		$(section).find(":hidden[name*='importantFlag']").val(null);
		$(button).closest("section").css({'background-color':'snow'});
		$(button).css({'background':'#d6d6d6'});
	} else {
		$(section).find(":hidden[name*='importantFlag']").val("Y");
		$(button).closest("section").css({'background-color':'#fddabe'});
		$(button).css({'background':'orange'});
	}
}
/*
 * 
 */
function undoButton(selectedDiv){
	//$(selectedDiv).parent("section").hide();
	alert("HI")
	var section = $(selectedDiv).parent("section");
	var id = $(selectedDiv).parent("section").children("input[name*='.id']");
	//if contains value for id, then assign -1 otherwise completely remove it
	if($(id).val() != ""){
		$(selectedDiv).parent("section").children("input[name*='.id']").val("-1");
		$(section).css("display", "none");
	}
	else{
		
		//$(section).hide();
		$(section).remove();
	}
		
}

function divHide(clickedButton){
	var buttonImage = $(clickedButton).attr("src");
	
	if (buttonImage == "/IANEW/resources/images/minusButton.png")
	{
		$(clickedButton).attr("src", "/IANEW/resources/images/plusButton.png");
		
	}
	else 
	{	
		$(clickedButton).attr("src", "/IANEW/resources/images/minusButton.png");
	}
	$(clickedButton).siblings("div").children("div").slideToggle();
}

function primaryUpdate(radio){ 
	var section = $(radio).closest("section");
	$(section).find(":hidden[name*='primaryFlag']").val("Y");
	$(section).addClass("primary");
	$("#itDisability").find("input:radio[name='primary']:unchecked").each(function(index, value){
		var valueSection = $(value).closest("section");
		$(valueSection).find(":hidden[name*='primaryFlag']").val(null);
		$(valueSection).removeClass("primary");
	});
}

function initialisePrimaryDisability() {
	var it = $("#itDisability").find("section");
	
	$(it).each(function(index, section){
		//grab names in this section with primaryFlag substring.
		var deep = $(section).find(":hidden[name*='Flag']");
		
		//mark as check and assign the section with class primary
		$(deep).each(function(){
			if($(this).val()=="Y"){
				var radios = $(section).find("[name='primary']").first();
				$(radios).prop("checked", true);
				$(section).addClass("primary");
			}
		});
	});
	
//	$("#btnNewDisability").click(function(){
//		$("#leftPopUp").load("/IANEW/admin/getDisabilityTypeForm", function(){
//			$("#leftPopUp").show("slow");
//		});
//	});
}

function initialiseNewSection(article, iteratorArticle) {
	if ($("#" + iteratorArticle + " > section").length == 0) {
		addNewRecord(article, null, iteratorArticle);
	}
}

function initialiseCaseCommunications() {
	$("#btnAddCommunication").click(function(){ 
		//var $clone = $("#artCommunication section").clone(true);
		//$clone.appendTo("#itCommunication");
		$("#artCommunication section").clone().appendTo("#itCommunication");
		$("#itCommunication").find("input.DateInputClass").removeClass('hasDatepicker')
		  .removeData('datepicker')
		  .unbind()
		  .datepicker(); 
	});

	var it = $("#itCommunication").find("section");
	$(it).each(function(index, section){
		var isImportant = $(section).find(":hidden[name*='importantFlag']").val();
		var button = $(section).find("input[name='importantFlag']");
		if(isImportant == 'Y') {
			button.css({'background':'orange'});
			button.parent("div").parent("section").css({'background-color':'#fddabe'});	
		}
	});
}

function initialiseDatePicker() {
	if (!$.datepicker.initialized) {
	    $(document).mousedown($.datepicker._checkExternalClick)
	        // !!!!!!!!!!
	        // The next code line has to be added again so that the date picker
	        // shows up when the popup is opened more than once without reloading
	        // the "base" page.
	        // !!!!!!!!!!
	        .find(document.body).append($.datepicker.dpDiv);
	    $.datepicker.initialized = true;
	}
	
	$(".DateInputClass").datepicker({formatDate: "dd/mm/yy"}); 
//	$(".DateInputClass").each(function() {
//		//$.datepicker.formatDate( "dd MM yy", new Date($(this.val())));
//		//var dateformat = $.datepicker.formatDate('mm/dd/yy', new Date($(this).val()));
//		var dateformat2 = $.datepicker.formatDate('dd/mm/yy', new Date($(this).val()));
//		 $(this).val(dateformat2);
//	});
}

function setSQLDateFormat() {
	$(".DateInputClass").each(function() {
		var dateformat = $.datepicker.formatDate('dd/mm/yy', new java.sql.Date($(this).val()));
		 $(this).val(dateformat);
	});
}