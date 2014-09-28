<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="genderSelectList" status="stat">
<tr>
<td><s:property value="%{genderName}"></s:property></td>
<td><s:property value="%{genderDescription}"></s:property></td>
</tr>
</s:iterator>