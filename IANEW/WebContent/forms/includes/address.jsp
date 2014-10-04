<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		08/09/2014 -	Quang Nhan
						changed all ccontact to iamodel.contact
		29/09/2014 -	Quang Nhan modified select list to accommodate value by id rather than name
						Added img delete button and modified expand button
	==============================================	
	Description: A jsp page that displays a address of contact
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
<img src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Address</h3>
<div class="greybackground">
<div id="addressDiv" class="toggled hideable">	
	<s:url var="urlUpdateAddress" action="updateAddressList" namespace="/enquiry">
		<s:param name="address" />
	</s:url> 
	<fieldset>
		<div class="row">
		<!-- to do -->
			<div class="four columns">
				<s:select list="accommodationSelectList" listKey="id" listValue="accommodationName" name="theAccommodationTypeId" headerKey="-1" headerValue="Select an Accomodation Type"/>
			</div>
			
			<div class="textarea twelve columns">
				<s:label for="accommodationComments" value="Comments:" />
				<div><s:textarea id="accommodationComments" cssClass="oneLineTextArea" name="iamodel.contact.accommodationComment" /></div> 
			</div>
		</div>
		
		<article id="itAddress">
			<%@include file="iterAddresses.jsp" %>
		</article>
		
		<s:hidden id="createdUserId" name="" />
		<s:hidden id="updatedUserId" name=""/>
			
		<!-- if contact has existing address display the address else display input field for address -->	
		<s:if test="%{iamodel.contact.addressesList.size > 0}">
			<s:hidden id="addressSize" name="iamodel.contact.addressesList.size" value="%{iamodel.contact.addressesList.size}"/>
			<s:set name="index" value="iamodel.contact.addressesList.size" />
			<article id="artAddress" class="hidden">
		</s:if>
		<s:else>
			<s:hidden id="addressSize" name="iamodel.contact.addressesList.size" value="0"/>
			<s:set name="index" value="0" />
			<article id="artAddress">
		</s:else>
			<section class="sixteen columns curveBorder">
				<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
				<s:hidden name="iamodel.contact.addressesList[%{#index}].id" />
				
				<div class="row">
					<div class="inputfield eight columns">
						<s:label for="street" value="Street: " />
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].street" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="city" value="Suburb" />
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].suburb" /></div>
					</div>
					<div class="inputfield three columns">
						<s:label for="state" value="State:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].state" /></div>
					</div>
				</div>
				
				<div class="row">
					<div class="inputfield four columns">
						<s:label for="country" value="Country:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].country" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="postCode" value="Post Code:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].postcode" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="homePhone" value="Home#:"/>
						<div><s:textfield name="iamodel.contact.addressesList[%{#index}].homephone" /></div>
					</div>
				</div>
			</section>
		</article>
		
		<div class="row">
			<div class="fourteen columns alpha"><p></p></div>
			<input type="button" id="btnAddAddress" value="Add Address" class="two columns" onclick="addNewRecord('artAddress', 'addressSize', 'itAddress')" />
		</div>
		
	</fieldset>
	<s:hidden id="address" name="address.street" />
	
</div>
</div>
</section>