<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="culturalBackgroundSelectList" status="stat">
<tr>
<td data-ref="culturalBackgroundSelectList.culturalBackgroundName" ondblclick="edit(this, 'btnEditCulturalBackground')">
	<s:property value="%{culturalBackgroundName}" />
</td>
<td data-ref="culturalBackgroundSelectList.culturalBackgroundDescription" ondblclick="edit(this, 'btnEditCulturalBackground')">
	<s:property value="%{culturalBackgroundDescription}" />
</td>
</tr>
</s:iterator>