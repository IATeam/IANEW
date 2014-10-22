<!-- 
	Created By Quang Nhan
	Creaed On: 9/8/14
	Last Updated On: 9/8/14
	Description: A jsp page that displays a list of cases.
  -->

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Illawarra Advocacy: Case List</title>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/ianew.pagefiltersort.js' encode='false' includeParams='none'/>"></script>
<s:head/>
<sj:head/>
</head>
<body>
<!-- 
	<s:url var="urlCExisting" namespace="/case" action="getCase" includeContext="false"/>
		-->
	
	<s:url id="urlCNew" namespace="/case" action="newCase">
		<s:param name="formTitle">New Case</s:param>
	</s:url>
	
	<s:url var="urlCExisting" namespace="/case" action="getExistingCase" includeContext="false"/>		
	 
	<s:form id="caseForm" cssClass="form container" method="post" action="%{urlCExisting}">
	
			<!--Hidden Fields to pass parameters between pages -->
			<s:hidden id="hiddenid" name="hiddenid" />
	
			<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
			
			<%@include file="includes/formHeader.jsp" %>
			<%@include file="includes/filterSort.jsp" %>
			
			
			<div id="iterCaseList">
				<%@include file="/forms/includes/iterCaseList.jsp" %>
			</div>
		</s:form>
	<script>
		
	</script>	
</body>
</html>