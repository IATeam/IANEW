<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 27/07/2014
	==============================================
	Updates:
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
						Added iteration by Quang Nhan
		14/08/2014 	- 	Quang Nhan
						Connect and retrieve data called by the action class and added pagination functionality
		16/08/2014 -	Quang Nhan
						Move javascript code to ianew.lists.js and ianew.pagefiltersort.js
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
		26/08/2014 -	Quang Nhna
						Added the feature for users to retrieve new enquiry set for pagination. (added changePage())
	==============================================	
	Description: A jsp page that displays a list of enquiries. Refer to technical document about
				using Skeleton design styling for mobile and windows application.
	
	Note: syntax order: <tag id/type(for input) name class value list(for select) ...>
------------------------------------------------------------------------------------------------>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Illawarra Advocacy: Enquiry List</title>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/ianew.pagefiltersort.js' encode='false' includeParams='none'/>"></script>
<s:head/>
<sj:head/>
</head>
<body>
 
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - used to iterate a list or set ----------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
	<!-- 
	there is a strange behavior with this s:url link.
	-->
	<s:url var="urlEExisting" namespace="/enquiry" action="getEnquiry" includeContext="false"/>		
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry" />
	<s:url var="urlUpdate" namespace="/enquiry" action="updateEnquiryList" includeContext="false"/>


	<s:form id="enquiryForm" cssClass="form container" method="post" action="%{urlEExisting}">

			<section class="imageContainer">
				<s:div cssClass="row">
					<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
					<s:div cssClass="headerText nine columns">
						<s:div cssClass="row"><s:text name="formTitle" /></s:div>
						<s:div cssClass="row">
							<s:div cssClass="nine columns" style="text-align: center;">
								
								<s:label for="sortBy" value="Sort by:"/>
								<s:select list="#{'eid':'eID', 'date': 'Date', 'name':'Name'}" id="sortBy"/>
								<s:label for="filter" value="Filter:"/>
								<s:select list="#{'all':'all', 'closed': 'closed', 'opened':'opened'}" id="filter"/>
							</s:div>
						</s:div>
					</s:div>
				</s:div>
			</section>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - used to iterate a list or set ----------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
			<!-- status="..." use attribute to get status info of iteration (index, count, first, even last, odd info) -->
			<s:div cssClass="list">
				<s:iterator value="enquiryList">
					<s:div cssClass="curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
						<s:div cssClass="row">
							<s:div cssClass="textarea two columns">
								<s:label for="id" value="Enquiry#:" />
								<p class="id"><s:property value="id"/></p>
							</s:div>
							<s:div cssClass="textarea five columns">
								<s:label for="protege" value="Protege:" />
								<p><s:property value="contact.getFullName()" /></p>
							</s:div>
							<s:div cssClass="textarea two columns">
								<s:label value="Date:" />
								<p><s:property value="updatedDateTime" /></p>
							</s:div>
							<s:div cssClass="textarea six columns omega">
								<s:label for="issues" value="Issues:" />
								<p><s:property value="getIssuesTypes()" /></p>
							</s:div>
						</s:div>
						
						<s:div cssClass="row toggled">
							<s:div cssClass="textarea fifteen columns omega">
								<s:label for="description" value="Description:" />
								<s:div><s:textarea cssClass="multiLineTextArea" name="description" readonly="true"/></s:div>
							</s:div>
						</s:div>
					</s:div>
				</s:iterator>
			</s:div>
			
			<s:div cssClass="clear"/>
			
			
			<!--Hidden Fields to pass parameters between pages -->
			<s:hidden id="hiddenid" name="hiddenid" />
			<s:hidden id="formTitle" name="formTitle" value="Existing Enquiry" />
			<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
			
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
<!-- the footer of the form containing the cancel, open enquiry and new enquiry as well as the pagination functions -------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
			
			<s:div style="background:#444444; margin-top: 10px; padding: 5px;">
				<s:div cssClass="row">
					<section class="four columns">
						<input type="button" class="three columns" value="Close"  onclick="deselectAll()"/>
					</section >
					<section class="eight columns">
						<%@include file="/forms/includes/paginationToolSet.jsp" %>
						
					</section>
					<section class="four columns alpha">
						<sj:submit id="open" targets="formDiv" cssClass="two columns alpha" value="Open Enquiry" onclick="openExistingEnquiry()"/>
						<sj:a id="btnNewE" targets="formDiv"  href="%{urlENew}" ><input type="button" class="two columns omega" value="New Enquiry"/></sj:a>
					</section>
				</s:div>
			</s:div>
		</s:form>
		<h1>Number of Records: </h1><s:text name="numberOfRecords"/>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Hidden form to pass pagination to action class submitted by the prev and next buttons -------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
		<%@include file="/forms/includes/paginationForm.jsp" %>
</body>
</html>
