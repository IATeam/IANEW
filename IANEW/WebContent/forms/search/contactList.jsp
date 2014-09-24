<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="contactList">
		<s:property value="titleType.name" />
		<s:property value="firstname"/>
		<s:property value="othername"/>
		<s:property value="lastname"/>
		<s:property value="mobile"/>
		<s:property value="email"/>
		<s:property value="dob"/>
	</s:iterator>
</body>
</html>