<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Enquiry Form</title>
<link
	href="<s:url value='/styles/form.css' encode='false' includeParams='none'/>"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="<s:url value='/styles/skeleton.css' encode='false' includeParams='none'/>"
	rel="stylesheet" type="text/css" media="all" />
<s:head />

</head>
<body>
	<div class="form container">


		<section class="imageContainer">
		<div class="row">
			<img class="seven columns"
				src="<s:url value='/resources/images/logo.png'/>" />
			<div class="headerText nine columns">
				<s:text name="formTitle" />
			</div>
		</div>
		</section>


		<%@include file="includes/formStatus.jsp"%>
		<%@include file="includes/personalDetails.jsp"%>
		<%@include file="includes/address.jsp"%>
		<%@include file="includes/referral.jsp"%>
		<%@include file="includes/employment.jsp"%>
		<%@include file="includes/disability.jsp"%>
		<%@include file="includes/issues.jsp"%>
		<%@include file="includes/linkedEnquiries.jsp"%>


		<footer> <section> <input type="button"
			value="Cancel" /> <input type="button" value="New Enquiry" /> </section> <section>
		<input type="button" value="Create Case" /> <s:submit type="submit"
			cssClass="button" value="Save" /> </section> </footer>
	</div>
	</div>
</body>
</html>