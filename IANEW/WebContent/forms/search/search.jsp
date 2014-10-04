<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<s:url value='/styles/search.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" media="all"/>
<s:div cssClass="form">
	<!-- <article id="artSuggestionList" > -->
		<dl>
			<s:iterator value="resultList" status="stat">
				<s:if test="%{resultList[#stat.index].entityName()=='Enquiries'}">
					<s:url var="existingEnquiry" namespace="/enquiry" action="getEnquiry" >
						<s:param name="hiddenid"><s:property value="resultList[#stat.index].id" /></s:param>
						<s:param name="formTitle" value="Existing Enquiry" />
					</s:url>
					<dt>
						<span class="rn"><s:property value="%{#stat.count}" /></span>
						<sj:a href="%{existingEnquiry}" targets="formDiv" class="l" onclick="menuclicked()"><strong>Enquiry E<s:property value="resultList[#stat.index].id" /></strong></sj:a>
					</dt>
					<dd>
						<p class="s"><s:property value="resultList[#stat.index].toString()"/></p>
					</dd>
				</s:if>
				<s:elseif test="%{resultList[#stat.index].entityName()=='IndividualCases'}">
					<s:url var="existingCase" namespace="/case" action="getExistingCase">
						<s:param name="hiddenid"><s:property value="resultList[#stat.index].id" /></s:param>
						<s:param name="formTitle" value="Existing Case" />
					</s:url>
					<dt>
						<span class="rn"><s:property value="%{#stat.count}" /></span>
						<sj:a href="%{existingCase}" targets="formDiv" class="l" onclick="menuclicked()"><strong>Individual Case C<s:property value="resultList[#stat.index].id"/></strong></sj:a>
					</dt>
					<dd>
						<p class="s"><s:property value="resultList[#stat.index].toString()"/></p>
					</dd>
				</s:elseif>
			</s:iterator>
		</dl>
	<!-- </article>  -->
</s:div>