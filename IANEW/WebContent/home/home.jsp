<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 14/07/2014
	==============================================
	Updates:
		01/08/2014 - 	Modified the URL - add parameters to pass formType parameters 
						by Quang Nhan
		10/08/2014 	- 	Remodified navigation menu to allow adaptation to mobile devices. 
						by Quang Nhan
		16/08/2014 -	Quang Nhan
						Moved all css and js links to the home file for preloading
				   -	Standardised the names of css and js files
	==============================================	
	Description: A jsp page that displays the main home page
------------------------------------------------------------------------------------------------>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<sj:head/>
<link rel="icon" type="image/x-icon" href="/IANEW/resources/images/favicon.ico">
<script src="<s:url value='/js/jquery/jquery-ui.min.js' encode='false' includeParams='none'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
	<link href="<s:url value='/styles/ianew.home.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
	<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
	<link href="<s:url value='/styles/import/sm-core-css.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
	<link href="<s:url value='/styles/import/sm-simple-modified.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
	
	
	<script src="<s:url value='/js/ianew.home.js' encode='false' includeParams='none'/>"></script>
	<script src="<s:url value='/js/ianew.radioActions.js' encode='false' includeParams='none'/>"></script>
	<script src="<s:url value='/js/jquery/jquery.smartmenus.js' encode='false' includeParams='none'/>"></script>
	<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>"></script>
	<title>Illawarra Advocacy: Home</title>

</head>
<body>

<!-- ---------------------------------------------------------------------------------------------- -->
<!-- URL Links for the Menu ----------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
	<!-- List of urls to called for from the menu -->
	<s:url id="urlEList" namespace="/enquiryList" action="getEnquiryList">
		<s:param name="formTitle">Enquiry List</s:param>
	</s:url>
	<s:url var="urlENew" namespace="/enquiry" action="newEnquiry">
		<s:param name="formTitle">New Enquiry</s:param>
		<s:param name="hiddenid">null</s:param>
	</s:url>
	<s:url id="urlEExisting" namespace="/enquiry" action="getEnquiry">
		<s:param name="hiddenid">1</s:param>
		<s:param name="formTitle">Existing Enquiry</s:param>
	</s:url>
	<s:url id="urlCList" namespace="/case" action="caseList">
		<s:param name="formTitle">Case List</s:param>
	</s:url>
	<s:url id="urlCNew" namespace="/case" action="newCase">
		<s:param name="formTitle">New Case</s:param>
	</s:url>
	<s:url id="urlLinks" namespace="/links" action="links">
		<s:param name="formTitle">Links</s:param>
	</s:url>
	<s:url id="urlReport" namespace="/report" action="report">
		<s:param name="formTitle">Report</s:param>
	</s:url>
	<s:url id="urlTimeManagement" namespace="/timeManagement" action="timeManagement">
		<s:param name="formTitle">Time Management</s:param>
	</s:url>
	<s:url id="urlSettings" namespace="/admin" action="startAdminPage">
		<s:param name="formTitle">Settings</s:param>
	</s:url>
	
	<div class="container">
	
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Navigation ----------------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
	<nav>
		<ul id="main-menu" class="sm sm-simple">
			<li><s:a id="aHome"href="/IANEW/home/home.jsp">Illawarra Advocacy</s:a></li>

			<li><s:a id="aE"href="#">Enquiry</s:a>
				<ul>
					<li><sj:a id="aENew" href="%{urlENew}" targets="formDiv" onclick="menuclicked()">New Enquiry</sj:a></li>
					<li><sj:a id="aEExisting" href="%{urlEExisting}" targets="formDiv" onclick="menuclicked()">Existing Enquiry Test</sj:a></li>
					<li><sj:a id="aEList" href="%{urlEList}" targets="formDiv" onclick="menuclicked()">Enquiry List</sj:a>
				</ul>
			</li>
			
			<li><sj:a id="menuCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">Case</sj:a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
			<li >
				<li><sj:a id="report" href="%{urlReport}" targets="formDiv"  onclick="menuclicked()">Report</sj:a></li>
			</li>
			<li>
				<li><sj:a id="timeManagement" href="%{urlTimeManagement}" targets="formDiv"  onclick="menuclicked()">Time Management</sj:a></li>
			
			<li>
				<s:a href="#">Synchronize</s:a>
				
			</li>

			<li><sj:a id="settings" href="%{urlSettings}" targets="formDiv" onclick="menuclicked()">Settings</sj:a></li>
			<li><sj:a id="links" href="%{urlLinks}" targets="formDiv">Links</sj:a></li>
		</ul>
	</nav>

<!-- ----------------------------------------------------------------------------------------------- -->
<!-- Header Containing the Image ------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------- -->	
	<header>
		<img src="<s:url value='/resources/images/logo.png'/>"/>
	</header>
	
<!-- ----------------------------------------------------------------------------------------------- -->
<!-- Body of the content --------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------- -->		
	<div id="content">
		<s:form id="searchForm" namespace="/" action="search" method="post" novalidate="novalidate">
			<section id="secSearch">
				<div id="divSearchBox">
					<s:textfield id="searchbox" Key="searchString" name="searchString"/><br/>
					<%-- onkeypress="return addActivity(this.value, event)" --%>
				</div>
				<div id="divRadio"><s:radio value="1" onclick="radioChecked(this.id)" name="radio" list="#{'1':'Database','2':'Document','3':'Report' }"/></div>
				<!-- <button onclick="displayActivities()">display</button>
				<button onclick="deleteLocalStorage()">clear</button> -->
			</section>
		</s:form>
		
		<section id="secSuggestions">
			<!-- dynamically loads suggestions based on the key pressed from input box -->
			<%@include file="/forms/search/search.jsp" %>
		</section>
			
		<section id="secLists">
			<article id="artActivities">
				<h4>Last 5 Activities:</h4>
				<!-- Dynamically loads activities -->
				<article id="artActivityList" ><ol></ol></article>
			</article>
			<article id="artFrequencies">
				<h4>3 Most Frequently Used Tasks:</h4>
				<!-- Dynamically loads tasks -->
				<article id="artTaskList"><ol></ol></article>
			</article>
			
		</section>
		
		<s:div id="formDiv" />
		<s:div id="helpPanel"/>
		
	</div>
	
	</div>
	
	<s:div id="leftPopUp" style="background: yellow; position: fixed; top: 20%; box-shadow: 3px 3px 5px grey;">left</s:div>
	<s:div id="rightPopUp">right</s:div>
	
<!-- ----------------------------------------------------------------------------------------------- -->
<!-- Home Page Footer ------------------------------------------------------------------------------ -->
<!-- ----------------------------------------------------------------------------------------------- -->	
	<footer id="statusBar">
		<label>User's Name</label>
		<button>logout</button>
	</footer>
	
	<script>
		$("#searchbox").keypress(function() {
			if(event.which == 13) {
				if ($("#searchbox").val() != null || $("#searchbox").val != "") {
					event.preventDefault();
					$("#searchForm").submit();
				}
			}
		});
		
		$(function(){
			$("#leftPopUp").hide();
			$("#rightPopUp").hide();
			$('#main-menu').smartmenus();
			//$("#slidingPlanel").hide();
			//hideSlidingPanel();
		});

		
		function hidePopUp(popUp){
			$(popUp).hide('slow');
			$("body").css("overflow-Y", "scroll")
		}

		function showPopUp(popUp){
			$(popUp).show('slow');
			$("html, body").css({"overflow-Y": "hidden"});
			
		}
	</script>
</body>
</html>
