<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<section id="secContactSearchBar">
	<s:div id="divSearchContactOptions">
		<s:label for="firstname" value="firstname: " /><s:textfield id="contactfirstname"/>
		<s:label for="lastname" value="lastname: " /><s:textfield id="contactlastname"/><br/>
		<s:label value="Sort By"/> 
		<input type="radio" id="radiofirstname" name="sort"/>firstname <input type="radio" id="radiolastname" name="sort"/>lastname
		<s:select id="descending" list="#{'1':'ascending', '2':'descending'}" />
		<input id="btnContactSearch" type="button" value="Update" />
	</s:div>
</section>

<s:div>
	<s:div id="contactList">
		<%@include file="contactList.jsp" %>
	</s:div>
	<input id="selectContact" type="button" value="select contact"/>
</s:div>

<script>
	$("#btnContactSearch").click(function(){
		var firstName;
		var lastName;
		var asending;
		var sortField;
		var searchString = $("#searchbox").val();
		
		if($("#contactfirstname").val().trim().length > 0)
			firstName = $("#contactfirstname").val().trim();
		
		if($("#contactlastname").val().trim().length > 0)
			lastName = $("#contactlastname").val().trim();

		alert(searchString);
		if($("#radiofirstname").is(":checked"))	sortField = "firstname";
		else									sortField = "lastname";
		
		if($("#descending").val() == 1)			descending = false;
		else									descending = true;
		
		if(searchString != ""){
			/* $("#contactList").load("contactList/loadClientSearchResult.action?firstName=" 
					+ firstName + "&lastName=" + lastName + "&descending=" + descending + "&sortField=" + sortField);
			$("#contactList").load("contactList/loadClientSearchResult.action?searchString=" 
						 + searchString + "&descending=" + descending + "&sortField=" + sortField); */
			var data = {
							'searchString' 	: searchString ,
							'descending'	: descending,
							'sortField'		: sortField
						};
		
		 $.post('contactList/loadClientSearchResult.action', 
				data, 
				function(data){
					$('#contactList').html(data);
				}
			);
		}
			
	});
</script>