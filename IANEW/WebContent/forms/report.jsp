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
					<s:text name="Report" />
				</div>
			</div>
	</section>
	</s:form>
	<s:form id="reportForm" cssClass="cmxform" action="downloadExcel" namespace="/report" method="post" novalidate="novalidate">  
	<div class="fieldsetborder" style="color: black;">
		<div class="row">
			<p> &nbsp;Reporting is a work in progress, to be implemented via Microsoft Excel.</p>
			<div id="tableNameDiv">
				<display:table id="data" export="true" requestURI="ReportAction.report" name="contact" >
					 <display:column property="id" media="html"/>
					<display:column property="firstname" />
					<display:column property="AccommodationTypes.accommodationName" />
				</display:table>
				
				<%-- <table border="1" width="90%" align="center">
					<thead>
						<tr>
							<td>Table Name</td>
							<td>Table Description</td>
							<td>Select</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="tableNameList" status="stat">
							<tr>
								<td><s:property value="tableNameList[%{#stat.index}].tablename" /></td>
								<td><s:property value="tableNameList[%{#stat.index}].description"/></td>
								<td><s:checkbox></s:checkbox></td>
							</tr>
						</s:iterator>
					</tbody>
				</table> --%>
			</div>
			<center><sj:submit targets="formDiv" value="submit" /></center>
		</div>
	</div>
	<br>
	</s:form>
</body>
</html>