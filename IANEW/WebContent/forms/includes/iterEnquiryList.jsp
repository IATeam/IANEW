<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="list">
			
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry" />
	<s:iterator value="model">
		<s:div cssClass="curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
			<s:div cssClass="row" cssStyle="margin-bottom:1px">
				<s:div cssClass="textarea two columns">
					<s:label for="id" value="Enquiry#:" />
					<p class="id"><s:property value="id"/></p>
				</s:div>
				<div class="textarea two columns">
					<s:label for="id" value="satus:" />
					<p><s:property value="statusType.statusName"/></p>
				</div>
				<s:div cssClass="textarea four columns">
					<s:label for="firstname" value="firstname:" />
					<p><s:property value="contact.firstname" /></p>
				</s:div>
				<s:div cssClass="textarea three columns">
					<s:label for="othername" value="othername:" />
					<p><s:property value="contact.othername" /></p>
				</s:div>
				<s:div cssClass="textarea four columns omega">
					<s:label for="lastname" value="lastname:" />
					<p><s:property value="contact.lastname" /></p>
				</s:div>
			</s:div>
			
			<s:div cssClass="row" cssStyle="margin-top: 1px;">
				<s:div cssClass="textarea four columns">
					<s:label value="Created Date:" />
					<p><s:date name="createdDateTime" format="dd-MMM-YYYY"/></p>
				</s:div>
				<s:div cssClass="textarea four columns">
					<s:label value="Updated Date:" />
					<p><s:date name="updatedDateTime" format="dd-MMM-YYYY"/></p>
				</s:div>
				<s:div cssClass="textarea seven columns omega">
					<s:label for="issues" value="Issues:" />
					<p><s:property value="issuesTypes" /></p>
				</s:div>
			</s:div>
			
			<s:div cssClass="row toggled">
				<s:div cssClass="textarea fifteen columns omega">
					<s:label for="description" value="Description:" />
					<s:div><s:textarea cssClass="multiLineTextArea" name="description" readonly="true"/></s:div>
				</s:div>
			</s:div>
		</s:div>
	</s:iterator>
</s:div>
<s:div cssClass="clear"/>
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
<!-- the footer of the form containing the cancel, open enquiry and new enquiry as well as the pagination functions -------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
			
<s:div style="background:#444444; margin-top: 10px; padding: 5px;">
	<s:div cssClass="row">
	
		<section class="four columns alpha">
			<input type="button" class="three columns" value="Close"  onclick="confirmAction('Are you sure you want to Close?', 'home', 'home')"/>
		</section >
				
		<s:div cssClass="eight columns">
			<s:div cssClass="one column alpha"><p></p></s:div>
			<input type="button" id="btnPrevEnquiries" class="one column" onclick="loadList(this)" value="prev"/>
			
			<s:hidden id="startIndex" name="startIndex" />
			<s:hidden id="recordsPerPage" name="recordsPerPage" />
			
			<s:div cssClass="three columns" style="text-align:center;">
				<s:textfield size="1" id="currentPage" name="currentPage" cssClass="one columns alpha" onchange="loadList(this)"/> of 
				<s:div id="totalNumberOfPagesDiv" style="display: inline"> <s:property value="totalNumberOfPages"/> </s:div>
			</s:div>

			<input type="button" id="btnNextEnquiries" class="one column" onclick="loadList(this)" value="next"/>

			<s:div cssClass="two column omega"><p></p></s:div>
		</s:div>
		
		<section class="four columns omega">
			<sj:submit id="open" targets="formDiv" cssClass="two columns alpha" value="Open Enquiry" onBeforeTopics="beforeSubmit"/>
			<sj:a id="btnNewE" targets="formDiv"  href="%{urlENew}" ><input type="button" class="two columns omega" value="New Enquiry" onclick="confirmAction('Are you sure you want to create a new enquiry?', 'enquiry', 'newEnquiry')"/></sj:a>
		</section>
	</s:div>
</s:div>
<script>
$(".toggled").hide();
</script>
