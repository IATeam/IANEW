<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="disabilitySelectList" status="stat">
<tr>
<td data-ref="disabilitySelectList.disabilityName" ondblclick="edit(this, 'btnEditDisability')">
	<s:property value="%{disabilityName}" />
</td>
<td data-ref="disabilitySelectList.disabilityDescription" ondblclick="edit(this, 'btnEditDisability')">
	<s:property value="%{disabilityDescription}" />
</td>
</tr>
</s:iterator>
