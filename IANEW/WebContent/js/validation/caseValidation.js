/**
 * 
 */

function validated(){	
	expandAll();
	$('#caseForm').validate({ 
		rules:{
			theDangerTypeId						:	{	selectcheck	:	true	},
			theStatus							: 	{	selectcheck	:	true	},
			thePriority							:	{	selectcheck	:	true	},
			theAdvocate							:	{	selectcheck	:	true	},
			theTitleTypeId						: 	{ 	selectcheck	: 	true 	},
			theGenderTypeId						: 	{ 	selectcheck	: 	true 	},
			theCulturalBackgroundTypeId			: 	{	selectcheck	: 	true 	},
			theAccommodationTypeId				:	{ 	selectcheck	: 	true 	},
			thePlanStatus						:	{ 	selectcheck	: 	true 	},
			
			"iamodel.plan.providedPlanDate"		: 	{	required	:	true	},
			"iamodel.plan.consentSignedDate"	:	{	required	:	true	},
			"iamodel.plan.notes"				:	{	required	:	true	},
			
			"iamodel.description"				:	{	required	:	true	,
														maxlength	:	10000	},
			"iamodel.contact.firstname"			: 	{	required 	: 	true, 
														maxlength	:	100 	},
			"iamodel.contact.othername"			: 	{	maxlength	:	100 	},
			"iamodel.contact.lastname"			: 	{	required 	: 	true, 
														maxlength	:	100 	},
			"iamodel.contact.email"				: 	{	email		: 	true	},
			

			"theDisabilityListId[0]"			:	{ 	selectcheck	: 	true 	},
			"theEmploymentListId[0]"			:	{	selectcheck	:	true	},
			"theIssueListId[0]"					:	{	selectcheck	:	true	}
		},
		messages: {
			//summary
			"iamodel.description"					: 	"Required description",
			
			//personal information
			"iamodel.contact.firstname"				: 	"Requires first name.",
			"iamodel.contact.lastname"				: 	"Requires last name",
			"iamodel.contact.email"					: 	{	email: "Require a valid email",
															required: "Require an email address"	}
		
		},
		submitHandler: function() {
			alert("check");
			removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
			removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
			removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
			removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
			removeNullAndUpdateIndex($("#artGoal"), $("#itGoal"), $("#goalSize"));
			removeNullAndUpdateIndex($("#artRisk"), $("#itRisk"), $("#riskSize")); 
			removeNullAndUpdateIndex($("#artCommunication"), $("#itCommunication"), $("#communicationSize"));
			removeNullAndUpdateIndex($("#artDeveloper"), $("#itDeveloper"), $("#planDeveloperSize"));
		    $.post('/IANEW/case/saveUpdateCase.action', 
					$('#caseForm').serialize(), function(data){
					$('#formDiv').html(data);}
					);
		}
	});
	
	$('[name*="workphone"]').each(function(){
 		$(this).rules('add', {
 			phone: 		/[0-9\-\(\)\s\+]+/,
 			maxlength: 40
 		});
 	});	
	
// 	
// 	$('[name*="homephone"]').each(function(){
// 		$(this).rules('add', {
// 			phone: 		/[0-9\-\(\)\s\+]+/,
// 			maxlength:	40
// 		});
// 	});	
// 	
// 	//validation for disability and employment
// 	// if has value in either comment field or workphone field, add select check for dropdownbox
// 	$('[name*="workphone"], [name*="comment"]').each(function(){
// 		
// 		//add max length of 3000 for comments
// 		if($(this).is('[name*="comment"]'))
// 			$(this).rules("add", { maxlength: 3000 });
// 			
// 		//find type and add selectcheck to SELECT option
// 		if($(this).val().trim().length > 0){ 
// 			$(this).parent().closest("section").find("[name*='ListId']").each(function(){
// 				$(this).rules('add', { selectcheck: true } );
// 			});
// 		}
// 	});
// 	
// 	//validation for goals
 	$("#itGoal").children().each(function() {
 		var descriptionEle  = $(this).find("[name*='goalDescription']");
 		var goalActionEle = $(this).find("[name*='goalAction']");
 		var goalStatusEle = $(this).find("[name*='theGoalStatusList']");
 		var goalTypeEle = $(this).find("[name*='theGoalList']");
 		
		$(descriptionEle).rules("add", {maxlength	: 3000 });
		$(goalActionEle).rules("add", {maxlength	: 3000 });
		
 		if($(descriptionEle).val().trim().length > 0 || $(goalActionEle).val().trim().length > 0 || 
 				$(goalStatusEle).val() != -1 || $(goalStatusEle).val() != null ||
 				$(goalTypeEle).val() != -1 || $(goalTypeEle).val() != null) {
 			$(this).find("name*='theGoalStatusList'").rules('add', { selectcheck: true } );
 			$(this).find("name*='theGoalList'").rules('add', {selectcheck: true });
 		}

 	});
	
	jQuery.validator.addMethod('selectcheck', function(value){
		return (value != '-1');
	}, "Please select an option"); 
	
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});

	jQuery.validator.addMethod('phone', function(value, element, regexp){ 
			
 			var re= new RegExp(regexp);
 			return this.optional(element) || re.test(value);
 	}, "Phone number is invalid" );	
}