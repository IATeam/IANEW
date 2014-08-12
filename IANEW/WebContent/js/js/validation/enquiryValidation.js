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



$(document).ready(function(){ 
	$('#enquiryForm').validate({
		rules: {
			firstName: "required",
			lastName: "required",
			theGender: { selectcheck: true },
			email: {
				email: true,
				required: true
			}
		},
		messages: {
			firstName: "Require protege's first name.",
			lastName: "Require protege's last name.",
			email: "Invalid email",
			email: {
				email: "Require a valid email",
				required: "Require an email address"
			}
		}
	});
	
	jQuery.validator.addMethod('selectcheck', function(value){
		return (value != '-1');
	}, "Please select a gender");
	
});