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
				<div class="five columns">
					<s:select list="goalSelectList" listValue="goalTypeName" listKey="id" name="theGoalList[%{iamodel.planGoalsList.size}]" headerKey="-1" headerValue="Select Goal Type" />
				</div>
			   	<div class="six columns">
					<s:label for="completedDate" value="Goal Completed Date:" />
				    <s:date name="completedDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="four columns">
			    	<s:select list="goalStatusSelectList" listValue="statusName" listKey="id" name="theGoalStatusList[%{iamodel.planGoalsList.size}]" headerKey="-1" headerValue="Select Goal Status" />
		    	</div>
			</div>
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="goalDescription" value="Goal Description" />
					<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.planGoalsList[%{iamodel.planGoals.size}].goalDescription"/> 
				</div>
			</div>			
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="goalAction" value="Goal Action" />
					<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.planGoalsList[%{iamodel.planGoals.size}].goalAction"/> 
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
