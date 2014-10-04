<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="genderSelectList" status="stat">
<tr>
<td data-ref="genderSelectList.genderName" ondblclick="edit(this, 'btnEditGender')">
	<s:property value="%{genderName}" />
</td>
<td data-ref="genderSelectList.genderDescription" ondblclick="edit(this, 'btnEditGender')">
	<s:property value="%{genderDescription}" />
</td>
</tr>
</s:iterator>