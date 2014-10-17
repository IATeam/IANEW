<%@taglib prefix="s" uri="/struts-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Summary</h3>
<div class="greybackground">
	<div id="issuesDiv" class="toggled hideable">	
		<fieldset>
			<s:div cssClass="row">
				<s:div cssClass="textarea sixteen columns">
					<s:label for="notes" value="Notes:" />
					<s:div><s:textarea id="notes" name="iamodel.description" cssClass="multiLineTextArea" /></s:div>
				</s:div>
			</s:div>
		</fieldset>
	</div>
</div>