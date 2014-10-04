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
	==============================================	
	Description: This js is for the common functions in the forms
------------------------------------------------------------------------------------------------*/

/**
 * Add a new Component/record to the list
 * 
 * @param {} article
 * @param {} size
 * @param {} iterator
 */
function addNewRecord(article, size, iterator){ 
	var articleEle = document.getElementById(article);
	var sizeEle = document.getElementById(size);
	var iteratorEle = document.getElementById(iterator);
	
	//if article is not hidden then add to iterator
	if(!$(articleEle).hasClass("hidden")){
		
		//search for elements with tagname textarea. if it has then 
		//put it in a list to be copied over 
		var textarea = $(articleEle).find("textarea");
		var select = $(articleEle).find("select");
		var tArray = []; var sArray = [];
		
		$(textarea).each(function(){
			tArray.push(textarea.val());
		});
		$(select).each(function(){
			sArray.push(select.val());
		});
		
		//get section in article, clone and put in iterator
		$("#" + article + " section").clone().appendTo("#"+iterator);
		
		//grab the last section added to the iterator and place the
		//place the new value back into the textarea
		var section = $("#"+iterator + " section").last();
		textarea = $(section).find("textarea");
		select = $(section).find("select");
		
		$(textarea).each(function(index, element){
			$(element).val(tArray[index]);
		});
		
		$(select).each(function(index, element){
			$(element).val(sArray[index]);
		});
		
		updateIndex(articleEle, sizeEle);
						
	}else{
		$(articleEle).removeClass("hidden");
	}
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
	
	//replaces the old index with the new one and clear the content
	$(ele).each(function(){ 
		var oldIndex = $(this).attr('name').match(/\[.\]/);
		var newName = $(this).attr('name').replace(oldIndex, newIndex);
		$(this).attr('name', newName); //alert(this.nodeName);
		if(this.nodeName === "SELECT")
			$(this).val(-1);
		else
			$(this).val(null);
	});
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
	var isImportant = $(selectedDiv).parent("div").parent("section").css('backgroundColor');
	if (isImportant == "rgb(255, 250, 250)")
	{
		$(selectedDiv).parent("div").parent("section").css({'background-color':'#fddabe'});
		$(selectedDiv).css({'background':'orange'});
	}
	else
	{
		$(selectedDiv).parent("div").parent("section").css({'background-color':'snow'});
		$(selectedDiv).css({'background':'#d6d6d6'});
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
		//$(section).css("visibility", "hidden");
		//$(section).css("position", "absolute");
		//$(section).css("top", "0");
		$(section).css("display", "none");
		
		//$(selectedDiv).parents("article").addClass("hidden")
	}
	else
		$(section).hide();
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

