<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="accommodationSelectList" status="stat">
<tr>
<td data-ref="accommodationSelectList.accommodationName" ondblclick="edit(this, 'btnEditAccommodation')">
	<s:property value="%{accommodationName}" />
</td>
<td data-ref="accommodationSelectList.accommodationDescription" ondblclick="edit(this, 'btnEditAccommodation')">
	<s:property value="%{accommodationDescription}" />
</td>
</tr>
</s:iterator>
<script>
	/* DAVID move these two functions and create a new ianew.admin.js file */
	/* these should work for all types so just call these functions and it should do the work */
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
</script>