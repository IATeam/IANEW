<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="dangerSelectList" status="stat">
<tr>
<td><s:property value="%{dangerName}"></s:property></td>
<td><s:property value="%{dangerDescription}"></s:property></td>
</tr>
</s:iterator>