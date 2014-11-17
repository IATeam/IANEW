<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Settings</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/adminTables.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/ianew.form.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.admin.js' encode='false' includeParams='none'/>" ></script>     
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>" ></script>   
<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>" ></script>   

</head>
<body>
	<s:div cssClass="form container">
	<s:set var="formType">enquiry</s:set>
	<%-- <s:form id="caseForm" cssClass="cmxform form container" namespace='/case' method="post" action="saveUpdateCase" novalidate="novalidate"> --%>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Header of the form --------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="/forms/includes/formHeader.jsp" %>
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Content of the form -------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="/admin/typeSettings/includes/newAccommodationType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newCommunicationType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newCulturalBackgroundType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newDangerType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newDisabilityType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newEmploymentType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newEnquiryType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newGenderType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newGoalType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newIssueType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newPriorityType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newStatusType.jsp" %>
		<%@include file="/admin/typeSettings/includes/newTitleType.jsp" %>
	<%-- </s:form> --%>
	</s:div>
</body>
</html>