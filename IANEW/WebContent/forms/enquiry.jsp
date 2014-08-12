<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Enquiry Form</title>
<link href="<s:url value='/styles/form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/validation/enquiryValidation.js' encode='false' includeParams='none'/>"></script>


<s:head/>

</head>
<body>
	<s:form method="post" cssClass="cmxform form container" namespace='/enquiry' id="enquiryForm" novalidate="novalidate">  
		<section class="imageContainer">
			<div class="row">
				<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
				<div class="headerText nine columns">
					<s:text name="formTitle" />
				</div>
			</div>
		</section>
		
		<%@include file="includes/formStatus.jsp" %>
		<%@include file="includes/summary.jsp" %>
		<%@include file="includes/personalDetails.jsp" %>
		<%@include file="includes/address.jsp" %>
		<%@include file="includes/referral.jsp" %>
		<%@include file="includes/employment.jsp" %>
		<%@include file="includes/disability.jsp" %>
		<%@include file="includes/issues.jsp" %>
		<%@include file="includes/linkedEnquiries.jsp" %>
		
		
		<div class="clear"></div>
		<footer>
			<div class="row">
				<section class="six columns">
					<input type="button" value="Cancel" class="three columns alpha" />
					<input type="button" value="New Enquiry" class="three columns omega"/>
				</section>
				<section class="six columns"><p></p></section>
				<section class="four columns omega">
					<input type="button" value="Create Case" class="two columns alpha"/>
					<s:submit type="submit" cssClass="two columns omega" value="Save" />
				</section>
			</div>
		</footer>
	</s:form>	
	<script>
	
	</script>
</body>
</html>