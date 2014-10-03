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
		29/09/2014 -	Quang Nhan modified select list to accommodate value by id rather than name
						Fixed bugs related to primary flag
						Fixed primaryFlag js function relating to the bug that only assign "Y" to the
						the first band
						Added img delete button and modified expand button
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags"%>
<section>
<img src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Disability</h3>
<div class="greybackground">
<div id="disabilityDiv" class="toggled hideable">	

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
			<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
			<s:hidden name="iamodel.contact.disabilitiesList[%{#index}].id"/>
			<s:hidden name="iamodel.contact.disabilitiesList[%{#index}].primaryFlag"/>
			
			<s:div cssClass="four columns alpha">
				<s:div cssClass="disabilityTypeSelect row four columns">
					<s:select list="disabilitySelectList" listKey="id" listValue="disabilityName" name="theDisabilityListId[%{#index}]" headerKey="-1" headerValue="Select Disability" />
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
		</section>
	</article>
	
	<div class="row">
		<div class="fourteen columns alpha"><p></p></div>
		<input type="button" id="btnAddDisability" value="Add Disability" class="two columns" onclick="addNewRecord('artDisability', 'disabilitySize', 'itDisability' )"/>
	</div>
	
	<script>
	
	function primaryUpdate(radio){ 
		if($('[name="primary"]').is(':checked')){
			//add the css class primary to the section tag of the radio input
			$(radio).parents("section").addClass("primary");

			//find all unchecked input radio and remove the css calss primary
			var otherRadio = $('input[name="primary"]:unchecked');
			$(otherRadio).parents("section").removeClass("primary");

			//find all primary flag tags
			var eachprimary = $(otherRadio).parents("section").find("input[name*='Flag']");

			// and assign empty value
			$(eachprimary).each(function(){
				if($(this).val() == 'Y'){
					$(this).val("");
				}	
			});
			
			//grab the hidden field with with the name primary flag and assign Y to its value
			$(radio).parents("section").children("input[name*='Flag']").val("Y");

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
	
</div>
</div>
</section>