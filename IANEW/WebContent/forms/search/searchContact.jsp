<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<s:form>
	<s:textfield name="firstname" placeholder="Enter first name"/>
	<s:textfield name="lastname" placeholder="Enter last name"/>
	<sj:submit targets="contactList" value="search"/>
</s:form>
	
<s:div id="contactList" />

</body>
</html>