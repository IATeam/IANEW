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
	<input id="btnCancelSelectPlanContact" type="button" value="Cancel" class="two columns omega"/>
	<s:div cssClass="four columns alpha"><p></p></s:div>
	<input id="btnPrevPlanContacts" type="button" value="prev" class="one column" onclick="loadPlanContactList(this)"/>
	
	
	<s:div cssClass="three columns" style="text-align:center;">
		page <s:textfield size="1" id="currentPlanPage" name="currentPage" cssClass="one columns alpha" onchange="loadPlanContactList(this)"/> of 
		<s:div id="totalNumberOfPagesPlanDiv" style="display: inline"> <s:property value="totalNumberOfPages"/> </s:div>
	</s:div>
	
	<s:hidden id="startIndexPlan" name="startIndex" />
	<s:hidden id="recordsPerPagePlan" name="recordsPerPage" />
	
	<input id="btnNextPlanContacts" type="button" value="next" class="one column" onclick="loadPlanContactList(this)"/>
	<s:div cssClass="three columns alpha"><p></p></s:div>
	<input id="btnSelectPlanContact" type="button" value="Select" class="two columns omega"/>
</s:div>

<script>
	$(".toggled").hide();
	$("#btnSelectPlanContact").click(function(){
		var contactid;
		contactid=parseInt($("#selectedPlanContact").val());
		
		if(contactid !== "" && contactid != null && !isNaN(contactid)){
			if ($("#radioSupport").is(":checked")) {
				$("#supportPersonDiv").load("/IANEW/case/assignSupportContact.action?supportContactId=" + contactid);
			}
			else 
				$("#authorisedPersonDiv").load("/IANEW/case/assignAuthorisedContact.action?authorisedContactId=" + contactid);
			$("#planSearchDiv").load("/IANEW/case/clearContactList.action");
			$("#planSearchDiv").addClass("hidden");
		}
	}); 
	
	$("#btnCancelSelectPlanContact").click(function(){
		$("#planSearchDiv").addClass("hidden");
	});
</script>