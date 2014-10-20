/**---------------------------------------------------------------------------------------------
	@author: Quang Nhan
	@author: David Forbes
	Created Date: 02/10/2014
	Description: This js is for the common functions in the settings
------------------------------------------------------------------------------------------------*/

	function edit(object, btnName){ 
		var tr = $(object).parents("tr");
		var ref = $(object).attr("data-ref");
		var split = ref.split('.');
		alert(split[0] + " " + split[1]);
		$(tr).each(function(){
			var index = this.rowIndex - 1;
			var bracedIndex = "["+ index +"].";
			var fullRef = split[0] + bracedIndex + split[1];
			
			var oldContent = object.innerHTML;
			var newContent = "<input type='text' name='" + fullRef + "' value='" + oldContent + "'/>";
			
			object.innerHTML = newContent;
			
			$(object).attr("ondblclick", null);
			
			if($("#" + btnName).hasClass("hidden"))
				$("#" + btnName).removeClass("hidden");
		});
	}

	function hideBtn(btn){
		$(btn).addClass("hidden");
	}