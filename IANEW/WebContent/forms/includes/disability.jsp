<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
<<<<<<< HEAD
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
=======
<<<<<<< HEAD
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		21/08/2014 -	Added 'Add Disability' and functionality
						Add radio button for selecting primary disability option and jquery functions
						to change the background color
=======
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<!-- TODO LATER: add js function to click to select primary disability -->

<section>
<h3 class="sixteen columns" style="float:none;">Disability</h3>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<s:div cssClass="greybackground">
<div id="disabilityDiv" class="toggled startShown">	
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
					<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		
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
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddDisability" value="Add Disability" class="three columns" />
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
</div></section>
