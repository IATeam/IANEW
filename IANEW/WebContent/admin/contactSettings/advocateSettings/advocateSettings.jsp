<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Advocate Settings</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/adminTables.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/validation/settingsValidation.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.form.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/popUpBoxAction.js' encode='false' includeParams='none'/>" ></script>
</head>
<body>
	<s:div cssClass="form container">
	<s:set var="formType">advocate</s:set>
	<s:form id="advocateForm" action="saveOrUpdateContact" cssClass="cmxform" namespace='/admin' method="post">
		<%@include file="/forms/includes/formHeader.jsp" %>
		<%@include file="/admin/contactSettings/advocateSettings/advocateList.jsp" %>
	</s:form>
	<s:form id="saveAdvocateForm" action="saveOrUpdateContact" cssClass="cmxform" namespace='/admin' method="post">
		<s:hidden name="contactType"></s:hidden>
		<div id="ContactInfo">
			<%@include file="/admin/contactSettings/shared/ajaxContact.jsp" %>
		</div>
		<sj:submit id="saveNewAdvocateType" targets="formDiv" cssClass="two columns alpha" value="Save" />
	</s:form>
	</s:div>
</body>
</html>