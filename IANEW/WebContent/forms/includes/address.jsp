<h3 class="sixteen columns" style="float:none;">Address</h3>
<div class="fieldsetborder">
	
	<fieldset>
		<div class="row">
		<!-- to do -->
			<div class="four columns"><s:select list="accomodationSelectList.{accommodationName}" id="accommodationType" value="theAccommodation" name="theAccommodation" headerKey="-1" headerValue="Select an Accomodation Type"/></div>
			
			<div class="textarea twelve columns">
				<s:label for="accomodationComments" value="Comments:" />
				<div><s:textarea id="accomodationComments" cssClass="oneLineTextArea" name="contact.accomodationComments"></s:textarea></div> 
			</div>
		</div>
		<s:iterator value="address">
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
		</s:iterator>
	</fieldset>
	
</div>