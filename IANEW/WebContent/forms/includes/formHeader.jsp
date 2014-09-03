<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/08/2014
	==============================================
	Updates:
		
	==============================================	
	Description: Description: A component of the contact that is to be displayed on both enquiry and case forms that 
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>
<script>
function expandAll() {
	$(".startShown").show();
	$(".divHideButton").attr("src","/IANEW/resources/images/minusButton.png");
}
function collapseAll() {
	$(".startShown").hide();
	$(".divHideButton").attr("src","/IANEW/resources/images/plusButton.png");
}
</script>

<section class="imageContainer">
	<s:div cssClass="row">
		<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
		<s:div cssClass="headerText nine columns">
			<s:div id="formTitle"><s:text name="formTitle" /></s:div>
		</s:div>		
	</s:div>
	<s:if test="%{#formType=='case' || #formType=='enquiry'}">
		<s:div cssClass="row">
			<section class="ten columns"><p></p></section>
			<input type="button" class="three columns omega topButton" value="Expand All" onClick="expandAll()"/>
			<input type="button" class="three columns omega topButton" value="Collapse All" onClick="collapseAll()"/>
		</s:div>
	</s:if>
</section>
