<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="genderSelectList" status="stat">
<tr>
<td data-ref="genderSelectList.genderName" ondblclick="edit(this, 'btnEditGender')">
	<s:property value="%{genderName}" />
</td>
<td data-ref="genderSelectList.genderCode" ondblclick="edit(this, 'btnEditGender')">
	<s:property value="%{genderCode}" />
</td>
</tr>
</s:iterator>