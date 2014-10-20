<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="advocateSelectList" status="stat">
<tr onclick="passId(this)">
<s:hidden name="advocateSelectList[%{#stat.index}].id" />
<td data-ref="advocateSelectList.firstname" >
	<s:property value="%{firstname}" />
</td>
<td data-ref="advocateSelectList.lastname">
	<s:property value="%{lastname}" />
</td>
</tr>
</s:iterator>
<script>
function passId(row){
	 var HiddenId = $(row).children("input:hidden").val();
	 $("#ContactInfo").load("/IANEW/admin/getExistingContact?hiddenid=" +  HiddenId);
}

</script>