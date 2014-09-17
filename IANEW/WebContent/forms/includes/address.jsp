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
	==============================================	
	Description: A jsp page that displays a address of contact
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h3 class="sixteen columns" style="float:none;">Address</h3>
<div class="fieldsetborder">
	<s:url var="urlUpdateAddress" action="updateAddressList" namespace="/enquiry">
		<s:param name="address" />
	</s:url> 
	<fieldset>
		<div class="row"> <s:text name="#session.user.username"></s:text>
		<!-- to do -->
			<div class="four columns">
				<s:select list="accomodationSelectList.{accommodationName}" name="theAccommodation" headerKey="-1" headerValue="Select an Accomodation Type"/>
			</div>
			
			<div class="textarea twelve columns">
				<s:label for="accomodationComments" value="Comments:" />
				<div><s:textarea id="accomodationComments" cssClass="oneLineTextArea" name="iamodel.contact.accommodationComment" /></div> 
			</div>
		</div>
		
		<aticle id="itAddress">
			<%@include file="iterAddresses.jsp" %>
		</aticle>
		
		<s:textfield id="addressSize" name="iamodel.contact.addressesList.size" value="%{iamodel.contact.addressesList.size}"/>
		<s:hidden id="createdUserId" name="" />
		<s:hidden id="updatedUserId" name=""/>
			
		<!-- if contact has existing address display the address else display input field for address -->	
		<s:if test="%{iamodel.contact.addressesList.size > 0}"><article id="artAddress" class="hidden"></s:if>
		<s:else><article id="artAddress"></s:else>
			<section class="sixteen columns curveBorder">
				<s:hidden name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].id" />
				
				<div class="row">
					<div class="inputfield eight columns">
						<s:label for="street" value="Street: " />
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].street" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="city" value="Suburb" />
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].suburb" /></div>
					</div>
					<div class="inputfield three columns">
						<s:label for="state" value="State:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].state" /></div>
					</div>
				</div>
				
				<div class="row">
					<div class="inputfield four columns">
						<s:label for="country" value="Country:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].country" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="postCode" value="Post Code:" />
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].postcode" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="homePhone" value="Home#:"/>
						<div><s:textfield name="iamodel.contact.addressesList[%{iamodel.contact.addressesList.size}].homephone" /></div>
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