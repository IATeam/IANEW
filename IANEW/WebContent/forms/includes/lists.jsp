<s:div cssClass="list">
	<s:iterator value="iamodelList">
		<s:div cssClass="curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
			<s:div cssClass="row">
				<s:div cssClass="textarea two columns">
					<s:label for="id" value="Enquiry#:" />
					<p class="id"><s:property value="id"/></p>
				</s:div>
				<s:div cssClass="textarea five columns">
					<s:label for="protege" value="Protege:" />
					<p><s:property value="contact.fullName" /></p>
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label value="Date:" />
					<p><s:property value="updatedDateTime" /></p>
				</s:div>
				<s:div cssClass="textarea six columns omega">
					<s:label for="issues" value="Issues:" />
					<p><s:property value="issuesTypes" /></p>
				</s:div>
			</s:div>
			
			<s:div cssClass="row toggled">
				<s:div cssClass="textarea fifteen columns omega">
					<s:label for="description" value="Description:" />
					<s:div><s:textarea cssClass="multiLineTextArea" name="description" readonly="true"/></s:div>
				</s:div>
			</s:div>
		</s:div>
	</s:iterator>
</s:div>