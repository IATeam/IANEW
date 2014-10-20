<<<<<<< Upstream, based on origin/Kim
<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="list">
	<s:iterator value="model">
		<s:div cssClass="curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
			<s:div cssClass="row">
				<s:div cssClass="textarea two columns">
					<s:label for="id" value="Enquiry#:" />
					<p class="id"><s:property value="id"/></p>
				</s:div>
				<s:div cssClass="textarea five columns">
					<s:label for="protege" value="Protege:" />
					<p><s:property value="contact.fullName" /></p>
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label value="Date:" />
					<p><s:property value="updatedDateTime" /></p>
				</s:div>
				<s:div cssClass="textarea six columns omega">
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
	
		<section class="four columns">
			<input type="button" class="three columns" value="Close"  onclick="confirmAction('Are you sure you want to Close?', 'home', 'home')"/>
		</section >
		
		<section class="eight columns">
			<%@include file="/forms/includes/paginationToolSet.jsp" %>
		</section>
		
		<section class="four columns alpha">
			<sj:submit id="open" targets="formDiv" cssClass="two columns alpha" value="Open Enquiry" onBeforeTopics="beforeSubmit"/>
			<sj:a id="btnNewE" targets="formDiv"  href="%{urlENew}" ><input type="button" class="two columns omega" value="New Enquiry" onclick="confirmAction('Are you sure you want to create a new enquiry?', 'enquiry', 'newEnquiry')"/></sj:a>
		</section>
		
	</s:div>
</s:div>
