<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="enquiryTypeSelectList" status="stat">
<tr>
<td data-ref="enquiryTypeSelectList.enquiryTypeName" ondblclick="edit(this, 'btnEditEnquiry')">
	<s:property value="%{enquiryTypeName}" />
</td>
<td data-ref="enquiryTypeSelectList.enquiryTypeDescription" ondblclick="edit(this, 'btnEditEnquiry')">
	<s:property value="%{enquiryTypeDescription}" />
</td>
</tr>
</s:iterator>