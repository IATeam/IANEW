<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="clientSelectList" status="stat">
<tr onclick="passId(this)">
<s:hidden name="clientSelectList[%{#stat.index}].id" />
<td data-ref="clientSelectList.firstname">
	<s:property value="%{firstname}" />
</td>
<td data-ref="clientSelectList.lastname">
	<s:property value="%{lastname}" />
</td>
</tr>
</s:iterator>
<script>
function passId(row){
	 var HiddenId = $(row).children("input:hidden").val();
	 $("#ContactInfo1").load("/IANEW/admin/getExistingContact?hiddenid=" +  HiddenId);
}
</script>