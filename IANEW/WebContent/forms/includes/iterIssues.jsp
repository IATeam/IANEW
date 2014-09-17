<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.enquiryIssuesList" status="stat">
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.enquiryIssuesList[%{#stat.index}].id"/>
		
		<div class="four columns">
			<s:select list="issueSelectList.{issueName}" name="theIssueList[%{#stat.index}]" headerKey="-1" headerValue="Select an Issue" />
		</div>
		
		<div class="textarea eleven columns omega">
			<s:label for="issuedescription" value="Issue Description:" />
			<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.enquiryIssuesList[%{#stat.index}].comment"/> 
		</div>
		<input type="button" value="delete" onclick="deleteSection(this)"/>
	</section>
</s:iterator>