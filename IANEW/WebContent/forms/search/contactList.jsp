<%@ taglib prefix="s" uri="/struts-tags" %>

<s:iterator value="contactList">
	<s:div cssClass="list curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
		<s:div cssClass="row">
			<s:div cssClass="textarea three columns">
				<s:label for="id" value="Client#:" />
				<p class="id"><s:property value="id"/></p>
			</s:div>
			<s:div cssClass="textarea four columns">
				<s:label value="firstname:" />
				<p><s:property value="firstname" /></p>
			</s:div>
			<s:div cssClass="textarea four columns">
				<s:label value="othername:" />
				<p><s:property value="othername" /></p>
			</s:div>
			<s:div cssClass="textarea four columns">
				<s:label value="lastname:" />
				<p><s:property value="lastname" /></p>
			</s:div>
		</s:div>
		
		<s:div cssClass="row toggled">
			<s:div cssClass="textarea fifteen columns omega">
				<s:div>
					<s:textarea cssClass="multiLineTextArea" readonly="true">
						<p style="color: grey;">Title: </p><p><s:property value="titleType.name" />, </p>
						<p style="color: grey;">Gender: </p><p><s:property value="genderType.genderName" />, </p>
						<p style="color: grey;">Email: </p><p><s:property value="email"/>, </p>
						<p style="color: grey;">Mobile: </p><p><s:property value="mobilephone"/></p>
					</s:textarea>
				</s:div>
			</s:div>
		</s:div> 
	</s:div>
</s:iterator>

<s:div cssClass="row">
	<input id="btnCancelSelectContact" type="button" value="Cancel" class="two columns omega" onclick="<!-- clearSearchForm(secContactSearch) -->"/>
	<s:div cssClass="four columns alpha"><p></p></s:div>
	<input id="btnPrevContacts" type="button" value="prev" class="one column" onclick="loadContactList(this)"/>
	
	
	<s:div cssClass="three columns" style="text-align:center;">
		page <s:textfield size="1" id="currentPage" name="currentPage" cssClass="one columns alpha" onchange="loadContactList(this)"/> of 
		<s:div id="totalNumberOfPagesDiv" style="display: inline"> <s:property value="totalNumberOfPages"/> </s:div>
	</s:div>
	
	<s:hidden id="startIndex" name="startIndex" />
	<s:hidden id="recordsPerPage" name="recordsPerPage" />
	
	<input id="btnNextContacts" type="button" value="next" class="one column" onclick="loadContactList(this)"/>
	<s:div cssClass="three columns alpha"><p></p></s:div>
	<input id="btnSelectContact" type="button" value="Select" class="two columns omega"/>
</s:div>

<script>
$(".toggled").hide();
$("#btnSelectContact").click(function(){
	var sent = false;
	var contactid = parseInt($("#selectedContact").val());
	if($("#formTitle").text() == "New Enquiry" || $("#formTitle").text() == "Existing Enquiry"){
		if($("#selectedContact").val() !== ""){
			$("#contactInfo").load("enquiry/assignContact.action?contactid=" + contactid + "&call=1");
			
			$("#divDanger").load("enquiry/assignContact.action?contactid=" + contactid + "&call=2");
			
			sent = true;
		}
	}else if($("#formTitle").text() == "New Case" || $("#formTitle").text() == "Existing Case"){
		if($("#selectedContact").val() !== ""){
			$("#contactInfo").load("case/assignContact.action?contactid=" + contactid + "&call=1");
			$("#divDanger").load("case/assignContact.action?contactid=" + contactid + "&call=2");
			
			sent = true;
		}
	}
	if(sent === true)
		$('#caseForm, #enquiryForm').find(".saturate").removeClass('saturate');
}); 

$("#btnCancelSelectContact").click(function(){
	$('#caseForm, #enquiryForm').find(".saturate").removeClass('saturate');
	$("#contactSearchDiv").addClass("hidden");
});
</script>
