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
		28/08/2014 - 	Quang Nhan
						Moved iterator to its own jsps so case list can use it
		13/09/2014 - 	David Forbes
						Added OnClick method to buttons open Enquiry and new enquiry
	==============================================	
	Description: A jsp page that displays a list of enquiries. Refer to technical document about
				using Skeleton design styling for mobile and windows application.
	
	Note: syntax order: <tag id/type(for input) name class value list(for select) ...>
------------------------------------------------------------------------------------------------>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<title>Illawarra Advocacy: Enquiry List</title>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/ianew.pagefiltersort.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/popUpBoxAction.js' encode='false' includeParams='none'/>" ></script>
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
	<s:url var="urlExisting" namespace="/enquiry" action="getEnquiry" includeContext="false"/>		
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry" />

	<!-- Change namespace and action for appropriate urls for pagination purposes-->
	<s:url var="urlUpdate" namespace="/enquiryList" action="updateEnquiryList" includeContext="false"/>

	
		
	<s:form id="listForm" cssClass="form container" method="post" action="%{urlExisting}"  >
			
			<!--Hidden Fields to pass parameters between pages -->
			<s:hidden id="hiddenid" name="hiddenid" />
			<s:hidden id="formTitle" name="formTitle" value="Existing Enquiry" />
			<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
			
			
			<%@include file="includes/formHeader.jsp" %>
			<%@include file="includes/filterSort.jsp" %>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - used to iterate a list or set ----------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
			<!-- status="..." use attribute to get status info of iteration (index, count, first, even last, odd info) -->
			
			<div id="iterEnquiryList">
				<%@include file="/forms/includes/iterEnquiryList.jsp" %>
			</div>
			
		</s:form>
		
		
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Hidden form to pass pagination to action class submitted by the prev and next buttons -------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
		<%@include file="/forms/includes/paginationForm.jsp" %>
		
		
		<script type="text/javascript">
			$.subscribe('beforeSubmit', function(event,data) {
		    	event.originalEvent.options.submit = checkHiddenID();          
			});
		</script>
		<script>
		</script>
</body>
</html>
