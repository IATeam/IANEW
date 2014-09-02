<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
<<<<<<< HEAD
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
=======
<<<<<<< HEAD
		21/08/2014 -	Quang Nhan
						Added "Add Issue" button and functionality
						
=======
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<script>
function changeContact(selectedPerson) {
	var selectedContact = $(selectedPerson).val();
	var pathA = $(selectedPerson).parent("div").parent("div").parent("fieldset").children("div").children("div").children("div");
	var pathB = $(selectedPerson).parent("div").parent("div").parent("fieldset").children("div").children("div");

	if (selectedContact == -1)
	{
		 $(pathB).children("#titleContact").val("-1");
		 $(pathA).children("#firstNameContact").val("");
		 $(pathA).children("#otherNameContact").val("");
		 $(pathA).children("#lastNameContact").val("");
		 $(pathB).children("#genderContact").val("-1");
		 $(pathA).children("#birthDateContact").val("");
		 $(pathA).children("#identificationContact").val("");
		 $(pathB).children("#culturalBackgroundContact").val("-1");
		 $(pathA).children("#culturalBackgroundCommentsContact").val("");
		 $(pathA).children("#emailContact").val("");
		 $(pathA).children("#mobileContact").val("");
	}
	
    <s:iterator var="contact" value="advocateSelectList">
    	var fullname = "<s:property value='#contact.lastname'/>" + ", " + "<s:property value='#contact.firstname'/>"
    	if(selectedContact == fullname)
    	{
    	    <s:iterator var="title" value="titleSelectList">
	    		if("<s:property value='#contact.titleType.name'/>" == "<s:property value='#title.name'/>")
	    		{
	    			$(pathB).children("#titleContact").val("<s:property value='#title.name'/>");
	    		}
    	    </s:iterator>
    	    $(pathA).children("#firstNameContact").val("<s:property value='#contact.firstname'/>");
    	    $(pathA).children("#otherNameContact").val("<s:property value='#contact.othername'/>");
    	    $(pathA).children("#lastNameContact").val("<s:property value='#contact.lastname'/>");
			<s:iterator var="gender" value="genderSelectList">
	    		if("<s:property value='#contact.genderType.genderName'/>" == "<s:property value='#gender.genderName'/>")
	    		{
	    			$(pathB).children("#genderContact").val("<s:property value='#gender.genderName'/>");
	    		}
	    	</s:iterator>
	    	$(pathA).children("#birthDateContact").val("<s:property value='#contact.getDateString()'/>");
	    	$(pathA).children("#identificationContact").val("<s:property value='#contact.identification'/>");
				<s:iterator var="culturalBackground" value="culturalBackgroundSelectList">
    		if("<s:property value='#contact.culturalBackground.culturalBackgroundName'/>" == "<s:property value='#culturalBackground.culturalBackgroundName'/>")
    		{
    			$(pathB).children("#culturalBackgroundContact").val("<s:property value='#culturalBackground.culturalBackgroundName'/>");
    		}
    		</s:iterator>
    		$(pathA).children("#culturalBackgroundCommentsContact").val("<s:property value='#contact.culturalBackgroundComment'/>");
    		$(pathA).children("#emailContact").val("<s:property value='#contact.email'/>");
    		$(pathA).children("#mobileContact").val("<s:property value='#contact.mobilephone'/>");

    	}
    </s:iterator>
}
</script>
<section>
	<h3 class="sixteen columns"  style="float:none;">Plan</h3>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<div class="greybackground">
		<div id="plansDiv" class="toggled startShown">
			<fieldset>
				<div class="row">
					<div class="three columns">
						<s:select list="#{'Weekly' : 'Weekly', 'Monthly' : 'Monthly', 'Bi-Monthly' : 'Bi-Monthly'}" name="theCommunication" headerKey="-1" headerValue="Review Frequency" />
					</div>
					<div class="three columns">
					<s:label for="createdDate" value="Created Date:" />
					    <s:date name="createdDate" format="dd/MM/yyyy"/>
				    </div>
				    <div class="three columns">
					<s:label for="createdBy" value="Created By:" />
					    <s:date name="createdBy" format="dd/MM/yyyy"/>
				    </div>
				    <div class="three columns omega">
						<s:label for="completionDate" value="Completion Date:" />
					    <s:date name="completionDate" format="dd/MM/yyyy"/>
					</div>
					    <div class="four columns"><s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" /></div>
				</div>
				<div class="row">
					<div class="inputfield five columns omega">
						<s:label for="lastReviewDate" value="Last Review Date:" />
						<div><input type="date" id="lastReviewDate" name=""></div>
					</div>
					<div class="inputfield five columns omega">
						<s:label for="planProvidedDate" value="Plan Provided Date:" />
						<div><input type="date" id="planProvidedDate" name=""></div>
					</div>
					<div class="inputfield six columns omega">
						<s:label for="consentSignedDate" value="Consent Signed Date:" />
						<div><input type="date" id="consentSignedDate" name=""></div>
					</div>
				</div>
				<div class="row">
					<div class='inputfield four columns'>
									<s:label for="firstNameContact" value="Support First Name:" />
									<div><s:textfield id="firstNameContact" Key="firstName" name="contact.firstname" ></s:textfield></div>
								</div>
								<div class="inputfield four columns">
									<s:label for="otherNameContact" value="Support Other Name:" />
									<div><s:textfield id="otherNameContact" name="contact.othername"></s:textfield></div>
								</div>
								
								<div class="inputfield four columns omega">
									<s:label for="lastNameContact" value="Support Last Name:" />
									<div><s:textfield id="lastNameContact" name="contact.lastname" Key="lastname" ></s:textfield></div>
				</div>
				
				<div class="inputfield four columns omega">
									<s:label for="mobileContact" value="Support Mobile#:" />
									<div><s:textfield id="mobileContact" name="contact.mobilephone" ></s:textfield></div>
								</div>
				</div>
				<div class="row">
					<div class="textarea sixteen columns omega">
						<s:label for="notes" value="Notes:" />
						<s:textarea id="notes" cssClass="oneLineTextArea" name=""/> 
					</div>
				</div>
			</fieldset>
			<br>
			<div class="fieldsetborder">
				<h4 class="sixteen columns"  style="float:none;">Developed By</h4>
				<article id="itDeveloper">
					<s:iterator value="developerSet">		
						<section class="secIssue sixteen columns curveBorder">
							<div class="row">
								<div class="three columns">
									<s:select list="developerSelectList.{developerTypeName}" name="theDeveloper" headerKey="-1" headerValue="Developer Type" />
								</div>
								<div class="three columns">
									<s:label for="createdDate" value="Created Date:" />
								    <s:date name="createdDate" format="dd/MM/yyyy"/>
							    </div>
							    <div class="three columns">
									<s:label for="createdBy" value="Created By:" />
								    <s:date name="createdBy" format="dd/MM/yyyy"/>
							    </div>
							   	<div class="four columns">
									<s:label for="completedDate" value="Completed Date:" />
								    <s:date name="completedDate" format="dd/MM/yyyy"/>
							    </div>
							    <div class="three columns">
							    	<s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" />
						    	</div>
							</div>
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="developerDescription" value="Developer Description" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>			
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="developerAction" value="Developer Action" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>
						</section>
					</s:iterator>
				</article>
				
				<article id="artDeveloper" class="row" style="visibility: hidden; display: none;">
					<section class="secIssue sixteen columns curveBorder">
						<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
						<fieldset>
							<div class="row">
								<div class="eight columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" id="advocateList" headerKey="-1" headerValue="Select Developer" onChange="changeContact(this)" /></div>
								<section class="four columns"><p></p></section>
								<input type="button" id="btnAdvocateDetails" onclick="showContact(this, 'Developer Details')"  value="Show Developer Details" class="three columns omega"/>
							</div>		
							<div class="row toggled">
								<div class="three columns"><s:select list="titleSelectList.{name}" name="theTitle" id="titleContact" headerKey="-1" headerValue="Title" disabled="true"/></div>
								<div class='inputfield four columns'>
									<s:label for="firstNameContact" value="First Name:" />
									<div><s:textfield id="firstNameContact" Key="firstName" name="contact.firstname" readonly="true"></s:textfield></div>
								</div>
								<div class="inputfield four columns">
									<s:label for="otherNameContact" value="Other Name:" />
									<div><s:textfield id="otherNameContact" name="contact.othername" readonly="true"></s:textfield></div>
								</div>
								
								<div class="inputfield four columns omega">
									<s:label for="lastNameContact" value="Last Name:" />
									<div><s:textfield id="lastNameContact" name="contact.lastname" Key="lastname" readonly="true"></s:textfield></div>
								</div>
							</div>
							
							<div class="row toggled">
								<div class="three columns"><s:select list="genderSelectList.{genderName}" name="theGender" id="genderContact" headerKey="-1" headerValue="Gender" disabled="true"/></div>
								<!-- style="padding-right: 15px;" -->
								<div class="inputfield eight columns" >
									<s:label for="identificationContact" value="Identification:" />
									<div><s:textfield id="identificationContact" name="contact.identification" readonly="true"></s:textfield></div>
								</div>
								
								<div class="inputfield four columns omega ">
									<s:label for="birthDateContact" value="Birth Date:" />
									<div><input type="date" id="birthDateContact" name="contact.dob" readonly="true"></div>
								</div>
							</div>
							
							<div class="row toggled">
								<div class="three columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" id="culturalBackgroundContact" value="theCultrualBackground" headerKey="-1"  headerValue="Cultural Background" value="genderProtege"  disabled="true"/></div>
								
								<div class="textarea twelve columns omega">
									<s:label for="culturalBackgroundCommentsContact" value="Comments:" />
									<div><s:textarea id="culturalBackgroundCommentsContact" cssClass="oneLineTextArea" name="contact.culturalBackgroundComment" readonly="true"></s:textarea></div> 
								</div>
							</div>
							
							<div class="row toggled">
								<div class="inputfield five columns">
									<s:label for="emailContact" value="Email:" />
									<div><s:textfield id="emailContact" name="contact.email" readonly="true"></s:textfield></div>
								</div>
								
								<div class="inputfield four columns omega">
									<s:label for="mobileContact" value="Mobile#:" />
									<div><s:textfield id="mobileContact" name="contact.mobilephone" readonly="true" ></s:textfield></div>
								</div>
							</div>
						</fieldset>
					</section>
				</article>
				<div class="row">
					<div class="thirteen columns alpha"><p></p></div>
					<input type="button" id="btnAddDeveloper" value="Add Developer" class="three columns" />
				</div>
				
				<script>
				$(function(){
					$("#btnAddDeveloper").click(function(){ 
						$("#artDeveloper section").clone().appendTo("#itDeveloper");
					});
				});
				</script>
			</div>	
			<br>
			<div class="fieldsetborder">
				<h4 class="sixteen columns"  style="float:none;">Goals</h4>
				<article id="itGoal">
					<s:iterator value="goalSet">		
						<section class="secIssue sixteen columns curveBorder">
						<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
							<div class="row">
								<div class="three columns">
									<s:select list="goalSelectList.{goalTypeName}" name="theGoal" headerKey="-1" headerValue="Goal Type" />
								</div>
								<div class="three columns">
									<s:label for="createdDate" value="Created Date:" />
								    <s:date name="createdDate" format="dd/MM/yyyy"/>
							    </div>
							    <div class="three columns">
									<s:label for="createdBy" value="Created By:" />
								    <s:date name="createdBy" format="dd/MM/yyyy"/>
							    </div>
							   	<div class="three columns">
									<s:label for="completedDate" value="Completed Date:" />
								    <s:date name="completedDate" format="dd/MM/yyyy"/>
							    </div>
							    <div class="three columns">
							    	<s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" />
						    	</div>
							</div>
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="goalDescription" value="Goal Description" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>			
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="goalAction" value="Goal Action" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>
						</section>
					</s:iterator>
				</article>
				
				<article id="artGoal" class="row" style="visibility: hidden; display: none;">
					<section class="secIssue sixteen columns curveBorder">
						<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
						<div class="row">
							<div class="three columns">
								<s:select list="goalSelectList.{goalTypeName}" name="theGoal" headerKey="-1" headerValue="Goal Type" />
							</div>
							<div class="three columns">
								<s:label for="createdDate" value="Created Date:" />
							    <s:date name="createdDate" format="dd/MM/yyyy"/>
						    </div>
						    <div class="three columns">
								<s:label for="createdBy" value="Created By:" />
							    <s:date name="createdBy" format="dd/MM/yyyy"/>
						    </div>
						   	<div class="three columns">
								<s:label for="completedDate" value="Completed Date:" />
							    <s:date name="completedDate" format="dd/MM/yyyy"/>
						    </div>
						    <div class="three columns">
						    	<s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" />
					    	</div>
						</div>
						<div class="row">
							<div class="textarea fifteen columns omega">
								<s:label for="goalDescription" value="Goal Description" />
								<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
							</div>
						</div>			
						<div class="row">
							<div class="textarea fifteen columns omega">
								<s:label for="goalAction" value="Goal Action" />
								<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
							</div>
						</div>
					</section>
				</article>
				<div class="row">
					<div class="thirteen columns alpha"><p></p></div>
					<input type="button" id="btnAddGoal" value="Add Goal" class="three columns" />
				</div>
	
				<script>
				$(function(){
					$("#btnAddGoal").click(function(){ 
						$("#artGoal section").clone().appendTo("#itGoal");
					});
				});
				</script>
				</div>
				<br>
			<div class="fieldsetborder">
				<h4 class="sixteen columns"  style="float:none;">Risks</h4>
				<article id="itRisk">
					<s:iterator value="riskSet">		
						<section class="secIssue sixteen columns curveBorder">
						<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="riskDescription" value="Risk Description" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>			
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="riskManagement" value="Risk Management" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>
						</section>
					</s:iterator>
				</article>
				
				<article id="artRisk" class="row" style="visibility: hidden; display: none;">
					<section class="secIssue sixteen columns curveBorder">
						<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
						<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="riskDescription" value="Risk Description" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>			
							<div class="row">
								<div class="textarea fifteen columns omega">
									<s:label for="riskManagement" value="Risk Management" />
									<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
								</div>
							</div>
					</section>
				</article>
				<div class="row">
					<div class="thirteen columns alpha"><p></p></div>
					<input type="button" id="btnAddRisk" value="Add Risk" class="three columns" />
				</div>
	
				<script>
				$(function(){
					$("#btnAddRisk").click(function(){ 
						$("#artRisk section").clone().appendTo("#itRisk");
					});
				});
				</script>
			</div>
		</div>
	</div>
</section>
