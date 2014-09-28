<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="titleSelectList" status="stat">
<tr>
<td><s:property value="%{name}"></s:property></td>
</tr>
</s:iterator>