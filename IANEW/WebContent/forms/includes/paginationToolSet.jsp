<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 26/08/2014
	==============================================
	Updates:
	
	==============================================	
	Description: A jsp containing a set of tools/functions for paginating a list
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>

<s:div cssClass="row">
	<s:div cssClass="one column alpha"><p></p></s:div>
	<sj:submit id="btnPrev" formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="prevPage()" value="prev"/>
	<s:div cssClass="three columns" style="text-align:center;">
		page <s:textfield size="1" id="pageTextField" value="%{page}" onkeypress="changePage(event)"/> of 
		<s:div id="totalNumberOfPagesDiv" style="display: inline"> <s:property value="totalNumberOfPages"/> </s:div>
	</s:div>
	<sj:submit id="btnNext" formIds="paginationForm" targets="formDiv" cssClass="one column" onclick="nextPage()" value="next"/>
	<s:div cssClass="two column omega"><p></p></s:div>
</s:div>