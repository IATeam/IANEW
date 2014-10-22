<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<section id="secPlanContactsSearch" class="sixteen columns">
	<input type="hidden" id="selectedPlanContact"/>
	<s:div id="divSearchPlanContactOptions">
		<s:div cssClass="row">
			<s:div cssClass="four columns"><p></p></s:div>
			<div class="inputfield four columns">
				<s:label for="firstname" value="firstname:" />
				<div><s:textfield id="plancontactfirstname"/></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="lastname" value="lastname:" />
				<div><s:textfield id="plancontactlastname" /></div>
			</div>
			<s:div cssClass="four columns"><p></p></s:div>
		</s:div>
		<s:div id="planChoice" cssClass="row">
			<s:div cssClass="four columns"><p></p></s:div>
			<s:div cssClass="four columns">
				<s:label value="Search for"/> 
				<input type="radio" id="radioSupport" name="type" checked="checked"/>support 
				<input type="radio" id="radioAuthorise" name="type"/>authorised
			</s:div>
			<s:div cssClass="four columns">
			</s:div>
			<s:div cssClass="four columns"><p></p></s:div>
		</s:div>
		<s:div cssClass="row">
			<s:div cssClass="four columns"><p></p></s:div>
			<s:div cssClass="four columns">
				<s:label value="Sort By"/> 
				<input type="radio" id="radioplanfirstname" name="plansort" checked="checked"/>firstname 
				<input type="radio" id="radioplanlastname" name="plansort"/>lastname
			</s:div>
			<s:div cssClass="four columns">
				<s:select cssClass="two columns alpha" id="plandescending" list="#{'1':'ascending', '2':'descending'}" />
				<input class="two columns omega" id="btnPlanContactSearch" type="button" value="Search" onclick="loadPlanContactList(this)"/>
			</s:div>
			<s:div cssClass="four columns"><p></p></s:div>
		</s:div>
	</s:div>
</section>

<section>
	<s:div id="planContactList" cssClass="list">
		<%@include file="planContactList.jsp" %>
	</s:div>
</section>

<script>
	function loadPlanContactList(btn){
		var firstName, lastName, asending, sortField, recordsPerPage, startIndex, search;
		var goAhead = false;
		
		
		if($("#plancontactfirstname").val().trim().length > 0)
			firstName = $("#plancontactfirstname").val().trim();
		
		if($("#plancontactlastname").val().trim().length > 0)
			lastName = $("#plancontactlastname").val().trim();

		if($("#radioSupport").is(":checked")) search="support";
		else									search="authorised";
		
		if($("#radioplanfirstname").is(":checked"))	sortField = "firstname";
		else									sortField = "lastname";
		
		if($("#plandescending").val() == 1)			descending = false;
		else									descending = true;

		if($("#recordsPerPagePlan").val() == "")	recordsPerPage = 0;
		else									recordsPerPage = $("#recordsPerPagePlan").val();

		if($("#startIndexPlan").val() == "")		startIndex = 0;
		else									startIndex = $("#startIndexPlan").val();

		if($("#currentPlanPage").val() == "")		currentPage = 0;
		else									currentPage = parseInt($("#currentPlanPage").val());

		
		if($("#plancontactfirstname").val().trim().length > 0 || $("#plancontactfirstname").val().trim().length > 0){
			var submitData = {
				'firstName' 	: firstName,
				'lastName'		: lastName,
				'descending'	: descending,
				'sortField'		: sortField,
				'startIndex'	: startIndex,
				'recordsPerPage': recordsPerPage,
				'currentPage'	: currentPage,
				'search'		: search
			}; 

			var totalPage;
			if($("#totalNumberOfPagesPlanDiv").text() == "")
				$("#totalNumberOfPagesPlanDiv").text() != 0;
			
			totalPage = parseInt($("#totalNumberOfPagesPlanDiv").text());

			
			var url = '';
			if($(btn).attr('id') == "btnPlanContactSearch"){
				url = '/IANEW/contactList/loadClientSearchResult.action';
				goAhead = true;
			}
			else if($(btn).attr('id') == "btnNextPlanContacts"){
				url = "/IANEW/contactList/getNextPage.action";
				if(currentPage < totalPage)
					goAhead = true;
			}
			else if($(btn).attr('id') == "btnPrevPlanContacts"){
				url = "/IANEW/contactList/getPrevPage.action";
				if(currentPage > 1)
					goAhead = true;
			}
			else{ //for when the user input a number for page change
				url = "/IANEW/contactList/getPage.action"
				if(currentPage > 0 && currentPage <= totalPage)
					goAhead = true;
			} 

			if(goAhead == true)
			{
				$.post(url, 
					submitData, 
					function(data){
						$('#planContactList').html(data);
					}
				);
			}
		}
	}
</script>