<label>Linked Enquiries</label>
<s:div cssClass="greybackground">
	<s:if test="" >
		<s:iterator value="">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					<div class="textarea two columns">
						<s:label value="E#" />
						<s:textarea cssClass="oneLineTextArea"></s:textarea>		 
					</div>
					
					<div class="textarea four columns">
						<s:label value="Date:" />
						<s:textarea cssClass="oneLineTextArea"></s:textarea>		 
					</div>
					
					<div class="textarea six columns">
						<s:label value="Enquiry Description:" />
						<s:textarea label="issuedescription" cssClass="oneLineTextArea"></s:textarea>		 
					</div>
				</fieldset>
			</s:div>
		</s:iterator>
	</s:if>
	<ul id="ulistIssues">
		<li class="list">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					<div class="textarea two columns">
						<s:label value="E#" />
						<s:textarea cssClass="oneLineTextArea"></s:textarea>		 
					</div>
					
					<div class="textarea four columns">
						<s:label value="Date:" />
						<s:textarea cssClass="oneLineTextArea"></s:textarea>		 
					</div>
					
					<div class="textarea six columns">
						<s:label value="Enquiry Description:" />
						<s:textarea label="issuedescription" cssClass="oneLineTextArea"></s:textarea>		 
					</div>
				</fieldset>
			</s:div>
		</li>
	</ul>
	<div class="divbuttons">
		<input type="button" id="btnOpen" value="Open" />
		<input type="button" id="btnAddEnquiry" value="Add Enquiry" />
	</div>
	
	<script>
	$(function(){
		$("#btnNewIssue").click(function(){ 
			$("#ulistIssues li").first().clone().appendTo("#ulistIssues");
		});
	});
	</script>
</s:div>