<!----------------------------------------------------------------------------------------------
	Created By: David Forbes
	Created Date: 02/08/2014
	==============================================
	Updates:
		14/08/2014 -	David Forbes
						Reworked so the entry page is redirected to this page and successfully direct
						users to home page when logged in.
		15/08/2014 - 	Quang Nhan
						Edit to add styling by and replace the submit button with javascript function
						
		16/08/2014 -	Quang Nhan 
						Standardised the names of css and js files
	==============================================	
	Description: This is the page that the user will see when first loading the app.
------------------------------------------------------------------------------------------------>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Illawarra Advocacy Login</title>
<script src="<s:url value='/js/jquery/jquery-1.11.1.min.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/jquery/jquery-ui.min.js' encode='false' includeParams='none'/>"></script>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
<link href="<s:url value='/styles/ianew.login.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
<script src="<s:url value='/js/ianew.login.js' encode='false' includeParams='none'/>"></script>
</head>  
<body>
	<div id="wrapper">
		<header>
			<img src="<s:url value='/resources/images/logo.png'/>"/>
		</header>
		<div class="container">
			<s:if test="%{#parameters.error != null}">
				<div style="color: red">Invalid User</div>
			</s:if>
			<s:if test="%{#parameters.logout != null}">
				<div style="color: red">Logout</div>
			</s:if>
			<s:if test="%{#parameters.timeout != null}">
				<div style="color: red">Timeout</div>
			</s:if>
			<section id="secLogin">
				<form id="loginForm" action="j_spring_security_check" method="post">
					<div id="divLogin">
						<s:textfield id="username" placeholder='enter your USERNAME' label="Username" name="username" onkeydown="return unameEntered(event)"/>
						<s:password id="password" placeholder='enter your PASSWORD' label="Password" name="password" onkeydown="return pwordEntered(event)"/>
						<!-- <input type="text" id="j_username" name="username"/>
						<input type="password" id="j_password" name="password"/> -->
						<!-- <input type="submit" name="submit" value="submit"> -->
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</div>
					<input type="button" value="Reset" onclick="resetPressed()">
				</form>
			</section>
		</div>
	</div>
</body>
</html>