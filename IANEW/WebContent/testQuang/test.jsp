<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Test file</title>
</head>
<body>
	<s:form action="save" namespace="/test" method="post">
		<s:select list="employmentSelectList" listKey="id" listValue="employmentName" name="employmentid" headerKey="-1" headerValue="Select Disability" />
		<s:submit/>
	</s:form>
	
</body>
</html>