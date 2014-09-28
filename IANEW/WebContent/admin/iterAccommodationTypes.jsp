<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="accommodationSelectList" status="stat">
<tr>
<td><s:property value="%{accommodationName}"></s:property></td>
<td><s:property value="%{accommodationDescription}"></s:property></td>
</tr>
</s:iterator>