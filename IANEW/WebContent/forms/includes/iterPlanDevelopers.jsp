<!-- 
	Author : KimTo
	Created Date: 18/09/2014
	-------------------------
	Modification History:
	  18/09/2014 by Kim To
	    Move Matt code to this new file to have the interface
	    Mods to display value from database onto the interface
	  
	  05/10/2014 by Kim To:
	    Mods to inteface to display drop down select list for plan developer contacts
	  
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.planDevelopersList" status="stat">	
	<section class="secIssue sixteen columns curveBorder">
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<s:hidden name="iamodel.planDevelopersList[%{#stat.index}].id"/>
		<div class="row">
			<div class="fifteen columns">
				<s:select list="developerSelectList" listKey="id" listValue="fullName" name="theDeveloperList[%{#stat.index}]" headerKey="-1" headerValue="Select a Plan Developer"/>
			</div>
		</div>
	</section>
</s:iterator>