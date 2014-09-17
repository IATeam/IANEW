<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>    

<!--  
 * @author David
 *
 -->
 
<!DOCTYPE html>
<html>
<head>
<title>Advocacy links</title>

<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
		      media="all"/>
	<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
		      media="all"/>
<link href="<s:url value='/styles/links.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
	      

</head>
<body>
	<s:form method="post" cssClass="cmxform form container" namespace='/links' id="linksForm" novalidate="novalidate">  
	<section class="imageContainer">
			<div class="row">
				<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
				<div class="headerText nine columns">
					<s:text name="Settings" />
				</div>
			</div>
	</section>
	<div class="fieldsetborder">
		<div class="row"><p> &nbsp;Settings (such as admin control features) are work in progress.</p></div>
	</div>
	<br>
	</s:form>
</body>
</html>