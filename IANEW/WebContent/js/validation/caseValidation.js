/**
 * 
 */

function validated(){	
	expandAll();
	
	$('#caseForm').validate({ 
		rules:{
			theDangerTypeId								:	{	selectcheck	:	true	},
			theStatus									: 	{	selectcheck	:	true	},
			thePriority									:	{	selectcheck	:	true	},
			theAdvocate									:	{	selectcheck	:	true	},
			theTitleTypeId								: 	{ 	selectcheck	: 	true 	},
			theGenderTypeId								: 	{ 	selectcheck	: 	true 	},
			theCulturalBackgroundTypeId					: 	{	selectcheck	: 	true 	},
			theAccommodationTypeId						:	{ 	selectcheck	: 	true 	},
			thePlanStatus								:	{ 	selectcheck	: 	true 	},
			
			"iamodel.plan.providedPlanDate"				: 	{	required	:	true	},
			"iamodel.plan.consentSignedDate"			:	{	required	:	true	},
			"iamodel.plan.notes"						:	{	required	:	true	,
																maxlength	:   8000	},
			
			"iamodel.description"						:	{	required	:	true	,
																maxlength	:	8000	},
			"iamodel.contact.firstname"					: 	{	required 	: 	true, 
																maxlength	:	100 	},
			"iamodel.contact.othername"					: 	{	maxlength	:	100 	},
			"iamodel.contact.lastname"					: 	{	required 	: 	true, 
																maxlength	:	80 		},
			"iamodel.contact.email"						: 	{	email		: 	true	},
														
			"iamodel.contact.culturalBackgroundComment"	: 	{	maxlength	: 	250		},
			"iamodel.contact.accommodationComment"		: 	{	maxlength	: 	250		},
			

			"theDisabilityListId[0]"					:	{ 	selectcheck	: 	true 	},
			"theEmploymentListId[0]"					:	{	selectcheck	:	true	},
			"theIssueListId[0]"							:	{	selectcheck	:	true	},
			"theIssueStatusList[0]"						:	{	selectcheck	:	true	}
		},
		messages: {
			"iamodel.contact.email"				: 	{	email: "Require a valid email"}
		
		},
		submitHandler: function(form) {
			alert("Validation completed");
			removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
			removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
			removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
			removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
			removeNullAndUpdateIndex($("#artGoal"), $("#itGoal"), $("#goalSize"));
			removeNullAndUpdateIndex($("#artRisk"), $("#itRisk"), $("#riskSize")); 
			removeNullAndUpdateIndex($("#artCommunication"), $("#itCommunication"), $("#communicationSize"));
			removeNullAndUpdateIndex($("#artDeveloper"), $("#itDeveloper"), $("#planDeveloperSize"));
		    $.post("/IANEW/case/saveUpdateCase.action", 
					$("#caseForm").serialize(), function(data){
					$("#formDiv").html(data);}
					);
		}
	});
	


	
	$("[name*='workphone']").each(function(){
 		$(this).rules("add", {
 			phone: 		/[0-9\-\(\)\s\+]+/,
 			maxlength: 30
 		});
 	});	
	
 	
 	$('[name*="homephone"]').each(function(){
 		$(this).rules('add', {
 			phone: 		/[0-9\-\(\)\s\+]+/,
 			maxlength:	30
 		});
 	});	
 	
 	
 	//validation for address
 	var addressSize = parseInt($("#addressSize").val()) + 1;
 	for(var i = 0; i < addressSize; i++){ 
 	 	//uses jquery multiple attribute selector that is of input type text 
 	 	//and has name that contains addressList[i]
 		$("input[name*='addressesList["+i+"]'][type='text']").each(function(){
 	 	
			if($(this).val().trim().length > 0){
				$("input[name*='addressesList["+i+"].street'][type='text'], input[name*='addressesList["+i+"].suburb'][type='text']").each(function(){
					$(this).rules('add', { required: true } );
				});
		 	}
		 	
		 	//set rules for max length
		 	if($(this).attr("[name*='suburb']")){
		 		$(this).rules('add', { maxlength: 80 } );
		 	}else if($(this).attr("[name*='street']")){
		 		$(this).rules('add', { maxlength: 230 } );
		 	}else if($(this).attr("[name*='postcode']"))
		 		$(this).rules('add', { maxlength: 10 } );
		 	else if($(this).attr("[name*='state']"))
		 		$(this).rules('add', { maxlength: 25 } );
		 	else if($(this).attr("[name*='country']"))
		 		$(this).rules('add', { maxlength: 40 } );
		 });
 	 }
 	
 	// validation for disability and employment
 	// if has value in either comment field or workphone field, add select check for dropdownbox
 	// it doesnt work at the moment
// 	$("#itDisability").children().each(function(){
// 		var comments = $(this).find("[name*='comments']");
// 		var issueSelect = $(this).find("[name*='theDisabilityListId']");
// 		$(comments).rules("add", {maxlength: 2000});
// 		
// 		if ($(comments).val().trim().length > 0) {
// 			$(issueSelect).rules("add", {selectcheck: true});
// 		}
// 		
// 	});
// 	
// 	// validation for case issue
// 	// does not work
// 	$("#itIssue").children("section").each(function(){
// 		var commentEle  = $(this).find("[name*='comments']");
// 		var issuetypeEle = $(this).find("[name*='theIssueListId']");
// 		var issueStatusEle = $(this).find("[name*='theIssueStatusList']");
// 		
// 		$(commentEle).rules("add", {maxlength	: 2000 });
// 			
// 		//find type and add selectcheck to SELECT option
// 		if($(commentEle).val().trim().length > 0 || 
// 				$(issuetypeEle).val() != -1 || 
// 				$(issueStatusEle).val() != -1){ 
// 			alert($(commentEle).attr("name") + " test");
// 			$(issuetypeEle).rules('add', { selectcheck: true } );
// 			$(issueStatusEle).rules('add', { selectcheck: true } );
// 		}
// 	});
// 	
// 	//validation for goals
// 	// does not work
// 	$("#itGoal").children("section").each(function() {
// 		var descriptionEle  = $(this).find("[name*='goalDescription']");
// 		var goalActionEle = $(this).find("[name*='goalAction']");
// 		var goalStatusEle = $(this).find("[name*='theGoalStatusList']");
// 		var goalTypeEle = $(this).find("[name*='theGoalList']");
//		$(descriptionEle).rules("add", {maxlength : 2000});
//		$(goalActionEle).rules("add", {maxlength : 2000});
//		
//		
// 		if($(descriptionEle).val().trim().length > 0 || $(goalActionEle).val().trim().length > 0 || 
// 				$(goalStatusEle).val() != -1  ||
// 				$(goalTypeEle).val() != -1 ) {
// 			alert($(goalStatusEle).attr("name"));
// 			$(goalStatusEle).rules("add", { selectcheck : true } );
// 			$(goalTypeEle).rules("add", {selectcheck: true });
// 		}
//
// 	}); 
 	
	jQuery.validator.addMethod("selectcheck", function(value){
		return (value != "-1");
	}, "Please select an option"); 
	
	jQuery.validator.addMethod('phone', function(value, element, regexp){ 

	 	var re= new RegExp(regexp);
	 	return this.optional(element) || re.test(value);
	 	}, "Phone number is invalid" ); 
	
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});
}