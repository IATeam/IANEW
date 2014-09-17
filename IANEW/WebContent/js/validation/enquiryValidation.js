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
				theGender								: 	{ 	selectcheck: 	true 	},
				theCulturalBackground					: 	{	selectcheck: 	true 	},
				"iamodel.contact.mobilephone"			: 	{	number: 		true,
																required: 		true	},
				"iamodel.contact.email"					: 	{	email: 			true,
																required: 		true	},
														
				//address
				theAccommodation						:	{ 	selectcheck: 	true 	},
				"iamodel.contact.accommodationComment"	: 		"required",
				
				"theDisabilityList[]"						:	{ 	selectcheck: 	true 	}
				
			},
			
			messages: {
				//summary
				"iamodel.description"					: 	"Required description",
				
				//personal information
				"iamodel.contact.firstname"				: 	"Requires first name.",
				"iamodel.contact.lastname"				: 	"Requires last name",
				"iamodel.conact.identification"			: 	"Requires identification number",
				"iamodel.contact.mobilephone"			: 	{	number: "Must be numbers",
																required: "Requires a contact number"	},
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
	 	
	jQuery.validator.addMethod('selectcheck', function(value){
			return (value != '-1');
		}, "Please select an option"); 
	