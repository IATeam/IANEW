<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="IssueTypeList" status="stat">
<tr>
<td data-ref="IssueTypeList.issueName" ondblclick="edit(this, 'btnEditIssue')">
	<s:property value="%{issueName}" />
</td>
<td data-ref="IssueTypeList.issueDescription" ondblclick="edit(this, 'btnEditIssue')">
	<s:property value="%{issueDescription}" />
</td>
</tr>
</s:iterator>