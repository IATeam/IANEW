/**
 * 
 */

function validated(){	
	expandAll();
	removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
	removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
	removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
	removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
	removeNullAndUpdateIndex($("#artGoal"), $("#itGoal"), $("#goalSize"));
	removeNullAndUpdateIndex($("#artRisk"), $("#itRisk"), $("#riskSize")); 
	removeNullAndUpdateIndex($("#artCommunication"), $("#itCommunication"), $("#communicationSize"));
	removeNullAndUpdateIndex($("#artDeveloper"), $("#itDeveloper"), $("#planDeveloperSize"));
	$('#caseForm').validate({ 
			rules: {
				//status
				"theDangerTypeId"						:	{	selectcheck:	true	}
//				"theStatusTypeId"						:	{	selectcheck:	true	}
				
//				//summary
//				theEnquiry								: 	{ 	selectcheck: 	true 	},
//				"iamodel.description"					: 	{	required 	: 	true, 
//																maxlength	:	10000 	},
//				
//				//personal information
//				"iamodel.contact.firstname"				: 	{	required 	: 	true, 
//																maxlength	:	100 	},
//				"iamodel.contact.othername"				: 	{	maxlength	:	100 	},
//				"iamodel.contact.lastname"				: 	{	required 	: 	true, 
//																maxlength	:	100 	},
//				"iamodel.contact.mobilephone"			: 	{	phone		: 	/[0-9\-\(\)\s]+/,
//																maxlength	:	40		},
//				theTitleTypeId							: 	{ 	selectcheck	: 	true 	},
//				theGenderTypeId							: 	{ 	selectcheck	: 	true 	},
//				theCulturalBackgroundTypeId				: 	{	selectcheck	: 	true 	},
//				"iamodel.contact.email"					: 	{	email		: 	true	},
//				
//				//address
//				theAccommodationTypeId					:	{ 	selectcheck	: 	true 	},
//				
//				//disability at least the first band must be filled
//				"theDisabilityListId[0]"				:	{ 	selectcheck	: 	true 	},
//				
//				//employment
//				"theEmploymentListId[0]"				:	{	selectcheck	:	true	},
//				
//				//enquiryissues
//				"theIssueListId[0]"						:	{	selectcheck	:	true	}
			},
			
			messages: {
				//summary
				"iamodel.description"					: 	"Required description"
				
//				//personal information
//				"iamodel.contact.firstname"				: 	"Requires first name.",
//				"iamodel.contact.lastname"				: 	"Requires last name",
//				"iamodel.conact.identification"			: 	"Requires identification number",
//				"iamodel.contact.email"					: 	{	email: "Require a valid email",
//																required: "Require an email address"	}
			
			},
			
			
			submitHandler: function() {
				
//				removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
//				removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
//				removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
//				removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
				alert("Validation complete, submitting form!");
				$.post("/IANEW/case/saveUpdateCase.action", 
						$("#caseForm").serialize(), function(data){
							$("#formDiv").html(data);
						}
				);

			}
		});
	 	
//	$('[name*="workphone"]').each(function(){
// 		$(this).rules('add', {
// 			phone: 		/[0-9\-\(\)\s]+/,
// 			maxlength: 40
// 		});
// 	});	
// 	
// 	$('[name*="homephone"]').each(function(){
// 		$(this).rules('add', {
// 			phone: 		/[0-9\-\(\)\s]+/,
// 			maxlength:	40
// 		});
// 	});	
//	
// 	//if any address field attribute has value then the rest of the address field must be filled in
// 	var addressSize = parseInt($("#addressSize").val()) + 1;
// 	 
// 	for(var i = 0; i < addressSize; i++){ 
// 		//uses jquery multiple attribute selector that is of input type text 
// 		//and has name that contains addressList[i]
// 		$("input[name*='addressesList["+i+"]'][type='text']").each(function(){
// 			
// 			if($(this).val().trim().length > 0){
// 				$("input[name*='addressesList["+i+"]'][type='text']").each(function(){
// 					$(this).rules('add', { required: true } );
// 				});
// 			}
// 			
// 			//set rules for max length
// 			if($(this).attr("[name*='suburb'"))
// 				$(this).rules('add', { maxlength: 100 } );
// 			else if($(this).attr("[name*='postcode'"))
// 				$(this).rules('add', { maxlength: 16 } );
// 			else if($(this).attr("[name*='state'"))
// 				$(this).rules('add', { maxlength: 30 } );
// 			else if($(this).attr("[name*='country'"))
// 				$(this).rules('add', { maxlength: 50 } );
// 		});
// 	}
// 	
// 	//if disability, employment, or issues comment or workphone textfield
// 	//has value, then add the selectcheck rule to the select type list.
// 	$('[name*="workphone"], [name*="comment"]').each(function(){
// 		
// 		//add max length of 3000 for comments
// 		if($(this).is('[name*="comment"]'))
// 			$(this).rules("add", { maxlength: 3000 });
// 			
// 		//find type and add selectcheck to SELECT option
// 		if($(this).val().trim().length > 0){ 
// 			$(this).parent().closest("section").find("[name*='ListId']").each(function(){
// 				//alert("adding rule for " + $(this).attr("name"))
// 				$(this).rules('add', { selectcheck: true } );
// 			});
// 		}
// 	});
// 	
// 	
// 	
//	jQuery.validator.addMethod('selectcheck', function(value){
//			return (value != '-1');
//		}, "Please select an option"); 
//		

}