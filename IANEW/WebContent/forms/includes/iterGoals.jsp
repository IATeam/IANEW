<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<article id="itGoal">
<s:iterator value="iamodel.planGoalsList" status="stat">		
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.planGoalsList[%{#stat.index}].id"/>
		<div class="row">
			<div class="five columns">
				<s:select list="goalSelectList" listValue="goalTypeName" listKey="id" name="theGoalList[%{#stat.index}]" headerKey="-1" headerValue="Select Goal Type" />
			</div>
		   	<div class="six columns">
				<s:label for="completedDate" value="Goal Completed Date:" />
			    <s:date name="iamodel.planGoalsList[%{#stat.index}].completionDateTime" format="dd/MM/yyyy" />
		    </div>
		    <div class="four columns">
		    	<s:select list="goalStatusSelectList" listValue="statusName" listKey="id" name="theGoalStatusList[%{#stat.index}]" headerKey="-1" headerValue="Select Goal Status" />
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