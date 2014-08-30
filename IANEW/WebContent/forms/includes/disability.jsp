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
		<s:iterator value="clientDisabilitiesSet">
			<section class="sixteen columns curveBorder row">
				<s:div cssClass="four columns alpha">
					<s:div cssClass="disabilityTypeSelect row four columns">
						<s:select list="disabilitySelectList.{disabilityName}" name="getDisabilityType().getDisabilityName()" headerKey="-1" headerValue="Select Disability" />
					</s:div>
					<s:div cssClass="row four columns" style="text-align: center">
						
						<input type="radio" name="primary" />
						<s:label value="Primary Disability" />						
					</s:div>
				</s:div>
				<s:div cssClass="textarea eleven columns">
					<s:label for="disabilityDescription" value="Disability Description:" /> 
					<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea" name="comments"></s:textarea> 
				</s:div>
			</section>
		</s:iterator>
	</article>
	
	<!-- Hidden disability to be added to iterator if needs to be added -->
	<article id="artDisability" style='visiblity: hidden; display: none;'>
		<section class="sixteen columns curveBorder row">
			<s:div cssClass="four columns alpha">
				<s:div cssClass="row four columns">
					<s:select list="disabilitySelectList.{disabilityName}" name="theDisability" headerKey="-1" headerValue="Select Disability" />
				</s:div>
				<s:div cssClass="row four columns" style="text-align: center">
					<input type="radio" name="primary" onchange="primaryUpdate()"/>
					<s:label value="Primary Disability" />
				</s:div>
			</s:div>
			<s:div cssClass="textarea eleven columns">
				<s:label for="disabilityDescription" value="Disability Description:" /> 
				<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea"></s:textarea> 
			</s:div>
		</section>
	</article>
	
	<div class="row">
		<input type="button" id="btnNewDisability" value ="New Disability" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		<input type="button" id="btnAddDisability" value="Add Disability" class="two columns" />
	</div>
	
	<script>
	function primaryUpdate(){ 
		if($('[name="primary"]').is(':checked')){
			$('[name="primary"]:checked').parents("section").addClass("primary");
			$('[name="primary"]:unchecked').parents("section").removeClass("primary");
		}
	};
	
	$(function(){
		$("#btnAddDisability").click(function(){ 
			$("#artDisability section").clone().appendTo("#itDisability");
		});
		
		$("#btnNewDisability").click(function(){
			$("#leftPopUp").load("/IANEW/admin/getDisabilityTypeForm", function(){
				$("#leftPopUp").show("slow");
			});
		});
		
	});
	</script>
	
</s:div>
