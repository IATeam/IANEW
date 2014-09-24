<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<html>
<head>
<title>Illawarra Advocacy: Enquiry List</title>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/ianew.pagefiltersort.js' encode='false' includeParams='none'/>"></script>
<s:head/>
<sj:head/>
</head>
<body>
	
	
	
	
	<s:url var="urlLink" namespace="/enquiry" action="updateLinkedEnquiries" includeContext="false"/>
	
	
	<!-- Change namespace and action for appropriate urls for pagination purposes-->
	<s:url var="urlUpdate" namespace="/enquiryList" action="updateLinkedEnquiriesList" includeContext="false"/>
	
	<s:form	id="listForm" cssClass="form container" method="post" action="%{urlLink}">
	
		<!--Hidden Fields to pass parameters between pages -->
		<s:hidden id="hiddenid" name="hiddenid" />
		
		<s:hidden id="formTitle" name="formTitle" value="Existing Enquiry" />
		<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - used to iterate a list or set ----------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<!-- status="..." use attribute to get status info of iteration (index, count, first, even last, odd info) -->
		
		
		
		<%@include file="/forms/includes/lists.jsp" %>
			
			
		<s:div cssClass="clear"/>
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
<!-- the footer of the form containing the cancel, open enquiry and new enquiry as well as the pagination functions -------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
			
		<s:div style="background:#444444; margin-top: 10px; padding: 5px; height: 30px;">
			<s:div cssClass="row">
				<section class="four columns">
					<input type="button" id="btnCancelLink" class="two columns omega" value="Cancel"/>
				</section >
				<section class="eight columns">
					<%@include file="/forms/includes/paginationToolSet.jsp" %>
				</section>
				<section class="four columns alpha">
					<input type="button" id="btnLink" class="two columns alpha" value="Link"/>
				</section>
			</s:div>
		</s:div>
	</s:form>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Hidden form to pass pagination to action class submitted by the prev and next buttons -------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
		<%@include file="/forms/includes/paginationForm.jsp" %>
		
		
	
	<script>
	
	
		$("#btnCancelLink").click(function(){ alert("Cancel Pressed")
			hidePopUp($("#rightPopUp"));
			//alert($("#hiddenid").val())
		});

		$("#btnLink").click(function(){ alert("Cancel Pressed")
			
			$("#linkedEnquiriesDiv").load("enquiry/updateLinkedEnquiries.action?hiddenid=" + $("#hiddenid").val() + "&");
			$("#linkedEnquiriesListDiv").hide();	
		});
	</script>
		
		
</body>
</html>
		
		