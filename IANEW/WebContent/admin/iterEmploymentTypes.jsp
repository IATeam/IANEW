<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="employmentSelectList" status="stat">
<tr>
<td><s:property value="%{employmentName}"></s:property></td>
<td><s:property value="%{employmentDescription}"></s:property></td>
</tr>
</s:iterator>