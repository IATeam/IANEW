<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- 	<s:iterator value="contactList">
		
		<s:property value="titleType.name" />
		<s:property value="firstname"/>
		<s:property value="othername"/>
		<s:property value="lastname"/>
		<s:property value="mobile"/>
		<s:property value="email"/>
		<s:property value="dob"/>
	</s:iterator> --%>

	<s:div cssClass="list">
	<s:iterator value="contactList">
		<s:div cssClass="curveBorder sixteen columns iteratorlist" onclick="bandSelected(this)">
			<s:div cssClass="row">
				<s:div cssClass="textarea two columns">
					<s:label for="id" value="Client#:" />
					<p class="id"><s:property value="id"/></p>
				</s:div>
				<s:div cssClass="textarea three columns">
					<s:label value="firstname:" />
					<p><s:property value="firstname" /></p>
				</s:div>
				<s:div cssClass="textarea three columns">
					<s:label value="othername:" />
					<p><s:property value="othername" /></p>
				</s:div>
				<s:div cssClass="textarea three columns">
					<s:label value="lastname:" />
					<p><s:property value="lastname" /></p>
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label value="Title:" />
					<p><s:property value="titleType.name" /></p>
				</s:div>
				<s:div cssClass="textarea two columns omega">
					<s:label value="Gender:" />
					<p><s:property value="genderType.genderName" /></p>
				</s:div>
			</s:div>
			
			<%-- <s:div cssClass="row toggled">
				<s:div cssClass="textarea fifteen columns omega">
					<s:label for="description" value="Description:" />
					<s:div><s:textarea cssClass="multiLineTextArea" name="description" readonly="true"/></s:div>
				</s:div>
			</s:div> --%>
		</s:div>
	</s:iterator>
</s:div>