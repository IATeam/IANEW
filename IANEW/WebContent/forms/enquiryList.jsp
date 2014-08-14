<!-- 
	Created By Quang Nhan
	Creaed On: 9/8/14
	Last Updated On: 9/8/14
	Description: A jsp page that displays a list of enquiries.
  -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Enquiry List</title>
<link href="<s:url value='/styles/form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<s:head/>
<sj:head/>
</head>
<body>
	<s:url id="urlEExisting" namespace="/enquiry" action="getEnquiry" includeContext="false">
		<s:param name="formTitle">Existing Enquiry</s:param>
	</s:url>
	<s:form form="enquiryForm" method="post" action="%{urlEExisting}">
	
		<div class="form container">  
			<section class="imageContainer">
				<div class="row">
					<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
					<div class="headerText nine columns">
						<div class="row"><s:text name="formTitle" /></div>
						<div class="row">
							<div class="nine columns" style="text-align: center;">
							
								<s:label for="sortBy" value="Sort by:"/>
								<s:select list="#{'eid':'eID', 'date': 'Date', 'name':'Name'}" id="sortBy"/>
								<s:label for="filter" value="Filter:"/>
								<s:select list="#{'all':'all', 'closed': 'closed', 'opened':'opened'}" id="filter"/>
							
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<!-- iterator -->
			<!-- status="..." use attribute to get status info of iteration (index, count, first, even last, odd info) -->
			<s:iterator value="enquiryList">
			
				<div class="enquiryList">
					<div class="curveBorder sixteen columns iteratorlist" onclick="enquirySelected(this)">
						<div class="row">
							<s:div cssClass="textarea two columns">
								<s:label for="enquiryID" value="Enquiry#:" />
								<p class="enquiryID"><s:property value="id"/></p>
							</s:div>
							<s:div cssClass="textarea five columns">
								<s:label for="protege" value="Protege:" />
								<p><s:property value="contact.getFullName()" /></p>
							</s:div>
							<s:div cssClass="textarea two columns">
								<s:label value="Date:" />
								<p><s:property value="updatedDateTime" /></p>
							</s:div>
							<s:div cssClass="textarea six columns omega">
								<s:label for="issues" value="Issues:" />
								<p><s:property value="getIssuesTypes()" /></p>
							</s:div>
						</div>
						
						<div class="row toggled">
							<div class="textarea fifteen columns omega">
								<s:label for="description" value="Description:" />
								<div><s:textarea cssClass="multiLineTextArea" name="description" readonly="true"/></div>
							</div>
						</div>
					</div>
				</div>
			
			</s:iterator>
			<s:hidden id="enquiryID" name="hidden" />
			
			<div class="clear"></div>
			<footer style="background:#444444; margin-top: 10px; padding: 5px;">
				<div class="row">
					<section class="five columns">
						<input type="button" value="Close" class="three columns" onclick="deselectAll()"/>
					</section>
					
					<section class="eleven columns alpha">
						<div class="seven columns alpha"><p></p></div>
						<sj:submit id="open" value="Open Enquiry" cssClass="two columns"/>
						<input type="button" id="new" value="New Enquiry" class="two columns omega"/>
					</section>
				</div>
			</footer>
			
		</s:form>
		
		
	</div>
	
	
	<%-- <s:url id="urlEList" namespace="/enquiry" action="enquiryList">
		<s:param name="formTitle">Enquiry List</s:param>
	</s:url>
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry">
		<s:param name="formTitle">New Enquiry</s:param>
	</s:url>
	<s:url var="urlEExisting" namespace="/enquiry" action="getEnquiry">
		<s:param name="formTitle">Existing Enquiry</s:param>
	</s:url>
	<s:url id="urlCList" namespace="/case" value="caseList">
		<s:param name="formTitle">Case List</s:param>
	</s:url>
	<s:url id="urlCNew" namespace="/case" action="newCase">
		<s:param name="formTitle">New Case</s:param>
	</s:url> --%>
	
	
	<script>
		function enquirySelected(selectedDiv){
			deselectAll();
			$(selectedDiv).addClass("listSelected");

			$(selectedDiv).children("div").last().slideToggle();
			$("#enquiryID").val($(selectedDiv).find('.enquiryID').text())
			//alert($(selectedDiv).find('.enquiryID').text())
		}
		function deselectAll(){
			$('.enquiryList').children().removeClass("listSelected");
			if($('.toggled').is(':visible')){
				$('.toggled').hide('slide');
			}
		}
		$('#new').click(function(){
			alert($('#enquiryID').val())
		});
		
		$(function(){
			$(".toggled").hide();
		});
	</script>	
</body>
</html>