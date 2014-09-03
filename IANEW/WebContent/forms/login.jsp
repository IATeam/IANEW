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


<!DOCTYPE html>
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
			<section id="secLogin">
				<s:form id="loginForm" action="login" >
					<div id="divLogin">
						<s:textfield id="username" placeholder='enter your USERNAME' label="Username" key="username" onkeydown="return unameEntered(event)"/>
						<s:password id="password" placeholder='enter your PASSWORD' label="Password" key="password" onkeydown="return pwordEntered(event)"/>
					</div>
					<input type="button" value="Reset" onclick="resetPressed()">
				</s:form>
			</section>
		</div>
	</div>
	<script>
			
		</script>
</body>
</html>