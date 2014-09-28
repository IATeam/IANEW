<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="enquiryTypeSelectList" status="stat">
<tr>
<td><s:property value="%{enquiryTypeName}"></s:property></td>
<td><s:property value="%{enquiryTypeDescription}"></s:property></td>
</tr>
</s:iterator>