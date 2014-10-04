<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<title>Client Details</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/validation/enquiryValidation.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.form.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/popUpBoxAction.js' encode='false' includeParams='none'/>" ></script>
<s:head/>
</head>
<body>
	<%@include file="includes/personalDetails.jsp" %>
	<%@include file="includes/address.jsp" %>
	<%@include file="includes/employment.jsp" %>
	<%@include file="includes/disability.jsp" %>
</body>
</html>