<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="culturalBackgroundSelectList" status="stat">
<tr>
<td><s:property value="%{culturalBackgroundName}"></s:property></td>
<td><s:property value="%{culturalBackgroundDescription}"></s:property></td>
</tr>
</s:iterator>