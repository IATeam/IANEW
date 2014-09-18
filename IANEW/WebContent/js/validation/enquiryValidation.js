/**
 * Created By Quang
 * Created Date: 11/08/2014
 * Last Updated
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

	

	$('#enquiryForm').validate({ 
			rules: {
				//summary
				theEnquiry								: 	{ 	selectcheck: 	true 	},
				"iamodel.description"					: 		"required",
				
				
				//personal inoformation
				"iamodel.contact.firstname"				: 		"required",
				"iamodel.contact.lastname"				: 		"required",
				"iamodel.contact.identification"		:		"required",
				"iamodel.contact.mobilephone"			: 	{	required: true,
																phone: 		/[0-9\-\(\)\s]+/ },
				theGender								: 	{ 	selectcheck: 	true 	},
				theCulturalBackground					: 	{	selectcheck: 	true 	},
				"iamodel.contact.email"					: 	{	email: 			true,
																required: 		true	},
				//address
				theAccommodation						:	{ 	selectcheck: 	true 	},
				"iamodel.contact.accommodationComment"	: 		"required",
				
				//disability at least the first band must be filled
				"theDisabilityList[0]"					:	{ 	selectcheck: 	true 	}
				
				//employment
				
			},
			
			messages: {
				//summary
				"iamodel.description"					: 	"Required description",
				
				//personal information
				"iamodel.contact.firstname"				: 	"Requires first name.",
				"iamodel.contact.lastname"				: 	"Requires last name",
				"iamodel.conact.identification"			: 	"Requires identification number",
				"iamodel.contact.email"					: 	{	email: "Require a valid email",
																required: "Require an email address"	},
				"iamodel.contact.accommodationComment"	: 		"Requires comment"
			
			},
			
			
			submitHandler: function(form) {
				alert("submitted!");
				checkForm();
				form.submit();
			}
		});
	 	
	$('[name*="workphone"]').each(function(){
 		$(this).rules('add', {
 			phone: 		/[0-9\-\(\)\s]+/
 		});
 	});	
 	
 	$('[name*="homephone"]').each(function(){
 		$(this).rules('add', {
 			phone: 		/[0-9\-\(\)\s]+/
 		});
 	});	
 	
 	$('[name*="postcode"]').each(function(){
 		$(this).rules('add', {
 			number: true,
 			min: 1000,
 			max: 9999
 		});
 	});	
		
	jQuery.validator.addMethod('selectcheck', function(value){
			return (value != '-1');
		}, "Please select an option"); 
		
		
	jQuery.validator.addMethod('phone', function(value, element, regexp){ 
			
 			var re= new RegExp(regexp);
 			return this.optional(element) || re.test(value);
 	}, "Phone number is invalid" );	
 	
 	
 	
 	
 	
 	