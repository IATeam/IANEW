<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Settings</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/adminTables.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
</head>
<body>
	<s:div cssClass="form container">


<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Header of the form --------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="/forms/includes/formHeader.jsp" %>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Content of the form -------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="/admin/userList.jsp" %>
		

		</s:div>
</body>
</html>