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
		submitHandler: function(form) {
			alert("Page submmited successfully");
		    $.post('/IANEW/case/saveUpdateCase.action', 
					$('#caseForm').serialize(), function(data){
					$('#formDiv').html(data);}
					);
		}
	});
}