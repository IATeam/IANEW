<h3 class="sixteen columns" style="float:none;">Summary</h3>
<div class="fieldsetborder">
	<fieldset>
	
		<div class="row">
			<div class="four columns"><s:select cssClass="four columns" list="#{'1':'type' }"  name="" headerKey="-1" headerValue="Type" /></div>
			
			
			<div class="textarea twelve columns">
				<s:label for="description" value="Description:" />
				<div>
					<!-- get a description for enquiry summary  -->
					<s:if test="formTitle='formTitle'">
						<s:textarea id="description" cssClass="multiLineTextArea" name="enquiry.description" />
					</s:if>
					<!-- get the decription for case summary -->
					<s:else>
						<s:textarea id="description" cssClass="multiLineTextArea" name="case.description" />
					</s:else>
				</div>
			</div>
		</div>
		
	</fieldset>
</div>