<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="IssueTypeList" status="stat">
<tr>
<td><s:property value="%{issueName}"></s:property></td>
<td><s:property value="%{issueDescription}"></s:property></td>
</tr>
</s:iterator>