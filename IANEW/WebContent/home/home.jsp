<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<s:url value='/js/jquery/jquery-ui.min.js' encode='false' includeParams='none'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<s:head/>
<sj:head/>

<link href="<s:url value='/styles/home.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
<script src="<s:url value='/js/lists.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/home.js' encode='false' includeParams='none'/>"></script>
<script src="<s:url value='/js/radioActions.js' encode='false' includeParams='none'/>"></script>
<title>Illawarra Advocacy: Home</title>
</head>
<body>
	<!-- List of urls to called for from the menu -->
	<s:url id="urlEList" namespace="/enquiry" action="enquiryList">
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
	</s:url>
	
	
	<!-- Navigation -->
	<nav>
		<ul>
			<li><a id="aHome"href="#">Illawarra Advocacy</a></li>
			
			<li><a id="aE"href="#">Enquiry</a>
				<ul>
					<li><sj:a id="aENew" href="%{urlENew}" targets="formDiv" onclick="menuclicked()">New Enquiry</sj:a></li>
					<li><sj:a id="aEExisting" href="%{urlEExisting}" targets="formDiv" onclick="menuclicked()">Existing Enquiry Test</sj:a></li>
					<li><sj:a id="aEList" href="%{urlEList}" targets="formDiv" onclick="menuclicked()">Enquiry List</sj:a>
				</ul>
			</li>
			
			<li><a href="#">Case</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
			<li >
				<a href="#">Report</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			<li><a href="#">Time Management</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
			<li>
				<a href="#">Synchronize</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
			<li>
				<a href="#">Settings</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
			<li class="one columns" >
				<a href="#">Links</a>
				<ul>
					<li><sj:a id="aCNew" href="%{urlCNew}" targets="formDiv" onclick="menuclicked()">New Case</sj:a></li>
					<li><sj:a id="aCList" href="%{urlCList}" targets="formDiv" onclick="menuclicked()">Case List</sj:a>
				</ul>
			</li>
			
		</ul>
		
	</nav>
	
	<header>
		<img src="<s:url value='/resources/images/logo.png'/>"/>
	</header>
	<div id="content">
		<section id="secSearch">
			<div id="divSearchBox"><s:textfield id="searchbox" onkeypress="return addActivity(this.value, event)"/><br/></div>
			<div id="divRadio"><s:radio value="1" onclick="radioChecked(this.id)" name="radio" list="#{'1':'Database','2':'Document','3':'Report' }"/></div>
			<button onclick="displayActivities()">display</button>
			<button onclick="deleteLocalStorage()">clear</button>
		</section>
		
		<section id="secSuggestions">
			<!-- dynamically loads suggestions based on the key pressed from input box -->
			<article id="artSuggestionList" />
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
	</div>
	
	<footer id="statusBar">
		<label>User's Name</label>
		<button>logout</button>
	</footer>
	
	<%-- <script>
	 Experimental dragging div around.
	$(function(){
		$("#aE").draggable();		
	})
	</script> --%>
	
	<%-- <script>
	 Experimental Document find
	function findString(str){
		var strFound;
		
		if(window.find){
			
			strFound=self.find(str);
			//alert(strFound + " found");
			if(!strFound){
				strFound = self.find(str,0,1);
				//while(self.find(str,0,1)) continue;
			}  
		} 

	}

	</script> --%>
	
</body>
</html>