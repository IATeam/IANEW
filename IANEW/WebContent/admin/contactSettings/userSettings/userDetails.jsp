<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 - 	Quang Nhan
						Connect and retrieve data called by the action class and added pagination functionality
		16/08/2014 -	Quang Nhan
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the personal detail.
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
<h3 class="sixteen columns"  style="float:none;">Advocate</h3>
<div class="greybackground">
<div id="advocateDetailsDiv" class="toggled hideable">	
	<fieldset>
		<div class="row">
			<div class="sixteen columns"><s:select list="advocateSelectList" listKey="id" listValue="fullName" headerKey="-1" headerValue="Select Advocate" /></div>
			<section class="five columns"><p></p></section>
		</div>				
	</fieldset>
</div>
</div>
</section>