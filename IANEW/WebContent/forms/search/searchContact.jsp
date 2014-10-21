<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<section id="secContactSearch" class="sixteen columns">
	<input type="hidden" id="selectedContact"/>
	<s:div id="divSearchContactOptions">
		<s:div cssClass="row">
			<s:div cssClass="four columns"><p></p></s:div>
			<div class="inputfield four columns">
				<s:label for="firstname" value="firstname:" />
				<div><s:textfield id="contactfirstname"/></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="lastname" value="lastname:" />
				<div><s:textfield id="contactlastname" /></div>
			</div>
			<s:div cssClass="four columns"><p></p></s:div>
		</s:div>
		<s:div cssClass="row">
			<s:div cssClass="four columns"><p></p></s:div>
			<s:div cssClass="four columns">
				<s:label value="Sort By"/> 
				<input type="radio" id="radiofirstname" name="sort" checked="checked"/>firstname <input type="radio" id="radiolastname" name="sort"/>lastname
			</s:div>
			<s:div cssClass="four columns">
				<s:select cssClass="two columns alpha" id="descending" list="#{'1':'ascending', '2':'descending'}" />
				<input class="two columns omega" id="btnContactSearch" type="button" value="Update" onclick="loadContactList(this)"/>
			</s:div>
			<s:div cssClass="four columns"><p></p></s:div>
		</s:div>
	</s:div>
</section>

<section>
	<s:div id="contactList" cssClass="list">
		<%@include file="contactList.jsp" %>
	</s:div>
</section>

<script>
	function loadContactList(btn){
		var firstName, lastName, asending, sortField, recordsPerPage, startIndex;
		var goAhead = false;
		
		
		if($("#contactfirstname").val().trim().length > 0)
			firstName = $("#contactfirstname").val().trim();
		
		if($("#contactlastname").val().trim().length > 0)
			lastName = $("#contactlastname").val().trim();

		
		if($("#radiofirstname").is(":checked"))	sortField = "firstname";
		else									sortField = "lastname";
		
		if($("#descending").val() == 1)			descending = false;
		else									descending = true;

		if($("#recordsPerPage").val() == "")	recordsPerPage = 0;
		else									recordsPerPage = $("#recordsPerPage").val();

		if($("#startIndex").val() == "")		startIndex = 0;
		else									startIndex = $("#startIndex").val();

		if($("#currentPage").val() == "")		currentPage = 0;
		else									currentPage = parseInt($("#currentPage").val());

		
		if($("#contactfirstname").val().trim().length > 0 || $("#contactlastname").val().trim().length > 0){
			var submitData = {
				'firstName' 	: firstName,
				'lastName'		: lastName,
				'descending'	: descending,
				'sortField'		: sortField,
				'startIndex'	: startIndex,
				'recordsPerPage': recordsPerPage,
				'currentPage'	: currentPage
			}; 

			var totalPage;
			if($("#totalNumberOfPagesDiv").text() == "")
				$("#totalNumberOfPagesDiv").text() != 0;
			
			totalPage = parseInt($("#totalNumberOfPagesDiv").text());

			
			var url = '';
			if($(btn).attr('id') == "btnContactSearch"){
				url = 'contactList/loadClientSearchResult.action';
				goAhead = true;
			}
			else if($(btn).attr('id') == "btnNextContacts"){
				url = "contactList/getNextPage.action";
				if(currentPage < totalPage)
					goAhead = true;
			}
			else if($(btn).attr('id') == "btnPrevContacts"){
				url = "contactList/getPrevPage.action";
				if(currentPage > 1)
					goAhead = true;
			}
			else{ //for when the user input a number for page change
				url = "contactList/getPage.action"
				if(currentPage > 0 && currentPage <= totalPage)
					goAhead = true;
			} 
			//if(isNaN(parseInt($("#totalNumberOfPagesDiv").text())) || (currentPage >= 0 && currentPage <= totalPage))

			if(goAhead == true)
			{
				$.post(url, 
					submitData, 
					function(data){
						$('#contactList').html(data);
					}
				);
			}
		}
	}
</script>
