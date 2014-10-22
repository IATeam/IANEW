<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="row">
	<s:div cssClass="sixteen columns" style="text-align: center;">
		
		
		<fieldset style="border: solid 1px grey">
			<legend>Sort By</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass="eleven columns alpha">
					<input type="radio" id="radioid" name="sort" checked="checked"/>filenumber
					<input type="radio" id="radiofirstname" name="sort"/>firstname 
					<input type="radio" id="radiolastname" name="sort"/>lastname
					<input type="radio" id="radiocreateddate" name="sort"/>created Date
					<input type="radio" id="radioupdateddate" name="sort"/>updated Date
				</s:div>
				<s:select cssClass="three columns omega" id="descending" value="2" list="#{'1':'ascending', '2':'descending'}" />
			</s:div>
		</fieldset>
			
		<fieldset style="border: solid 1px grey">
			<legend>Filter</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<input type="button" id="btnFilterName" value="name" class="three columns"/>
				<s:div id="filterName">
					<div class="inputfield four columns">
						<s:label for="firstname" value="firstname:" />
						<div><s:textfield id="firstname"/></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="lastname" value="lastname:" />
						<div><s:textfield id="lastname" /></div>
					</div>
				</s:div>
			</s:div>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<input type="button" id="btnFilterCreatedDate" value="created date" class="three columns"/>
				<s:div id="filterCreatedDate">
					<s:div cssClass="four columns">
						<s:label value="From" for="createdDateStart"/>  
						<input type="date" id="createdDateStart" name="createdDateStart"/>
					</s:div>
					<s:div cssClass="four columns">
						<s:label value="To" for="createdDateEnd"/>  
						<input type="date" id="createdDateEnd" name="createdDateEnd"/> 
					</s:div>
				</s:div>
			</s:div>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<input type="button" id="btnFilterUpdatedDate" value="updated date" class="three columns"/>
				<s:div id="filterUpdatedDate">
					<s:div cssClass="four columns">
						<s:label value="From" for="updatedDateStart"/> 
						<input type="date" id="updatedDateStart" name="updatedDateStart"/>
					</s:div>
					<s:div cssClass="four columns">
						<s:label value="To" for="updatedDateEnd"/> 
						<input type="date" id="updatedDateEnd" name="updatedDateEnd"/> 
					</s:div>
				</s:div>
			</s:div>
			<div class="two columns">
				<s:select id="status" list="statusSelectList" listValue="statusName" listKey="id" name="theStatus" headerKey="-1" headerValue="Status" />
			</div>
			<%-- <s:div cssClass="row fourteen columns">
				<input type="button" id="btnFilterIssues" value="issues" class="three columns"/>
				<s:checkboxlist list="issueTypeList" name="selectedIssues" listKey="id" listValue="issueName"></s:checkboxlist>
			</s:div> --%>
		</fieldset>
		<input type="button" id="btnFilterSort" value="Search" onclick="loadList(this)"/>
	</s:div>
