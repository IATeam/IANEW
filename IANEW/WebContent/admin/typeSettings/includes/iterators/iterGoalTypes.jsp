<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="goalSelectList" status="stat">
<tr>
<td data-ref="goalSelectList.goalTypeName" ondblclick="edit(this, 'btnEditGoal')">
	<s:property value="%{goalTypeName}" />
</td>
</tr>
</s:iterator>