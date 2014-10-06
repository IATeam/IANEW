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
		06/08/2014 -	Quang Nhan - updated referral to client's changes
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays referral info.
------------------------------------------------------------------------------------------------>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">Referral</h3>
	<div class="greybackground">
		<div id="referalDiv" class="toggled hideable">		
			<fieldset>
				<sj:tabbedpanel id="referralTabs">
					<sj:tab target="inquisitorTab" label="Enquirer"/>
					<sj:tab target="referredByTab" label="Referred By"/>	
					<sj:tab target="referredToTab" label="Referred To"/>	
					
					<s:div id="inquisitorTab">
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label for="inquisitor" value="Enquirer" />
								<s:div><s:textfield id="inquisitor" name="iamodel.inquisitor" /></s:div>
							</s:div>
						</s:div>
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label value="Relationship:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns">
								<s:label value="Phone:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns omega">
								<s:label value="Email:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							
						</s:div>
					</s:div>
					
					<s:div id="referredByTab">
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label for="referredBy" value="Referred By:" />
								<s:div><s:textfield id="referredBy" name="iamodel.referralBy" /></s:div>
							</s:div>
						</s:div>
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label value="Organisation:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns">
								<s:label value="Phone:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns omega">
								<s:label value="Email:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							
						</s:div>
					</s:div>
					
					<s:div id="referredToTab">
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label for="referredTo" value="Referred To:" />
								<s:div><s:textfield id="referredTo" name="iamodel.referralTo" /></s:div>
							</s:div>
						</s:div>
						<s:div  cssClass="row">
							<s:div cssClass="inputfield six columns alpha">
								<s:label value="Organisation:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns">
								<s:label value="Phone:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							<s:div cssClass="inputfield four columns omega">
								<s:label value="Email:" />
								<s:div><s:textfield /></s:div>
							</s:div>
							
						</s:div>
					</s:div>
				</sj:tabbedpanel>
			</fieldset>
		</div>
	</div>
</section>
<script>
$(function(){
	$("#referralTabs").tabs();
});
</script>
