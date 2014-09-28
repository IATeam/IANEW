<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="statusSelectList" status="stat">
<tr>
<td><s:property value="%{statusName}"></s:property></td>
</tr>
</s:iterator>