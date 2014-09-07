<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan

		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		21/08/2014 -	Added 'Add Disability' and functionality
						Add radio button for selecting primary disability option and jquery functions
						to change the background color
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<!-- TODO LATER: add js function to click to select primary disability -->

<h3 class="sixteen columns" style="float:none;">Disability</h3>
<s:div cssClass="greybackground">
	<article id="itDisability">
		<s:iterator value="ccontact.disabilitiesList" status="stat">
			<section class="sixteen columns curveBorder row">
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].id"/>
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].createdUserId"/>
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].createdDateTime"/>
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].updatedUserId"/>
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].updatedDateTime"/>
				<s:hidden name="ccontact.disabilitiesList[%{#stat.index}].primaryFlag"/>
				<s:div cssClass="four columns alpha">
					<s:div cssClass="disabilityTypeSelect row four columns">
						<s:select list="disabilitySelectList.{disabilityName}" name="ccontact.disabilitiesList[%{#stat.index}].disabilityType.disabilityName" headerKey="-1" headerValue="Select Disability" />
					</s:div>
					<s:div cssClass="row four columns" style="text-align: center">
						<s:textfield type="text" name="ccontact.disabilitiesList[%{#stat.index}].primaryFlag" />
						<!-- if primary flag is Y then mark check -->
						<!-- <s:if test='%{ccontact.disabilitiesList[%{#stat.index}].primaryFlag == Y}'>
							<h1>Primary</h1>
							<input type="radio" name="primary" checked="checked"/>
						</s:if>
						<s:else>
							<input type="radio" name="primary"/>
						</s:else> -->
						
						<input type="radio" name="primary"/>
						<s:label value="Primary Disability"/>	
						
					</s:div>
				</s:div>
				<s:div cssClass="textarea eleven columns">
					<s:label for="disabilityDescription" value="Comment:" /> 
					<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea" name="ccontact.disabilitiesList[%{#stat.index}].comments"></s:textarea> 
				</s:div>
			</section>
		</s:iterator>
	</article>
	
	<!-- Hidden disability to be added to iterator if needs to be added -->

	
	<s:textfield id="disabilitySize" name="ccontact.disabilitiesList.size" value="%{ccontact.disabilitiesList.size}"/>
	
	<s:if test="%{ccontact.disabilitiesList.size > 0}"><article id="artDisability" class="hidden"></s:if>
	<s:else><article id="artDisability""></s:else>
		<section class="sixteen columns curveBorder row">
				<s:hidden name="ccontact.disabilitiesList[%{ccontact.disabilitiesList.size}].id"/>
				
				<s:div cssClass="four columns alpha">
					<s:div cssClass="disabilityTypeSelect row four columns">
						<s:select list="disabilitySelectList.{disabilityName}" name="ccontact.disabilitiesList[%{ccontact.disabilitiesList.size}].disabilityType.disabilityName" headerKey="-1" headerValue="Select Disability" />
					</s:div>
					<s:div cssClass="row four columns" style="text-align: center">
						
						<input type="radio" name="primary" />
						<s:label value="Primary Disability" />						
					</s:div>
				</s:div>
				<s:div cssClass="textarea eleven columns">
					<s:label for="disabilityDescription" value="Comment:" /> 
					<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea" name="ccontact.disabilitiesList[%{ccontact.disabilitiesList.size}].comments" /> 
				</s:div>
			</section>
	</article>
	
	<div class="row">
		<input type="button" id="btnNewDisability" value ="New Disability Type" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		<input type="button" id="btnAddDisability" value="Add Disability" class="two columns" onclick="addNewRecord('artDisability', 'disabilitySize', 'itDisability' )"/>
	</div>
	
	<script>


	
	function primaryUpdate(){ 
		if($('[name="primary"]').is(':checked')){
			$('[name="primary"]:checked').parents("section").addClass("primary");
			$('[name="primary"]:unchecked').parents("section").removeClass("primary");
		}
	};
	
	$(function(){
		$("#btnNewDisability").click(function(){
			$("#leftPopUp").load("/IANEW/admin/getDisabilityTypeForm", function(){
				$("#leftPopUp").show("slow");
			});
		});
	});
	</script>
	
</s:div>
