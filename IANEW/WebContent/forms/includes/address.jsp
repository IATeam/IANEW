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
<%@ taglib prefix="s" uri="/struts-tags" %>
<h3 class="sixteen columns" style="float:none;">Address</h3>
<div class="fieldsetborder">
	<s:url var="urlUpdateAddress" action="updateAddressList" namespace="/enquiry">
		<s:param name="address" />
	</s:url>
	<fieldset>
		<div class="row">
		<!-- to do -->
			<div class="four columns">
				<s:select list="accomodationSelectList.{accommodationName}" name="ccontact.accommodation.accommodationName" headerKey="-1" headerValue="Select an Accomodation Type"/>
			</div>
			
			<div class="textarea twelve columns">
				<s:label for="accomodationComments" value="Comments:" />
				<div><s:textarea id="accomodationComments" cssClass="oneLineTextArea" name="ccontact.accommodationComment" /></div> 
			</div>
		</div>
		<aticle id="itAddress">
			<s:iterator value="ccontact.addressesList" status="stat">
				<h1><s:property value="{#stat.index}" /></h1>
				<section class="sixteen columns curveBorder">
					<s:hidden name="ccontact.addressesList[%{#stat.index}].id"/>
					<s:hidden name="ccontact.addressesList[%{#stat.index}].createdUserId"/>
					<s:hidden name="ccontact.addressesList[%{#stat.index}].createdDateTime"/>
					<s:hidden name="ccontact.addressesList[%{#stat.index}].updatedUserId"/>
					<s:hidden name="ccontact.addressesList[%{#stat.index}].updatedDateTime"/>
					
					<div class="row">
						<div class="inputfield eight columns">
							<s:label for="address" value="Street" />
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].street"></s:textfield></div>
						</div>
						<div class="inputfield four columns">
							<s:label for="city" value="Suburb" />
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].suburb" /></div>
						</div>
						<div class="inputfield three columns">
							<s:label for="state" value="State:" />
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].state" /></div>
						</div>
					</div>
					
					<div class="row">
						<div class="inputfield four columns">
							<s:label for="country" value="Country:" />
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].country"></s:textfield></div>
						</div>
						<div class="inputfield four columns">
							<s:label for="postCode" value="Post Code:" />
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].postcode"></s:textfield></div>
						</div>
						<div class="inputfield four columns">
							<s:label for="homePhone" value="Home#:"/>
							<div><s:textfield name="ccontact.addressesList[%{#stat.index}].homephone"></s:textfield></div>
						</div>
					</div> 
				</section>
			</s:iterator>
		</aticle>
		
		<s:textfield id="addressSize" name="ccontact.addressesList.size" value="%{ccontact.addressesList.size}"/>
		<s:hidden id="createdUserId" name="" />
		<s:hidden id="updatedUserId" name=""/>
		<s:hidden id="createdDateTime" name =""/>
		<s:hidden id="createdUpdateTime" name=""/>
			
		<!-- if contact has existing address display the address else display input field for address -->	
		<s:if test="%{ccontact.addressesList.size > 0}"><article id="artAddress" class="hidden"></s:if>
		<s:else><article id="artAddress"></s:else>
			<section class="sixteen columns curveBorder">
				<s:hidden name="ccontact.addressesList[%{ccontact.addressesList.size}].id"/>
				<div class="row">
					<div class="inputfield eight columns">
						<s:label for="street" value="Street: " />
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesccontact.disabilitiesList.sizeList.size}].street" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="city" value="Suburb" />
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesList.size}].surburb" /></div>
					</div>
					<div class="inputfield three columns">
						<s:label for="state" value="State:" />
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesList.size}].state" /></div>
					</div>
				</div>
				
				<div class="row">
					<div class="inputfield four columns">
						<s:label for="country" value="Country:" />
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesList.size}].country" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="postCode" value="Post Code:" />
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesList.size}].postcode" /></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="homePhone" value="Home#:"/>
						<div><s:textfield name="ccontact.addressesList[%{ccontact.addressesList.size}].homephone" /></div>
					</div>
				</div>
			</section>
		</article>
		
		<div class="row">
			<div class="fourteen columns alpha"><p></p></div>
			<input type="button" id="btnAddAddress" value="Add Address" class="two columns" onclick="return addAddress()" />
		</div>
	</fieldset>
	<s:hidden id="address" name="address.street" />
	<script>
	
		function addAddress(){ 
			
			//if artAddress is not hidden then add to iterator
			if(!$("#artAddress").hasClass("hidden")){
				//clone address and put in iterator
				$("#artAddress section").clone().appendTo("#itAddress");
				
				updateIndex($("#artAddress"),$("#addressSize"));
				//set all hidden fields
				
			}
			else{
				$("#artAddress").removeClass("hidden");
			}
			
		}

		function updateIndex(articleEle, sizeEle ){
			var ele = articleEle.find("[name]");
			var sizeInt = parseInt(sizeEle.val());
			var newIndex;
			var prependStr = "ccontact.addressesList[" +  newIndex   +  "].";

			sizeEle.val(sizeInt + 1);

			newIndex = "[" + sizeEle.val() + "]";
			
			//replaces the old index with the new one and clear the content
			$(ele).each(function(){
				var oldIndex = $(this).attr('name').match(/\[.\]/);
				var newName = $(this).attr('name').replace(oldIndex, newIndex);
				$(this).attr('name', newName);
				$(this).val(null);
			});
		}
	</script>
	
</div>
