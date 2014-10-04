<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/09/2014
	==============================================
	Updates:
		29/08/2014 -	Quang Nhan added img delete button
	==============================================	
	Description: A jsp page that displays iterator for address
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.contact.addressesList" status="stat">
	<section class="sixteen columns curveBorder">
		<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
		<s:hidden name="iamodel.contact.addressesList[%{#stat.index}].id"/>			
		<div class="row">
			<div class="inputfield eight columns">
				<s:label for="address" value="Street" />
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].street" /></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="city" value="Suburb" />
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].suburb" /></div>
			</div>
			<div class="inputfield three columns">
				<s:label for="state" value="State:" />
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].state" /></div>
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="country" value="Country:" />
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].country"></s:textfield></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="postCode" value="Post Code:" />
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].postcode"></s:textfield></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="homePhone" value="Home#:"/>
				<div><s:textfield name="iamodel.contact.addressesList[%{#stat.index}].homephone"></s:textfield></div>
			</div>
		</div>
	</section>
</s:iterator>
<!-- Note the delete button will call the deleteSection function in ianew.form.js -->
	