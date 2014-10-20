<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="titleSelectList" status="stat">
<tr>
<td data-ref="titleSelectList.name" ondblclick="edit(this, 'btnEditTitle')">
	<s:property value="%{name}" />
</td>
</tr>
</s:iterator>
