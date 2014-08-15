<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<s:url value='/styles/login.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
</head>
<body>

<s:form action="login">
	<s:textfield label="Username" key="username"/>
	<s:password label="Password" key="password"/>
	<s:submit/>
</s:form>

</body>
</html>