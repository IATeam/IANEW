<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="employmentSelectList" status="stat">
<tr>
<td data-ref="employmentSelectList.employmentName" ondblclick="edit(this, 'btnEditEmployment')">
	<s:property value="%{employmentName}" />
</td>
<td data-ref="employmentSelectList.employmentDescription" ondblclick="edit(this, 'btnEditEmployment')">
	<s:property value="%{employmentDescription}" />
</td>
</tr>
</s:iterator>