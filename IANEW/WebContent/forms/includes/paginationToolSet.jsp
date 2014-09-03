<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 26/08/2014
	==============================================
	Updates:
	
	==============================================	
	Description: A jsp containing a set of tools/functions for paginating a list
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:div cssClass="row">
	<s:div cssClass="one column alpha"><p></p></s:div>
	<sj:submit formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="prevPage()" value="prev"/>
	<s:div cssClass="three columns" style="text-align:center;">
		page <s:textfield size="1" id="pageTextField" value="%{page}" onkeydown="changePage(event)"/> of 
		<s:div id="totalNumberOfPagesDiv" style="display: inline"> <s:property value="totalNumberOfPages"/> </s:div>
	</s:div>
	<sj:submit formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="nextPage()" value="next"/>
	<s:div cssClass="two column omega"><p></p></s:div>
</s:div>