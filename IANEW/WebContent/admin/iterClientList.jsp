<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="clientSelectList" status="stat">
<tr>
<td><s:property value="%{firstname}"></s:property></td>
<td><s:property value="%{lastname}"></s:property></td>
</tr>
</s:iterator>