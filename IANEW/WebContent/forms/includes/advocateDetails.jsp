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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns"  style="float:none;">Advocate</h3>
<div class="greybackground">
<div id="advocateDetailsDiv" class="toggled hideable">	
	<fieldset>
		<div class="row">
			<div class="sixteen columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" id="advocateList" headerKey="-1" headerValue="Select Advocate" onChange="changeContact(this)" /></div>
			<section class="five columns"><p></p></section>
		</div>				
	</fieldset>
</div>
</div>
</section>