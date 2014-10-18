<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="accommodationSelectList" status="stat">
<tr>
<td data-ref="accommodationSelectList.accommodationName" ondblclick="edit(this, 'btnEditAccommodation')">
	<s:property value="%{accommodationName}" />
</td>
<td data-ref="accommodationSelectList.accommodationDescription" ondblclick="edit(this, 'btnEditAccommodation')">
	<s:property value="%{accommodationDescription}" />
</td>
</tr>
</s:iterator>