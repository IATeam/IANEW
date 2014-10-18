<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<h3 class="sixteen columns" style="float:none;">Advocate List</h3>
	<s:url var="urlUpdateAdvocateType" namespace="/admin" action="saveOrUpdateContact" includeContext="false"/>
		<div class="greybackground">
		<s:form id="editAdvocateTypeForm" method="post" action="%{urlUpdateAdvocateType}">
			<table>
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
				</thead>
				<tbody id="tbodyAdvocate">
					<%@include file="iterAdvocateList.jsp" %>
				</tbody>
			</table>
		</s:form>
		</div>