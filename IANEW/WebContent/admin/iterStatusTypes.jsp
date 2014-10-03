<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="statusSelectList" status="stat">
<tr>
<td data-ref="statusSelectList.statusName" ondblclick="edit(this, 'btnEditStatus')">
	<s:property value="%{statusName}" />
</td>
</tr>
</s:iterator>