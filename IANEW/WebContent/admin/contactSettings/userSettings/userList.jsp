<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<body>
	<h3 class="sixteen columns" style="float:none;">User Details</h3>
	
	<s:url var="urlDisType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	
	<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}">
		<div>
			<s:label for="" value="Username: "/>
			<s:textfield id="" name="" />
			<s:label for="" value="Password:" />
			<s:password id="" name ="" />
			<s:label for="" value="Role:" />
			<s:textfield id="" name="" />			
		</div>
		<br>
		<sj:submit id="save" targets="ContactsSelect" cssClass="two columns alpha" value="Save" />
	</s:form>
</body>
</html>