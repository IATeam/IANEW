<!-- 
	Created By Quang Nhan
	Creaed On: 9/8/14
	Last Updated On: 9/8/14
	Description: A jsp page that displays a list of cases.
  -->


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%> --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<title>Case List</title>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/ianew.pagefiltersort.js' encode='false' includeParams='none'/>"></script>
<s:head/>
<sj:head/>
</head>
<body>
	<s:url id="urlUpdate" namespace="/case" action="updateCaseList" includeContext="false"/>
	
	<s:url id="urlCNew" namespace="/case" action="newCase">
		<s:param name="formTitle">New Case</s:param>
	</s:url>
	<s:url var="urlCExisting" namespace="/case" action="getExistingCase" includeContext="false"/>		
	 
	<s:form id="caseForm" cssClass="form container" method="post" action="%{urlCExisting}">
	
			
		<!--Hidden Fields to pass parameters between pages -->
		<s:hidden id="hiddenid" name="hiddenid" />
		<s:hidden id="formTitle" name="formTitle" value="Case List" />
	
		<s:hidden id="totalNumberOfPages" name="totalNumberOfPages" />
		<div class="form container">  
			<section class="imageContainer">
				<div class="row">
					<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
					<div class="headerText nine columns">
						<div class="row"><s:text name="formTitle" /></div>
						<div class="row">
							<div class="nine columns" style="text-align: center;">
							
								<s:label for="sortBy" value="Sort by:"/>
								<s:select list="#{'cid':'cID', 'date': 'Date', 'name':'Name'}" id="sortBy"/>
								<s:label for="filter" value="Filter:"/>
								<s:select list="#{'all':'all', 'closed': 'closed', 'opened':'opened'}" id="filter"/>
							
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<!-- status="..." use attribute to get status info of iteration (index, count, first, even last, odd info) -->
			<div class="caseList">
				<s:iterator value="caseList">
					<div class="curveBorder sixteen columns iteratorlist" onclick="caseSelected(this)">
						<div class="row">
							<s:div cssClass="textarea two columns">
								<s:label for="caseID" value="Case#:" />
								<p class="caseID"><s:property value="id"/></p>
							</s:div>
							<s:div cssClass="textarea five columns">
								<s:label for="protege" value="Client:" />
								<p><s:property value="contact.fullName" /></p>
							</s:div>
							<s:div cssClass="textarea two columns">
								<s:label value="Date:" />
								<p><s:property value="updatedDateTime" /></p>
							</s:div>
							<s:div cssClass="textarea six columns omega">
								<s:label for="issues" value="Issues:" />
								<p><s:property value="issueTypes" /></p>
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
			
			
			
<!--------- the footer of the form containing the cancel, open case and new case as well as the pagination functions --------->


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
								page <s:textfield size="1" id="pageTextField" value="%{page}" onkeypress="changePage(event);"/> of 
								<div id="totalNumberOfPagesDiv" style="display: inline"> <s:text name="totalNumberOfPages"/> </div>
							</div>
							
							<sj:submit formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="nextPage()" value="next"/>
							
							
							<div class="two column omega"><p></p></div>
							
						</div>
					</section >
					<section class="four columns alpha">
						<sj:a targets="formDiv" id="newCButton" href="%{urlCNew}" >
						<input type="button" class="two columns alpha" value="New Case"/>
						</sj:a>
						<sj:submit targets="formDiv" id="open" value="Open Case" cssClass="two columns omega" />
					</section>
				</div>
			</footer>
		</div>
		</s:form>
		
<!----- Hidden form to pass pagination to action class submitted by the prev and next buttons ------------------------------------------------------------------->
		<div>
			<s:form id="paginationForm" method="post" action="%{urlUpdate}" namespace="case">
				<s:hidden id="page" name="page" />
				<s:hidden id="numberOfRecords" name="numberOfRecords" />
			</s:form> 
		</div>
	
	<script>
		
		function caseSelected(selectedDiv){
			deselectAll();
			$(selectedDiv).addClass("listSelected");

			$(selectedDiv).children("div").last().slideToggle();
			$("#hiddenid").val($(selectedDiv).find('.caseID').text());
			//alert($(selectedDiv).find('.caseID').text())
		}
		function deselectAll(){
			$('.caseList').children().removeClass("listSelected");
			if($('.toggled').is(':visible')){
				$('.toggled').hide('slide');
			}
		}
		
		$(function(){
			$(".toggled").hide();
		});
	</script>	
</body>
</html>