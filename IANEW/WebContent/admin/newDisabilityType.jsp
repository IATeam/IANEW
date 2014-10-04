<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Disability Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Disability Type</h3>	
	<s:url var="urlDisType" namespace="/admin" action="saveNewDisabilityType" includeContext="false"/>
	<s:url var="urlUpdateDisType" namespace="/admin" action="updateDisabilityType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="disabilityType" class="toggled hideable">
			<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}" onsubmit="clearDisabilityInput();">
				<s:label for="disabilityName" value="Name: "/>
				<s:textfield id="disabilityName" name="disabilityName" />
				<s:label for="disabiltyDescription" value="Description" />
				<s:textarea id="disabilityDescription" name ="disabilityDescription" cols="70" rows="1"/>
				<sj:submit id="saveNewDisabilityType" targets="tbodyDisabilityType" cssClass="two columns alpha" value="Save" />
			</s:form>
			<s:form id="editDisabilityTypeForm" method="post" action="%{urlUpdateDisType}">
				<table>
					<thead>
						<tr>
							<th>Disability Name</th>
							<th>Disability Description</th>
						</tr>
					</thead>
					<tbody id="tbodyDisabilityType">
						<%@include file="iterDisabilityTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyDisabilityType" value="Update changes" id="btnEditDisability" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
	<script>
	function clearDisabilityInput(){
		$('#disabilityName').val('');
		$('#disabilityDescription').val('');
	}
	</script>
</body>
</html>