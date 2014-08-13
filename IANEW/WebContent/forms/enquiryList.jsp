<!-- 
	Created By Quang Nhan
	Creaed On: 9/8/14
	Last Updated On: 9/8/14
	Description: A jsp page that displays a list of enquiries.
  -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Enquiry List</title>
<link href="<s:url value='/styles/form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<s:head/>

</head>
<body>
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
		<s:iterator value="enquiries" var="enquiry">
		
			<div class="enquiryList">
				<div id="1" class="curveBorder sixteen columns" onclick="enquirySelected(this)">
					<div class="row">
						<s:div cssClass="textarea two columns">
							<s:label for="enquiryID" value="Enquiry#:" />
							
							<s:text name="id" />
						</s:div>
						<s:div cssClass="textarea five columns">
							<s:label for="protege" value="Protege:" />
							<s:text name="" />
						</s:div>
						<s:div cssClass="textarea two columns">
							<s:label value="Date:" />
							<s:text name="createdDateTime" />
						</s:div>
						<s:div cssClass="textarea six columns omega">
							<s:label for="issues" value="Issues:" />
							<s:text id="issues" name="" />
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
		
		
		<div class="clear"></div>
		<footer style="background:#444444; margin-top: 10px; padding: 5px;">
			<div class="row">
				<section class="five columns">
					<input type="button" value="Close" class="three columns" onclick="deselectAll()"/>
				</section>
				
				<section class="eleven columns alpha">
					<div class="seven columns alpha"><p></p></div>
					<input type="button" value="Open Enquiry" class="two columns"/>
					<input type="button" value="New Enquiry" class="two columns omega"/>
				</section>
			</div>
		</footer>
			
		
		
	</div>
	<script>
		function enquirySelected(div){
			deselectAll();
			$(div).addClass("listSelected");

			$(div).children("div").last().slideToggle();
		}
		function deselectAll(){
			$('#enquiryList').children().removeClass("listSelected");
		}
		
		$(function(){
			$(".toggled").hide();
		});
	</script>	
</body>
</html>