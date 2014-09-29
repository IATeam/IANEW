<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="disabilitySelectList" status="stat">
	<tr>
		<td><s:property value="%{disabilityName}"></s:property></td>
		<td><s:property value="%{disabilityDescription}"></s:property></td>
	</tr>
</s:iterator>