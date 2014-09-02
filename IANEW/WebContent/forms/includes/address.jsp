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
<section>
<h3 class="sixteen columns" style="float:none;">Address</h3>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<div class="greybackground">
<div id="addressDiv" class="toggled startShown">	
	<fieldset>
		<div class="row">
		<!-- to do -->
			<div class="four columns"><s:select list="accomodationSelectList.{accommodationName}" id="accommodationType" name="theAccommodation" headerKey="-1" headerValue="Select an Accomodation Type"/></div>
			
			<div class="textarea twelve columns">
				<s:label for="accomodationComments" value="Comments:" />
				<div><s:textarea id="accomodationComments" cssClass="oneLineTextArea" name="contact.accomodationComments"></s:textarea></div> 
			</div>
		</div>
		<div class="row">
			<div class="inputfield eight columns">
				<s:label for="address" value="Address:" />
				<div><s:textfield id="address" name="address"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns">
				<s:label for="city" value="Suburb" />
				<div><s:textfield id="city" name="surburb"></s:textfield></div>
			</div>
			
			
			<div class="inputfield four columns">
				<s:label for="state" value="State:" />
				<div><s:textfield id="state" name="state"></s:textfield></div>
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="country" value="Country:" />
				<div><s:textfield id="country" name="country"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns">
				<s:label for="postCode" value="Post Code:" />
				<div><s:textfield id="postCode" name="postcode"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns">
				<s:label for="homePhone" value="Home#:"/>
				<div><s:textfield id="homePhone" name="contact.homephone"></s:textfield></div>
			</div>
		</div>
	</fieldset>
	</div>
</div>
</section>
