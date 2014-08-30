<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		28/08/2014 -	Address of 
	==============================================	
	Description: A jsp page that displays a address of contact
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h3 class="sixteen columns" style="float:none;">Address</h3>
<div id="addressField" class="fieldsetborder">
	<!-- url for the add button press - ajax call -->
	<s:url id="urlUpdateAddress" action="updateAddressSet" namespace="/enquiry" >
		<s:param name="address.state" value="%{address.state}"/>
	</s:url>
	<fieldset>
		<div class="row">
		<!-- to do -->
			<div class="four columns">
				<s:select list="accomodationSelectList.{accommodationName}" id="accommodationType" name="model.contact.accommodation.accommodationName" headerKey="-1" headerValue="Select an Accomodation Type"/>
			</div>
			
			<div class="textarea twelve columns">
				<s:label for="accomodationComments" value="Comments:" />
				<div><s:textarea id="accomodationComments" cssClass="oneLineTextArea" name="model.contact.accommodationComment" /></div> 
			</div>
		</div>
		<s:set var="contactaddress" value="ccontact.addressesSet" />
		<!-- <s:iterator value="%{contactaddress}" status="stat"> -->
			<h1><s:property value="#stat.index" /></h1>
			<section class="sixteen columns curveBorder">
				<div class="row">
					<div class="inputfield eight columns">
						<s:label for="address" value="Address:" />
						<div><s:textfield name="%{contactaddress.state}"></s:textfield></div>
					</div>
					<!-- <div class="inputfield four columns">
						<s:label for="city" value="Suburb" />
						<div><s:textfield id="city" name="suburb"></s:textfield></div>
					</div>
					<div class="inputfield three columns">
						<s:label for="state" value="State:" />
						<div><s:textfield name="state"></s:textfield></div>
					</div> -->
				</div>
				
				<!-- <div class="row">
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
						<div><s:textfield id="homePhone" name="homephone"></s:textfield></div>
					</div> -->
				</div> 
			</section>
		<!-- </s:iterator> -->
		
		<s:textfield id="homePhone" name="addressSet.size" />
			
		<!-- if contact has existing address display the address else display input field for address -->	
		<s:if test="%{addressSet.size > 0}"><article id="artAddress" class="hidden"></s:if>
		<s:else><article id="artAddress"></s:else>
			<section class="sixteen columns curveBorder">
				<div class="row">
					<div class="inputfield eight columns">
						<s:label for="street" value="Street: " />
						<div><s:textfield id="street"></s:textfield></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="city" value="Suburb" />
						<div><s:textfield id="suburb" name="address.surburb"></s:textfield></div>
					</div>
					<div class="inputfield three columns">
						<s:label for="state" value="State:" />
						<div><s:textfield id="state" name="address.state"></s:textfield></div>
					</div>
				</div>
				
				<div class="row">
					<div class="inputfield four columns">
						<s:label for="country" value="Country:" />
						<div><s:textfield id="country" name="address.country"></s:textfield></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="postCode" value="Post Code:" />
						<div><s:textfield id="postCode" name="address.postcode"></s:textfield></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="homePhone" value="Home#:"/>
						<div><s:textfield id="homephone" name="address.homephone"></s:textfield></div>
					</div>
				</div>
			</section>
		</article>
		
		
		<div class="row">
			<div class="fourteen columns alpha"><p></p></div>
			<input type="button" id="btnAddAddress" value="Add Address" class="two columns" onclick="addAddress()"/>
		</div>
	</fieldset>
	
	<script>
	
		function addAddress(){
			//if artAddress is not hidden then add to iterator
			if(!$("#artAddress").hasClass("hidden")){
				//$("#artDisability section").clone().appendTo("#itDisability");
				//submit
				//var address = $('#address');
				//alert(address);
				
				var suburb = $("#suburb").val();
				var street= $("#street").val();
				var state = $("#state").val();
				var country = $("#country").val();
				var postCode = $("#postCode").val();
				var homephone = $("#homePhone").val();
				$("#addressField").load("/IANEW/enquiry/updateAddressSet.action?address.address=" + street
						+ "&address.surburb=" + suburb
						+ "&address.state=" + state
						+ "&address.country=" + country
						+ "&address.postcode=" + postCode
						+ "&address.homephone=" + homephone );
			}
			else{
				$("#artAddress").removeClass("hidden");
			}
		}
	</script>
	
</div>
