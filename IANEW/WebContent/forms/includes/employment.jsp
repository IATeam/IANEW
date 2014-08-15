<h3 class="sixteen columns" style="float:none;">Employment</h3>
<div class="fieldsetborder">
	<fieldset>
	
		<div class="row">
			<!-- <div class="inputfield four columns">
				<s:label for="profession" value="Profession:" />
				<div><s:textfield id="profession" name="profession"></s:textfield></div>
			</div> -->
		<div class="four columns"><s:select list="#{'1': 'toDo'}" value="theEmployment" name="theEmployment" headerKey="-1" headerValue="Select Employment Type" /></div>
			<div class="inputfield four columns">
				<s:label for="workPhone" value="Work#:" />
				<div><s:textfield id="workPhone" name="contact.workphone"></s:textfield></div>
			</div>
		</div>
		<div class="row">
			<div class="textarea sixteen columns">
				<s:label for="employmentDescription" value="Description:" />
				<div><s:textarea id="employmentDescription" cssClass="multiLineTextArea" name="employmentDescription" readonly="true"></s:textarea></div>
			</div>
		</div>
		<div class="row">
			<div class="textarea sixteen columns">
				<s:label for="employmentComment" value="Comments:" /> 
				<div><s:textarea id="employmentComment" cssClass="multiLineTextArea" name="contact.employmentComment"></s:textarea></div>
			</div>
		</div>
		
	</fieldset>
</div>