<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Cultural Background Type</h3>
	<s:url var="urlCulType" namespace="/admin" action="saveNewculturalBackgroundType" includeContext="false"/>
	<s:url var="urlUpdateCulType" namespace="/admin" action="updateCulturalBackgroundTypes" includeContext="false"/>
	
	<div class="greybackground">
		<div id="culturalBackgrounType" class="toggled hideable">
			<s:form id="newCulturalBackgroundTypeForm" method="post" action="%{urlCulType}">
				<s:label for="culturalBackgroundName" value="Name: "/>
				<s:textfield id="culturalBackgroundName" name="culturalBackgroundName" />
				<s:label for="culturalBackgroundDescription" value="Description" />
				<s:textarea id="culturalBackgroundDescription" name ="culturalBackgroundDescription" cols="70" rows="1" />
				<sj:submit id="saveNewCulturalBackgroundType" targets="tbodyCulturalBackgroundType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editCulturalBackgroundTypeForm" method="post" action="%{urlUpdateCulType}">
				<table>
					<thead>
						<tr>
							<th>Cultural Background Type Name</th>
							<th>Cultural Background Type Description</th>
						</tr>
					</thead>
					<tbody id="tbodyCulturalBackgroundType">
						<%@include file="iterators/iterCulturalBackgroundTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyCulturalBackgroundType" value="Update changes" id="btnEditCulturalBackground" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>