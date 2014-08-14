<h3 class="sixteen columns" style="float:none;">Issues</h3>
<s:div cssClass="greybackground">
	<%-- <s:if test="" > --%>
		<s:iterator value="issueSet">
			<section class="secIssue sixteen columns curveBorder">
				<div class="four columns"><s:select list="issueSelectList.{issueName}" value="issue" name="theIssue" headerKey="-1" headerValue="Select an Issue" /></div>
				<div class="textarea eleven columns omega">
					<s:label for="issuedescription" value="Issue Description:" />
					<s:textarea id="" cssClass="oneLineTextArea" name="comment"/> 
				</div>
			</section>
		</s:iterator>
	
	
	
	<article id="artIssue" class="row">
		<section class="secIssue sixteen columns curveBorder">
			<div class="four columns"><s:select list="issueSelectList.{issueName}" value="issue" name="theIssue" headerKey="-1" headerValue="Select an Issue" /></div>
			<div class="textarea eleven columns omega">
				<s:label for="issuedescription" value="Issue Description:" />
				<s:textarea id="" cssClass="oneLineTextArea" name="" /> 
			</div>
		</section>
	</article>
	<div class="row">
		<div class="fourteen columns alpha"><p></p></div>
		<input type="button" id="btnNewIssue" value="New Issue" class="two columns" />
	</div>
	
	<script>
	$(function(){
		$("#btnNewIssue").click(function(){ 
			$(".secIssue").first().clone().appendTo("#artIssue");
		});
	});
	</script>
</s:div>