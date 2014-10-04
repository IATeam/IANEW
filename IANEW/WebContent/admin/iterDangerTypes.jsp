<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="dangerSelectList" status="stat">
<tr>
<td data-ref="dangerSelectList.dangerName" ondblclick="edit(this, 'btnEditDanger')">
	<s:property value="%{dangerName}" />
</td>
<td data-ref="dangerSelectList.dangerDescription" ondblclick="edit(this, 'btnEditDanger')">
	<s:property value="%{dangerDescription}" />
</td>
</tr>
</s:iterator>