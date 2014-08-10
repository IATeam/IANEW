

<!-- TODO LATER -->

<h3 class="sixteen columns" style="float:none;">Disability</h3>
<s:div cssClass="greybackground sixteen columns">
	
	<s:if test="" >
		<s:iterator value="">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					
				</fieldset>
			</s:div>
		</s:iterator>
	</s:if>
	
		
	<div class="row primaryDisability">
		<s:select cssClass="four columns" list="#{'1':'Disability (Attention)'}" id="accommodationType" name="" />
		<div class="textarea twelve columns">
			<s:label for="disabilityDescription" value="Disability Description:" /> 
			<s:textarea id="disabilityDescription" cssClass="oneLineTextArea"></s:textarea> 
		</div>
	</div>
	
	<div class="row secondaryDisability">
		<s:select cssClass="four columns" list="#{'1':'Disability (Attention)'}" id="accommodationType" name="" />
		<div class="textarea twelve columns">
			<s:label for="disabilityDescription" value="Disability Description:" /> 
			<s:textarea id="disabilityDescription" cssClass="oneLineTextArea"></s:textarea> 
		</div>
	</div>
	
	
	<div class="divbuttons">
		<input type="button" id="btnNewDisability" value="New Disability" />
	</div>
	
	<script>
	$(function(){
		$("#btnNewDisability").click(function(){ 
			$("#ulistDisability li").first().clone().appendTo("#ulistDisability");
		});
	});
	</script>
	
</s:div>
