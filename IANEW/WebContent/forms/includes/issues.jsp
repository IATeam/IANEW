<label>Issues</label>
<s:div cssClass="greybackground">
	<s:if test="" >
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
	</s:if>
	<ul id="ulistIssues">
		<li class="list">
			<s:div cssClass="fieldsetborder">
				<fieldset>
					<s:select cssClass="four columns" list="#{'1':'Issues Types (Attention)'}" id="issueType" name="" />
					<div class="textarea ten columns">
						<s:label for="issuedescription" value="Issue Description:" />
						<s:textarea id="" cssClass="oneLineTextArea"></s:textarea> 
					</div>
				</fieldset>
			</s:div>
		</li>
	</ul>
	<div class="divbuttons">
		<input type="button" id="btnNewIssue" value="New Issue" />
	</div>
	
	<script>
	$(function(){
		$("#btnNewIssue").click(function(){ 
			$("#ulistIssues li").first().clone().appendTo("#ulistIssues");
		});
	});
	</script>
</s:div>