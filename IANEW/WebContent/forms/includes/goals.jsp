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
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="fieldsetborder">
	<h4 class="sixteen columns"  style="float:none;">Goals</h4>
		
	<%@include file="iterGoals.jsp" %>
			
	<article id="artGoal" class="row" style="visibility: hidden; display: none;">
		<section class="secIssue sixteen columns curveBorder">
			<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" class="undoButton"/>
			<div class="row">
				<div class="three columns">
					<s:select list="goalSelectList.{goalTypeName}" name="theGoal" headerKey="-1" headerValue="Goal Type" />
				</div>
				<div class="three columns">
					<s:label for="createdDate" value="Created Date:" />
				    <s:date name="createdDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
					<s:label for="createdBy" value="Created By:" />
				    <s:date name="createdBy" format="dd/MM/yyyy"/>
			    </div>
			   	<div class="three columns">
					<s:label for="completedDate" value="Completed Date:" />
				    <s:date name="completedDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
			    	<s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" />
		    	</div>
			</div>
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="goalDescription" value="Goal Description" />
					<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
			</div>			
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="goalAction" value="Goal Action" />
					<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
			</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddGoal" value="Add Goal" class="three columns" />
	</div>

	<script>
	$(function(){
		$("#btnAddGoal").click(function(){ 
			$("#artGoal section").clone().appendTo("#itGoal");
		});
	});
	</script>
	</div>