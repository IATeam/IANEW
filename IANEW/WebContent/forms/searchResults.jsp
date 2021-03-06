<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!--  
 * @author David
 *
 -->

<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>

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
					<s:text name="Report" />
				</div>
			</div>
	</section>
	</s:form> 
	<div class="fieldsetborder" style="color: black;">
		<div class="row">
			<p>Search results</p>
			<s:iterator value="list" var="Object">
			<s:property />
			</s:iterator>
		</div>
	</div>
	<br>
</body>
</html>