
/**
 * @author Quang
 * Created Date: 11/08/2014
 * 
 * Updates:
 * 		29/09/2014 -	Quang Nhan:
 * 						Removed required fro identificatin, email, mobile phone, comment
 * 						Added required for issues, flag, employment as requested by client
 *		06/10/2014 -	Quang Nhan
 *						Rework validatino for 1 to many relationships in the band such that
 *						the user must select a type if other fields within the band has input
 *						Reworked the address such that if one field has input then the others
 *						must be filled in
 *						Add max number of characters to relevant fields to database specification
 *		19/10/2014 -	Modified address validation to make sure that suburb and street are 
 *						the only required fields
 * Description: Client side validation for the enquiry form using
 * jquery's validation.js http://jqueryvalidation.org/
 */

/*
 * For future reference:
 * for custom validation using regix
 * http://stackoverflow.com/questions/280759/jquery-validate-how-to-add-a-rule-for-regular-expression-validation
 * $(id/class).rules("add", {regex: "regex expression"})
 * $.vadator.addMethod("regex", 
 * 		function(value, element, regexp){ 
 * 			var re= new RegExp(regexp);
 * 			return this.optional(element) || re.test(value);
 * 	}, "message" );	
 * http://stackoverflow.com/questions/9461571/how-can-we-specify-rules-for-jquery-validation-plugin-by-class	
 * for adding dyanmic content validation
 */

function validated(){	
	
	expandAll();

	$('#enquiryForm').validate({ 
			rules: {
				//status
				"theDangerTypeId"						:	{	selectcheck:	true	},
				"theStatusTypeId"						:	{	selectcheck:	true	},
				"theEnquiryTypeId"						:   {	selectcheck:	true	},
				
				//summary
				theEnquiry								: 	{ 	selectcheck: 	true 	},
				"iamodel.description"					: 	{	required 	: 	true, 
																maxlength	:	10000 	},
				
				//personal information
				"iamodel.contact.firstname"				: 	{	required 	: 	true, 
																maxlength	:	100 	},
				"iamodel.contact.othername"				: 	{	maxlength	:	100 	},
				"iamodel.contact.lastname"				: 	{	required 	: 	true, 
																maxlength	:	100 	},
				"iamodel.contact.mobilephone"			: 	{	phone		: 	/[0-9\-\(\)\s\+]+/,
																maxlength	:	40		},
				theTitleTypeId							: 	{ 	selectcheck	: 	true 	},
				theGenderTypeId							: 	{ 	selectcheck	: 	true 	},
				theCulturalBackgroundTypeId				: 	{	selectcheck	: 	true 	},
				"iamodel.contact.email"					: 	{	email		: 	true	},
				
				//address
				theAccommodationTypeId					:	{ 	selectcheck	: 	true 	},
				
				//disability at least the first band must be filled
				"theDisabilityListId[0]"				:	{ 	selectcheck	: 	true 	},
				
				//employment
				"theEmploymentListId[0]"				:	{	selectcheck	:	true	},
				
				//enquiryissues
				"theIssueListId[0]"						:	{	selectcheck	:	true	}
			},
			
			submitHandler: function() {
				
				alert("Validation complete, submitting form!");
				
				removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
				removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
				removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
				removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
				
				$.post('/IANEW/enquiry/saveUpdateEnquiry.action', 

					$('#enquiryForm').serialize(), function(data){
					$('#formDiv').html(data);}
				);

			}
		});
	 	
	$("#open").click(function(){ alert($("#formTitle").text())
	if($("#hiddenid").val() != ""){
		if($("#formTitle").text() == "Case List")
			$.post('/IANEW/case/getExistingCase.action', 
				$('#caseListForm').serialize(), function(data){
				$('#formDiv').html(data);}
			);
		else
			$.post('/IANEW/enquiry/getExistingEnquiry.action', 
				$('#enquiryListForm').serialize(), function(data){
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
 	
 	$('[name*="homephone"]').each(function(){
 		$(this).rules('add', {
 			phone: 		/[0-9\-\(\)\s\+]+/,
 			maxlength:	40
 		});
 	});	
 	
 	//removed postcode validation because of non numeric
 	//pcodes outside of australia.
 	/*
 	$('[name*="postcode"]').each(function(){
 		$(this).rules('add', {
 			number: true,
 			min: 1000,
 			max: 9999
 		});
 	});
 	*/	
	
 	//if any address field attribute has value then the rest of the address field must be filled in
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
 				$(this).rules('add', { maxlength: 100 } );
 			}else if($(this).attr("[name*='street']")){
 				$(this).rules('add', { maxlength: 250 } );
 			}else if($(this).attr("[name*='postcode']"))
 				$(this).rules('add', { maxlength: 16 } );
 			else if($(this).attr("[name*='state']"))
 				$(this).rules('add', { maxlength: 30 } );
 			else if($(this).attr("[name*='country']"))
 				$(this).rules('add', { maxlength: 50 } );
 		});
 	}
 	
 	//if disability, employment, or issues comment or workphone textfield
 	//has value, then add the selectcheck rule to the select type list.
 	$('[name*="workphone"], [name*="comment"]').each(function(){
 		
 		//add max length of 3000 for comments
 		if($(this).is('[name*="comment"]'))
 			$(this).rules("add", { maxlength: 3000 });
 			
 		//find type and add selectcheck to SELECT option
 		if($(this).val().trim().length > 0){ 
 			$(this).parent().closest("section").find("[name*='ListId']").each(function(){
 				$(this).rules('add', { selectcheck: true } );
 			});
 		}
 	});
 	
 	
 	
	jQuery.validator.addMethod('selectcheck', function(value){
			return (value != '-1');
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
 	
 	
 	
 	