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
		08/09/2014 -	Quang Nhan
						changed all iamodel.contact to iamodel.contact
		16/09/2014 -	Quang Nhan
						Moved iteration to iterDisability.jsp to accommodate ajax deletion
						Updated javascript primaryUpdate with a argument to allow more direct dom
						calling and update primary flag value.
		17/09/2014 -	David Forbes modified theDisability with value attribute
		18/09/2014 -	Quang Nhan Add validation refer to enquiryValidation.js file and fix index bugs
						when it is a new enquiry
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<!-- TODO LATER: add js function to click to select primary disability -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<h3 class="sixteen columns" style="float:none;">Disability</h3>
<s:div cssClass="greybackground">


	<article id="itDisability">
		<%@include file="iterDisabilities.jsp" %>
	</article>	
		
	<!-- disabilitySize(hidden field) used to assign index value when adding or deleting -->	
	<s:if test="%{iamodel.contact.disabilitiesList.size > 0}">
		<s:hidden id="disabilitySize" name="iamodel.contact.disabilitiesList.size" value="%{iamodel.contact.disabilitiesList.size}"/>
		<s:set name="index" value="iamodel.contact.disabilitiesList.size" />
		<article id="artDisability" class="hidden">
	</s:if>
	
	<s:else>
		<s:hidden id="disabilitySize" name="iamodel.contact.disabilitiesList.size" value="0"/>
		<s:set name="index" value="0" />
		<article id="artDisability">
	</s:else>
		<section class="sixteen columns curveBorder row">
				<s:hidden name="iamodel.contact.disabilitiesList[%{#index}].id"/>
				<s:hidden name="iamodel.contact.disabilitiesList[%{#index}].primaryFlag"/>
				
				<s:div cssClass="four columns alpha">
					<s:div cssClass="disabilityTypeSelect row four columns">
						<s:select list="disabilitySelectList.{disabilityName}" name="theDisabilityList[%{#index}]" value="iamodel.contact.disabilitiesList.disabilityType.disabilityName" headerKey="-1" headerValue="Select Disability" />
					</s:div>
					
					<s:div cssClass="row four columns" style="text-align: center">
						<input type="radio" name="primary" onclick="primaryUpdate(this)"/>
						<s:label value="Primary Disability" />						
					</s:div>
				</s:div>
				<s:div cssClass="textarea eleven columns">
					<s:label for="disabilityDescription" value="Comment:" /> 
					<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea" name="iamodel.contact.disabilitiesList[%{#index}].comments" /> 
				</s:div>
				<input type="button" value="delete" onclick="deleteSection(this)"/> 
			</section>
	</article>
	
	<div class="row">
		<input type="button" id="btnNewDisability" value ="New Disability Type" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		<input type="button" id="btnAddDisability" value="Add Disability" class="two columns" onclick="addNewRecord('artDisability', 'disabilitySize', 'itDisability' )"/>
	</div>
	
	<script>
	
	function primaryUpdate(radio){ 
		if($('[name="primary"]').is(':checked')){
			$(radio).parents("section").addClass("primary");
			var otherRadio = $('input[name="primary"]:unchecked');

			$(otherRadio).parents("section").removeClass("primary");
			var eachRadio = $(otherRadio).parents("section").find("input[name*='Flag']");

			$(eachRadio).each(function(){
				$(this).val(null);
			});
			var primaryFlag = $(radio).parents("section").find("input[name*='Flag']").first();
				$(primaryFlag).val("Y");
		
		}
	};
	
	$(function(){
		//mark the check box if primary
		var it = $("#itDisability").find("section");
		
		$(it).each(function(index, section){
			//grab names in this section with primaryFlag substring.
			var deep = $(section).find("input[name*='Flag']")
			
			//mark as check and assign the section with class primary
			$(deep).each(function(){
				if($(this).val()=='Y'){
					var radios = $(section).find("[name='primary']").first();
					$(radios).prop("checked", true);
					$(section).addClass("primary");
				}
			});
		});
		
		$("#btnNewDisability").click(function(){
			$("#leftPopUp").load("/IANEW/admin/getDisabilityTypeForm", function(){
				$("#leftPopUp").show("slow");
			});
		});
	});
	</script>
	
</s:div>
