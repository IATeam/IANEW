<h3 class="sixteen columns" style="float:none;">Issues</h3>
<s:div cssClass="greybackground">
	<%-- <s:if test="" >
		<s:iterator value="">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					<s:select cssClass="four columns" list="#{'1':'Issues Types (Attention)'}" id="issueType" name="" />
					<div class="textarea ten columns">
						<s:label for="issuedescription" value="Issue Description:" />
						<s:textarea id="issuedescription" cssClass="oneLineTextArea"></s:textarea> 
					</div>
				</fieldset>
			</s:div>
		</s:iterator>
	</s:if> --%>
	
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