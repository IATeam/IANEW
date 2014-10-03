<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Title Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Title Type</h3>
	
	<s:url var="urlTiType" namespace="/admin" action="saveNewTitleType" includeContext="false"/>
	<s:url var="urlUpdateTiType" namespace="/admin" action="updateTitleType" includeContext="false"/>
	
	<div class="greybackground">
			<div id="titleType" class="toggled hideable">
				<s:form id="newTitleTypeForm" method="post" action="%{urlTiType}">
					<s:label for="titleName" value="Name: "/>
					<s:textfield id="titleName" name="titleName" />
					<sj:submit id="saveNewTitleType" targets="tbodyTitleType" cssClass="two columns alpha" value="Save"/>
				</s:form>
				<s:form id="editTitleTypeForm" method="post" action="%{urlUpdateTiType}">
					<table>
						<thead>
							<tr>
								<th>Title Name</th>
							</tr>
						</thead>
						<tbody id="tbodyTitleType">
							<%@include file="iterTitleTypes.jsp" %>
						</tbody>
					</table>
					<sj:submit targets = "tbodyTitleType" value="Update changes" id="btnEditTitle" cssClass="hidden" onclick="hideBtn(this)"/>
				</s:form>
			</div>
		</div>
		</section>
</body>
</html>