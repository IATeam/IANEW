<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Quang Nhan
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays referral info.
------------------------------------------------------------------------------------------------>

<h3 class="sixteen columns" style="float:none;">Referral</h3>
<div class="fieldsetborder">
	<fieldset>
		<div class="row">
			<div class="inputfield six columns">
				<s:label for="inquisitor" value="Inquisitor:" />
				<div><s:textfield id="inquisitor" name="inquisitor"></s:textfield></div>
			</div>
			
			<div class="inputfield five columns">
				<s:label for="referredBy" value="Referred By:" />
				<div><s:textfield id="referredBy" name="referredBy"></s:textfield></div>
			</div>
			
			<div class="inputfield five columns">
				<s:label for="referredTo" value="Referred To:" />
				<div><s:textfield id="referredTo" name="referredTo"></s:textfield></div>
			</div>
		</div>
	</fieldset>
</div>