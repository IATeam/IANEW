<!-- 
	Author : KimTo
	Created Date: 18/09/2014
	-------------------------
	Modification History:
	  18/09/2014 by Kim To
	    Move Matt code to this new file to have the interface
	    Mods to display value from database onto the interface
	  
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.planDevelopersList" status="stat">		
		<section class="secIssue sixteen columns curveBorder">
			<s:hidden name="iamodel.planDevelopersList[%{#stat.index}].id"/>
			<div class="row">
				<div class="three columns">
					<s:select list="developerSelectList.{fullName}" name="theDeveloper" headerKey="-1" headerValue="Developer Type" />
				</div>
				<div class="three columns">
					<s:label for="createdDate" value="Created Date:" />
				    <s:date name="createdDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
					<s:label for="createdBy" value="Created By:" />
				    <s:date name="createdBy" format="dd/MM/yyyy"/>
			    </div>
			   	<div class="four columns">
					<s:label for="completedDate" value="Completed Date:" />
				    <s:date name="completedDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
			    	<s:select list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Status" />
		    	</div>
			</div>
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="developerDescription" value="Developer Description" />
					<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
			</div>			
			<div class="row">
				<div class="textarea fifteen columns omega">
					<s:label for="developerAction" value="Developer Action" />
					<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
			</div>
		</section>
	</s:iterator>