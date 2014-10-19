/**
 * 
 */

function validated(){	
	//expandAll();
	alert("HELLO");

	$('#saveAdvocateForm').validate({ 
		rules:{
			/*theTitleTypeId						: 	{ 	selectcheck	: 	true 	},
			theGenderTypeId						: 	{ 	selectcheck	: 	true 	},
			theCulturalBackgroundTypeId			: 	{	selectcheck	: 	true 	},
			theAccommodationTypeId				:	{ 	selectcheck	: 	true 	},*/
			"contact.firstname"			: 	{	required 	: 	true, 
				maxlength	:	80 	},
			/*"contact.othername"			: 	{	maxlength	:	80 	},
			"contact.lastname"			: 	{	required 	: 	true, 
				maxlength	:	80 	},
			"contact.email"				: 	{	email		: 	true	},*/
		},
		//messages: {
			//"contact.firstname"				: 	"Requires first name.",
			/*"contact.lastname"				: 	"Requires last name",
			"conact.identification"			: 	"Requires identification number",
			"contact.email"					: 	{	email: "Require a valid email",
															required: "Require an email address"	},	*/	
		//},
		submitHandler: function(form) {
			alert("Validation completed");
			//removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
		    $.post("/IANEW/admin/saveOrUpdateContact.action", 
					$("#saveAdvocateForm").serialize(), function(data){
					$("#formDiv").html(data);}
					);
		}
	});
	
	/*$("[name*='workphone']").each(function(){
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
 	
 	//validation for disability and employment
 	// if has value in either comment field or workphone field, add select check for dropdownbox
 	$('[name*="workphone"], [name*="comment"]').each(function(){
 		
 		//add max length of 3000 for comments
 		if($(this).is('[name*="comment"]'))
 			$(this).rules("add", { maxlength: 2000 });
 			
 		//find type and add selectcheck to SELECT option
 		if($(this).val().trim().length > 0){ 
 			$(this).parent().closest("section").find("[name*='ListId']").each(function(){
 				$(this).rules('add', { selectcheck: true } );
 			});
 		}
 	});
 	
 	jQuery.validator.addMethod("selectcheck", function(value){
		return (value != "-1");
	}, "Please select an option"); 
	
	jQuery.validator.addMethod('phone', function(value, element, regexp){ 

	 	var re= new RegExp(regexp);
	 	return this.optional(element) || re.test(value);
	 	}, "Phone number is invalid" ); */
}