<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="accommodationSelectList" status="stat">
<tr>
<td ondblclick="edit(this)"><s:property value="%{accommodationName}"></s:property></td>
<td><s:property value="%{accommodationDescription}"></s:property></td>
</tr>
</s:iterator>
<script>
	function edit(object){
		var oldContent = object.innerHTML;
		object.innerHTML = "<input type='text' value='"+ oldContent +"'/>";
		$(object).attr("ondblclick", null);
		if($("#btnEditAccommodation").hasClass("hidden"))
			$("#btnEditAccommodation").removeCss("hidden");
	}
	
</script>