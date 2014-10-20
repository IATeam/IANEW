<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="row">
	<s:div cssClass="sixteen columns" style="text-align: center;">
		
		
		<fieldset style="border: solid 1px grey">
			<legend>Sort By</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass="eleven columns alpha">
					<input type="radio" id="radiofirstname" name="sort"/>firstname 
					<input type="radio" id="radiolastname" name="sort"/>lastname
					<input type="radio" id="radiocreateddate" name="sort" checked="checked"/>created Date
					<input type="radio" id="radioupdateddate" name="sort"/>updated Date
				</s:div>
				<s:select cssClass="three columns omega" id="descending" list="#{'1':'ascending', '2':'descending'}" />
			</s:div>
		</fieldset>
			
		<fieldset style="border: solid 1px grey">
			<legend>Filter</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<input type="button" id="btnFilterName" value="name" class="three columns"/>
				<s:div id="filterName" cssClass="hidden">
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
				<s:div id="filterCreatedDate" cssClass="hidden">
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
				<s:div id="filterUpdatedDate" cssClass="hidden">
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
			<s:div cssClass="row fourteen columns">
				<input type="button" id="btnFilterIssues" value="issues" class="three columns"/>
				<s:checkboxlist list="issueTypeList" name="selectedIssues" listKey="id" listValue="issueName"></s:checkboxlist>
			</s:div>
		</fieldset>
		<input type="button" id="btnFilterSort" value="submit"/>
	</s:div>
</s:div>
<script>
	$("#btnFilterName").click(function(){
		
		if($("#filterName").hasClass("hidden"))
			$("#filterName").removeClass("hidden");
		else{
			$("#firstname").val("");
			$("#lastname").val("");
			$("#filterName").addClass("hidden");
		}
		
	});
	$("#btnFilterCreatedDate").click(function(){ 
		$("#filterCreatedDate").removeClass("hidden");
		
	});
	$("#btnFilterUpdatedDate").click(function(){ 
		$("#filterUpdatedDate").removeClass("hidden");
		
	});

	$(btnFilterSort).click(function(){
		var firstName, lastName, createdDateStart, createdDateEnd, updatedDateStart, updatedDateEnd;
		var sortField, ascending;

		var hasValue = false;
		
		var dash = "-";



		if($("#descending").val() == 1)			descending = false;
		else									descending = true;

		
		if($("#firstname").val().trim().length > 0){
			firstName = $("#firstname").val().trim();
			hasValue = true;
		}
		
		if($("#lastname").val().trim().length > 0){
			lastName = $("#lastname").val().trim();
			hasValue = true;
		}
		
		if($("#createdDateStart").val() != "" || $("#createdDateEnd").val() != ""){
			hasValue = true;
			if($("#createdDateStart").val() === "")
				createdDateStart = "*";
			else{
				
				/* need to look into a single function to replace all - */
				createdDateStart = $("#createdDateStart").val().replace("-", "")
				createdDateStart = createdDateStart.replace("-", "") + "*";
			}
				
			if($("#createdDateEnd").val() === "")
				createdDateEnd = "*";
			else{
				/* need to look into a single function to replace all - */
				createdDateEnd = $("#createdDateEnd").val().replace(dash, "")
				createdDateEnd = createdDateEnd.replace("-", "") + "*";
			}
		}

		if($("#updatedDateStart").val() != "" || $("#updatedDateEnd").val() != ""){
			hasValue = true;
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
		
		if($("#radiocreateddate").is(":checked"))		sortField = "createdDateTime";
		else if($("#radioupdateddate").is(":checked"))	sortField = "updatedDateTime";
		else if($("#radiofirstname").is(":checked"))	sortField = "contact.firstname";
		else 											sortField = "contact.lastname";

		
		/* if($("#descending").val() == 1)			descending = false;
		else									descending = true;

		if($("#recordsPerPage").val() == "")	recordsPerPage = 0;
		else									recordsPerPage = $("#recordsPerPage").val();

		if($("#startIndex").val() == "")		startIndex = 0;
		else									startIndex = $("#startIndex").val();

		if($("#currentPage").val() == "")		currentPage = 0;
		else									currentPage = parseInt($("#currentPage").val()); */


		if(hasValue){
			var submitData = {
				'firstName' 		: firstName,
				'lastName'			: lastName,
				'descending'		: descending,
				'sortField'			: sortField,
				/* 'startIndex'		: startIndex,
				'recordsPerPage'	: recordsPerPage,
				'currentPage'		: currentPage */
				'createdDateStart' 	: createdDateStart,
				'createdDateEnd'	: createdDateEnd,
				'updatedDateStart'	: updatedDateStart,
				'updatedDateEnd'	: updatedDateEnd
			};
		
			var url = "/IANEW/enquiryList/loadFilterSortResult.action"
			$.post(url, 
				submitData, 
				function(data){
				alert("success")
					$('#iterEnquiryList').html(data);
				}
			);
		}
	});
</script>