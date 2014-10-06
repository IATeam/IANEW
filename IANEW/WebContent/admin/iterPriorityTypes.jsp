<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="prioritySelectList" status="stat">
<tr>
<td data-ref="prioritySelectList.priorityName" ondblclick="edit(this, 'btnEditPriority')">
	<s:property value="%{priorityName}" />
</td>
</tr>
</s:iterator>