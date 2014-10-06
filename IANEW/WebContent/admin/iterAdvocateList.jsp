<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="advocateSelectList" status="stat">
<tr>
<td onclick()><s:property value="%{firstname}"></s:property></td>
<td><s:property value="%{lastname}"></s:property></td>
</tr>
</s:iterator>