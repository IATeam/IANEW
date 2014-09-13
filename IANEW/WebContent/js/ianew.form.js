/**---------------------------------------------------------------------------------------------
	@author: Quang Nhan
	Created Date: 02/09/2014
	==============================================
	Updates: 
		06/08-2014 -	Quang Nhan
						Modified addNewRecord function to cater for textarea and select
						tags that does not get fully copied called by JQuery's clone function.
		
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
function removeNull(articleEle){ 
	var ele = $(articleEle).find("[name]");
	var isAllNull = true;
	$(ele).each(function(){
		if($(this).val().length > 0){
			isAllNull = false;
			//alert($(this).val())
		}
			
	});
	if(isAllNull === true){//alert("in removing null");
		$(articleEle).remove();
	}
}