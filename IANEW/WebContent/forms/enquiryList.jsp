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
	<s:url var="urlEExisting" namespace="/enquiry" action="getEnquiry" includeContext="false"/>
		
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry">
	</s:url>
	<s:url id="urlUpdate" namespace="/enquiry" action="updateEnquiryList" includeContext="false"/>
	

	
	
	
	<s:form id="enquiryForm" method="post" action="%{urlEExisting}">
	
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
			<div class="enquiryList">
				<s:iterator value="enquiryList">
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
				</s:iterator>
			</div>
			
			<div class="clear"></div>
			
			
			<!--Hidden Fields to pass parameters between pages -->
	<s:hidden id="enquiryID" name="hidden" />
	<s:hidden id="formTitle" name="formTitle" value="Existing Enquiry" />
	
	<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
			
			
<!--------- the footer of the form containing the cancel, open enquiry and new enquiry as well as the pagination functions --------->


			<footer style="background:#444444; margin-top: 10px; padding: 5px;">
				<div class="row">
					<section class="four columns">
						<input type="button" value="Close" class="three columns" onclick="deselectAll()"/>
					</section >
					<section class="eight columns">
						<div class="row">
							<div class="one column alpha"><p></p></div>
							
							<sj:submit formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="prevPage()" value="prev"/>
							
							<div class="three columns" style="text-align:center;">
								page <s:textfield size="1" id="pageTextField" value="%{page}"/> of 
								<div id="totalNumberOfPagesDiv" style="display: inline"> <s:text name="totalNumberOfPages"/> </div>
							</div>
							
							<sj:submit formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="nextPage()" value="next"/>
							
							
							<div class="two column omega"><p></p></div>
							
						</div>
					</section >
					<section class="four columns alpha">
						<sj:submit targets="formDiv" id="open" value="Open Enquiry" cssClass="two columns alpha"/>
						<sj:a targets="formDiv" id="newEButton" href="%{urlENew}" ><input type="button" class="two columns omega" value="New Enquiry"/></sj:a>
					</section>
				</div>
			</footer>
			
		</s:form>
		
<!----- Hidden form to pass pagination to action class submitted by the prev and next buttons ------------------------------------------------------------------->
		<div ">
			<s:form id="paginationForm" method="post" action="%{urlUpdate}" namespace="enquiry">
				<s:hidden id="page" name="page" />
				<s:hidden id="numberOfRecords" name="numberOfRecords" />
			</s:form> 
		</div>
	
	<script>
		function nextPage(){
			var currentPageNumber = parseInt($("#pageTextField").val());
			var totalNumberOfPages = parseInt( $("#totalNumberOfPagesDiv").text())
			
			if(currentPageNumber < totalNumberOfPages){ 
				var nextPageNumber = currentPageNumber + 1;
				$("#pageTextField").val(nextPageNumber);
				$("#page").val(nextPageNumber);
			}
		}
		
		function prevPage(){
			var currentPageNumber = parseInt($("#pageTextField").val());
			
			if(currentPageNumber > 1 ){
				var prevPageNumber = currentPageNumber - 1;
				$("#pageTextField").val(prevPageNumber);
				$("#page").val(prevPageNumber);
			}
		}
		
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