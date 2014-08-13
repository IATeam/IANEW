/**
 * 
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
	var activityLength = $('#artActivityList ol li').size()
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
	
	//looping through a list
//	var listItems = $("#artActivityList ol li");
//	listItems.each(function(idx, li){
//		
//	});
	
}