</s:div>
<script>
	function loadList(btn){
		var formTitle = ($("#formTitle").text()); //used to check if it is either an enquirylist or case list
		var firstName, lastName, createdDateStart, createdDateEnd, updatedDateStart, updatedDateEnd, theStatus;
		var sortField, ascending;
		var goAhead = false;
		var dash = "-";

		var namespace, loadingDiv;
		switch(formTitle){
		case "Enquiry List": namespace = "enquiryList"; loadingDiv = "#iterEnquiryList"; break;
		case "Case List":	namespace = "caseList"; loadingDiv = "#iterCaseList" ;break;
		default:;
		}
		
		if($("#descending").val() == 1)			descending = false;
		else									descending = true;

		
		if($("#firstname").val().trim().length > 0){
			firstName = $("#firstname").val().trim();
		}else{
			//firstName = "";
		}
		
		if($("#lastname").val().trim().length > 0){
			lastName = $("#lastname").val().trim();
		}else{
			//lastName = "";
		}
		
		if($("#createdDateStart").val() != "" || $("#createdDateEnd").val() != ""){
			createdDateStart = getDateSearchFormat("#createdDateStart");
			alert(createdDateStart);
				
			if($("#createdDateEnd").val() === "")
				createdDateEnd = "*";
			else{
				var cde = new Date($("#createdDateEnd").val());
				createdDateEnd = formatDate(cde.setDate(cde.getDate() - 2)) + "*";
			}
		}

		if($("#updatedDateStart").val() != "" || $("#updatedDateEnd").val() != ""){
			if($("#updatedDateStart").val() === "")
				updatedDateStart = "*";
			else{
				
				/* need to look into a single function to replace all - */
				updatedDateStart = $("#updatedDateStart").val().replace("-", "")
				updatedDateStart = updatedDateStart.replace("-", "") + "*";
			}
				
			if($("#updatedDateEnd").val() === "")
				updatedDateEnd = "*";
			else{
				/* need to look into a single function to replace all - */
				updatedDateEnd = $("#updatedDateEnd").val().replace("-", "")
				updatedDateEnd = updatedDateEnd.replace("-", "") + "*";
			}
		}

		//get the sortfield
		if($("#radioid").is(":checked"))				sortField = "id";
		else if($("#radiocreateddate").is(":checked"))	sortField = "createdDateTime";
		else if($("#radioupdateddate").is(":checked"))	sortField = "updatedDateTime";
		else if($("#radiofirstname").is(":checked"))	sortField = "contact.firstname";
		else 											sortField = "contact.lastname";

		
		if($("#descending").val() == 1)			descending = false;
		else									descending = true;

		if($("#recordsPerPage").val() == "")	recordsPerPage = 0;
		else									recordsPerPage = $("#recordsPerPage").val();

		if($("#startIndex").val() == "")		startIndex = 0;
		else									startIndex = $("#startIndex").val();

		if($("#currentPage").val() == "")		currentPage = 0;
		else									currentPage = parseInt($("#currentPage").val()); 

		theStatus = $("select[name='theStatus']").val();

		var totalPage;
		if($("#totalNumberOfPagesDiv").text() == "")
			$("#totalNumberOfPagesDiv").text("0");
		
		totalPage = parseInt($("#totalNumberOfPagesDiv").text());

		var url = '';
		if($(btn).attr('id') == "btnFilterSort"){
			url = namespace + "/loadFilterSortResult.action"
			goAhead = true;
		}
		else if($(btn).attr('id') == "btnNext"){
			url = namespace + "/getNextPage.action";
			if(currentPage < totalPage)
				goAhead = true;
		}
		else if($(btn).attr('id') == "btnPrev"){
			
			url = namespace + "/getPrevPage.action";
			if(currentPage > 1)
				goAhead = true;
		}
		else{ //for when the user input a number for page change
			url = namespace + "/getPage.action";
			if(currentPage > 0 && currentPage <= totalPage)
				goAhead = true;
		} 

		

		var submitData = {
			'firstName' 		: firstName,
			'lastName'			: lastName,
			'descending'		: descending,
			'sortField'			: sortField,
			'startIndex'		: startIndex,
			'recordsPerPage'	: recordsPerPage,
			'currentPage'		: currentPage,
			'createdDateStart' 	: createdDateStart,
			'createdDateEnd'	: createdDateEnd,
			'updatedDateStart'	: updatedDateStart,
			'updatedDateEnd'	: updatedDateEnd,
			'theStatus'			: theStatus
		};
	
		if(goAhead){
			$.post(url, 
				submitData, 
				function(data){
					$(loadingDiv).html(data);
				}
			);
		}
	}

	function getDateSearchFormat(date){
		if($(date).val() === "")
			return "*";
		else{
			var d = new Date($(date).val());
			date = d.setDate(d.getDate() - 2);
			return formatDate(date) + "*";
		}
	}

	function formatDate(obj) {
	  
	  var months = ['01','02','03','04','05','06',
	               '07','08','09','10','11','12'];    
	  return obj.getFullYear() + months[obj.getMonth()] + obj.getDate();
	}

</script>