<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Quang Nhan
<<<<<<< HEAD
						Changed s:div to s:s:div and related class to cssClass
=======
<<<<<<< HEAD
						Changed s:s:div to s:s:s:div and related class to cssClass
=======
						Changed s:div to s:s:div and related class to cssClass
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
						reorder syntax to be consistent throughout the jsps
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays referral info.
------------------------------------------------------------------------------------------------>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Referral</h3>
<div class="greybackground">
<div id="referalDiv" class="toggled hideable">		
<fieldset>
		<s:div cssClass="row">
			<s:div cssClass="inputfield six columns">
				<s:label for="inquisitor" value="Inquisitor:" />
				<s:div><s:textfield id="inquisitor" name="iamodel.inquisitor"></s:textfield></s:div>
			</s:div>
			
			<s:div cssClass="inputfield five columns">
				<s:label for="referredBy" value="Referred By:" />
				<s:div><s:textfield id="referredBy" name="iamodel.referralBy"></s:textfield></s:div>
			</s:div>
			
			<s:div cssClass="inputfield five columns">
				<s:label for="referredTo" value="Referred To:" />
				<s:div><s:textfield id="referredTo" name="iamodel.referralTo"></s:textfield></s:div>
			</s:div>
		</s:div>
	</fieldset>
</div>
</div>
</section>
