<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<!-- TODO LATER: add js function to click to select primary disability -->

<h3 class="sixteen columns" style="float:none;">Disability</h3>
<s:div cssClass="greybackground">
	
	<!-- <s:if test="" >
		<s:iterator value="">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					
				</fieldset>
			</s:div>
		</s:iterator>
	</s:if> -->
	
	
	
	<article id="artDisability">
	
		<s:iterator value="clientDisabilities">
		
			<div class="divDisability row">
				<section class="sixteen columns curveBorder primary">
					<div class="four columns"><s:select list="disabilitySelectList.{disabilityName}" value="theDisability" name="theDisability" headerKey="-1" headerValue="Select Disability" /></div>
					<div class="textarea eleven columns">
						<s:label for="disabilityDescription" value="Disability Description:" /> 
						<s:textarea id="disabilityDescription" cssClass="oneLineTextArea" name="comments"></s:textarea> 
					</div>
				</section>
			</div>
			<p><s:property value='primaryFlag' /></p>
		
		</s:iterator>
	
		<div class="divDisability row">
			<section class="sixteen columns curveBorder primary">
				<div class="four columns"><s:select list="disabilitySelectList.{disabilityName}" value="personTitleProtege" name="theDisability" headerKey="-1" headerValue="Select Disability" /></div>
				<div class="textarea eleven columns">
					<s:label for="disabilityDescription" value="Disability Description:" /> 
					<s:textarea id="disabilityDescription" cssClass="oneLineTextArea"></s:textarea> 
				</div>
			</section>
		</div>
		
		<div class="divDisability row">
			<section class="sixteen columns curveBorder">
				<div class="four columns"><s:select list="disabilitySelectList.{disabilityName}" value="personTitleProtege" name="theDisability" headerKey="-1" headerValue="Select Disability" /></div>
				<div class="textarea eleven columns">
					<s:label for="disabilityDescription" value="Disability Description:" /> 
					<s:textarea id="disabilityDescription" cssClass="oneLineTextArea"></s:textarea> 
				</div>
			</section>
		</div>
	</article>
	
	
	
	<div class="row">
		<div class="fourteen columns alpha"><p></p></div>
		<input type="button" id="btnNewDisability" value="New Disability" class="two columns" />
	</div>
	
	<script>
	$(function(){
		$("#btnNewDisability").click(function(){ 
			$(".divDisability").last().clone().appendTo("#artDisability");
		});
	});
	</script>
	
</s:div>
