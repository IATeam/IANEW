<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="row">
	<s:div cssClass="sixteen columns" style="text-align: center;">
		
		
		<s:radio list="sortOptionList" name="sort"></s:radio>
		
		<s:label for="filter" value="Filter:"/>
		<s:select list="#{'all':'all', 'closed': 'closed', 'opened':'opened'}" id="filter"/>
		
		<input type="button" value="Update" />
		
		
		
	</s:div>
</s:div>