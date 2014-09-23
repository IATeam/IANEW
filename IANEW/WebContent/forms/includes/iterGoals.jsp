<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<article id="itGoal">
<s:iterator value="iamodel.planGoalsList" status="stat">		
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.planGoalsList[%{#stat.index}].id"/>
		<%-- <s:hidden name="iamodel.planGoalsList[%{#stat.index}].statusType.id" /> --%>
		<div class="row">
			<div class="three columns">
				<s:select list="goalSelectList.{goalTypeName}" name="theGoalList[%{#stat.index}]" headerKey="-1" headerValue="Goal Type" />
			</div>
			<div class="three columns">
				<s:label for="createdDate" value="Created Date:" />
			    <s:date name="iamodel.planGoalsList[%{#stat.index}].createdDateTime" format="dd/MM/yyyy"/>
		    </div>
		    <div class="three columns">
				<s:label for="createdBy" value="Created By:" />
			    <s:date name="iamodel.planGoalsList[%{#stat.index}].createdUserId"/>
		    </div>
		   	<div class="three columns">
				<s:label for="completedDate" value="Completed Date:" />
			    <s:date name="iamodel.planGoalsList[%{#stat.index}].completionDateTime" format="dd/MM/yyyy"/>
		    </div>
		    <div class="three columns">
		    	<s:select list="statusSelectList.{statusName}" name="iamodel.planGoalsList[%{#stat.index}].statusType.statusName" headerKey="-1" headerValue="Status" />
	    	</div>
		</div>
		<div class="row">
			<div class="textarea fifteen columns omega">
				<s:label for="goalDescription" value="Goal Description" />
				<s:textarea cssClass="oneLineTextArea" name="iamodel.planGoalsList[%{#stat.index}].goalDescription"/> 
			</div>
		</div>			
		<div class="row">
			<div class="textarea fifteen columns omega">
				<s:label for="goalAction" value="Goal Action" />
				<s:textarea cssClass="oneLineTextArea" name="iamodel.planGoalsList[%{#stat.index}].goalAction"/> 
			</div>
		</div>
	</section>
</s:iterator>
</article>