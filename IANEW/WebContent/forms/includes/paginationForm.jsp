<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 26/08/2014
	==============================================
	Updates:
	
	==============================================	
	Description: A form used by the pagination tool set used to submit to the server
				when updating
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>
<s:url var="urlUpdate" namespace="/enquiry" action="updateEnquiryList" includeContext="false"/>

<s:form id="paginationForm" method="post" action="%{urlUpdate}" >
	<s:hidden id="page" name="page" />
	<s:hidden id="numberOfRecords" name="numberOfRecords" />
</s:form>