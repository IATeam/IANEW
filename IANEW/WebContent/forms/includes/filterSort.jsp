<%@taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="row">
	<s:div cssClass="sixteen columns" style="text-align: center;">
		
		
		<fieldset style="border: solid 1px grey">
			<legend>Sort By</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass="eleven columns alpha">
					<input type="radio" id="radioid" name="sort" checked="checked"/>filenumber
					<input type="radio" id="radiofirstname" name="sort"/>firstname 
					<input type="radio" id="radiolastname" name="sort"/>lastname
					<input type="radio" id="radiocreateddate" name="sort"/>created Date
					<input type="radio" id="radioupdateddate" name="sort"/>updated Date
				</s:div>
				<s:select cssClass="three columns omega" id="descending" value="2" list="#{'1':'ascending', '2':'descending'}" />
			</s:div>
		</fieldset>
			
		<fieldset style="border: solid 1px grey">
			<legend>Filter</legend>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<!-- <input type="button" id="btnFilterName" value="name" class="three columns"/> -->
				<s:label for="name" value="Name:" cssClass="three columns"/>
				<s:div id="filterName">
					<div class="inputfield four columns">
						<s:label for="firstname" value="firstname:" />
						<div><s:textfield id="firstname"/></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="lastname" value="lastname:" />
						<div><s:textfield id="lastname" /></div>
					</div>
				</s:div>
			</s:div>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<!-- <input type="button" id="btnFilterCreatedDate" value="created date" class="three columns"/> -->
				<s:label for="createdDate" value="Created Date:" cssClass="three columns"/>
				<s:div id="filterCreatedDate">
					<s:div cssClass="four columns">
						<s:label value="From" for="createdDateStart"/>  
						<input type="date" id="createdDateStart" name="createdDateStart"/>
					</s:div>
					<s:div cssClass="four columns">
						<s:label value="To" for="createdDateEnd"/>  
						<input type="date" id="createdDateEnd" name="createdDateEnd"/> 
					</s:div>
				</s:div>
			</s:div>
			<s:div cssClass="row fourteen columns">
				<s:div cssClass ="two columns"><p></p></s:div>
				<!-- <input type="button" id="btnFilterUpdatedDate" value="updated date" class="three columns"/> -->
				<s:label for="updatedDate" value="Updated Date:" cssClass="three columns"/>
				<s:div id="filterUpdatedDate">
					<s:div cssClass="four columns">
						<s:label value="From" for="updatedDateStart"/> 
						<input type="date" id="updatedDateStart" name="updatedDateStart"/>
					</s:div>
					<s:div cssClass="four columns">
						<s:label value="To" for="updatedDateEnd"/> 
						<input type="date" id="updatedDateEnd" name="updatedDateEnd"/> 
					</s:div>
				</s:div>
			</s:div>
			<div class="row sixteen columns">
				<s:div cssClass ="five columns"><p></p></s:div>
				<s:div cssClass ="four columns">
					<s:select id="status" list="statusSelectList" listValue="statusName" listKey="id" name="theStatus" headerKey="-1" headerValue="Status" />
				</s:div>
			</div>
		</fieldset>
		<input type="button" id="btnFilterSort" value="Search" onclick="loadList(this)"/>
	</s:div>
</s:div>