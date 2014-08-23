<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>New Disability Type</h3>
	<s:form >
		<div>
			<s:label for="disabilityName" value="Name: "/>
			<s:textfield id="disabilityName" name="disabilityName" />
			<s:label for="disabiltyDescription" value="Description" />
			<s:textarea id="disabilityDescription" name ="disabilityDescription" />
		</div>
		<input type="button" value="Cancel" id="btnCancel"/>
		<s:submit />
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		hideSlidingPanel();
	});
	</script>
</body>
</html>