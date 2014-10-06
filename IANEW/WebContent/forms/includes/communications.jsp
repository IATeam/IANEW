<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
<<<<<<< HEAD
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
=======
<<<<<<< HEAD
		21/08/2014 -	Quang Nhan
						Added "Add Issue" button and functionality
						
=======
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/><h3 class="fifteen columns" style="float:none;">Communications</h3>
<div class="greybackground">
<div id="communicationsDiv" class="toggled hideable">	
	<%-- <s:if test="" > --%>
	<article id="itCommunication">
		<%@include file="iterCommunications.jsp" %>
	</article>
	
	<article id="artCommunication" class="row" style="visibility: hidden; display: none;">
	
		<section class="secIssue sixteen columns curveBorder">
			<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
			
			<div class="row">
			<div class="five columns">
				<s:select list="communicationSelectList.{communicationTypeName}" name="theCommunicationsList" headerKey="-1" headerValue="Select Communication Type" />
			</div>
			<div class="three columns">
		    <div class="inputfield six columns omega">
				<s:label for="communicationDate" value="Communication Date:" />
				<div><input type="date" id="communicationDate" name="" format="dd/MM/yyyy"></div>
			</div>
			<div  class="inputfield four columns omega">
				<s:label for="timespent" value="Time Spent:" />
				<div><input type="text" name=""></div>
			</div>
			</div>
			<div class="row">
				<div class="textarea fourteen columns omega">
				<s:label for="comments" value="Comments:" />
				<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
				<input type="button" id="btnImportant" value="" class="one columns" onclick="importantDiv(this)"/>
			</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddCommunication" value="Add Communication" class="three columns" />
	</div>
	
	<script>
	$(function(){
		$("#btnAddCommunication").click(function(){ 
			$("#artCommunication section").clone().appendTo("#itCommunication");
		});

		var it = $("#itCommunication").find("section");
		$(it).each(function(index, section){
			var isImportant = $(section).find(":hidden[name*='importantFlag']").val();
			var button = $(section).find("input[name='importantFlag']");
			if(isImportant == 'Y') {
				button.css({'background':'orange'});
				button.parent("div").parent("section").css({'background-color':'#fddabe'});	
			}
		});
	});
	</script>
	</div>
</div>
</section>
