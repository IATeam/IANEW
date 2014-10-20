<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="communicationSelectList" status="stat">
<tr>
<td data-ref="communicationSelectList.communicationTypeName" ondblclick="edit(this, 'btnEditCommunication')">
	<s:property value="%{communicationTypeName}" />
</td>
</tr>
</s:iterator>