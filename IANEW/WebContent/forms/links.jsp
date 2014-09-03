<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>    

<!--  
 * @author David
 *
 -->
 
<!DOCTYPE html>
<html>
<head>
<title>Advocacy links</title>

<link href="<s:url value='/styles/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/links.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
	      

</head>
<body>
	<s:form method="post" cssClass="cmxform form container" namespace='/links' id="linksForm" novalidate="novalidate">  
	<section class="imageContainer">
			<div class="row">
				<img class="seven columns" src="<s:url value='/resources/images/logo.png'/>"/>
				<div class="headerText nine columns">
					<s:text name="Links" />
				</div>
			</div>
	</section>
	<div class="fieldsetborder">
		<ul>
			<li><s:a href="https://www.lifeline.org.au/" target="_blank">Lifeline</s:a></li>
		</ul>
	</div>
	<H1 class="h1">Illawarra</H1>
	<div class="fieldsetborder">
		<div class="row">
		<ul>
			<li><s:a href="http://www.headway.org.au/" target="_blank">Headway Illawarra Inc.</s:a></li>
			<li><s:a href="http://www.illawarralegalcentre.org.au/" target="_blank">Illawarra Legal Centre</s:a></li>
			<li><s:a href="http://www.wollongong.nsw.gov.au/services/community/pages/seniorsdisability.aspx" target="_blank">Wollongong City Council</s:a></li>
			<li><s:a href="http://www.legalaid.nsw.gov.au/home" target="_blank">Legal Aid Services for NSW</s:a></li>
		</ul>
		</div>
	</div>
	<H1 class="h1">NSW State</H1>
	<div class="fieldsetborder">
		<div class="row">
		<ul>
			<li><s:a href="http://www.adnnsw.org.au/" target="_blank">Aboriginal Disability Network NSW</s:a></li>
			<li><s:a href="http://www.adhc.nsw.gov.au/" target="_blank">Ageing, Disability and Home Care (ADHC)</s:a></li>
			<li><s:a href="http://www.antidiscrimination.lawlink.nsw.gov.au/adb/adb1_index.html" target="_blank">Anti-Discrimination Board</s:a></li>
			<li><s:a href="http://www.acdnsw.org.au/" target="_blank">Association for Children with a Disability NSW</s:a></li>
			<li><s:a href="http://www.biansw.org.au/" target="_blank">Brain Injury Association of New South Wales</s:a></li>
			<li><s:a href="http://www.lawlink.nsw.gov.au/Lawlink/DiversityServices/ll_DiversitySrvces.nsf/pages/disability_index" target="_blank">Department of Justice and Attorney General</s:a></li>
			<li><s:a href="http://www.austlii.edu.au/au/legis/qld/consol_act/dsa2006213/" target="_blank">Disabilty Services Act 2006 (NSW)</s:a></li>
			<li><s:a href="http://www.community.nsw.gov.au/welcome_to_docs_website.html" target="_blank">Family and Community Services (FACS) – formally DOCS</s:a></li>
			<li><s:a href="http://www.headspace.org.au/" target="_blank">Headspace</s:a></li>
			<li><s:a href="https://www.humanrights.gov.au/about-commission-0" target="_blank">Human Rights and Equal Opprotunity Commision – Disability Discrimination</s:a></li>
			<li><s:a href="http://www.ideas.org.au/" target="_blank">IDEAS</s:a></li>
			<li><s:a href="http://www.idrs.org.au/home/index.php" target="_blank">Intellectual Disability Rights Service (IDRS)
		</s:a></li>
			<li><s:a href="http://www.piac.asn.au/" target="_blank">Public Interest Advocacy Centre (PIAC)</s:a></li>
			<li><s:a href="http://www.ncat.nsw.gov.au/ncat/index.html" target="_blank">NCAT (Guardianship Tribunal)</s:a></li>
			<li><s:a href="http://www.nswcid.org.au/" target="_blank">NSW Council for People with Disability</s:a></li>
			<li><s:a href="http://www.dan-inc.net.au/" target="_blank">Disability Advocacy Network (DAN)</s:a></li>
			<li><s:a href="https://www.ombo.nsw.gov.au/" target="_blank">NSW Ombudsman</s:a></li>
			<li><s:a href="http://www.pwd.org.au/" target="_blank">People with Disability Australia</s:a></li>
			<li><s:a href="http://www.austlii.edu.au/au/nsw/" target="_blank">Australasian Legal Information Institute(NSW)</s:a></li>	
		</ul>
	</div>
	</div>
	<H1 class="h1">National</H1>
	<div class="fieldsetborder">
		<ul>
		<li><s:a href="http://www.humanservices.gov.au/customer/dhs/centrelink" target="_blank">Centrelink</s:a></li>
		<li><s:a href="http://www.dss.gov.au/" target="_blank">Department of Social Services</s:a></li>
		<li><s:a href="http://www.dana.org.au/" target="_blank">Disability Advocacy Network Australia (DANA)
		</s:a></li>
		<li><s:a href="http://www.ndis.gov.au/" target="_blank">National Disability Insurance Scheme (NDIS)</s:a></li>
		<li><s:a href="http://www.nds.org.au/" target="_blank">National Disbility Services</s:a></li>
		<li><s:a href="http://www.neda.org.au/" target="_blank">National Ethnic Disability Alliance</s:a></li>
		<li><s:a href="http://nationalrespiteaustralia.com.au/" target="_blank">National Respite Association</s:a></li>
		</ul>
	</div>
	<H1 class="h1">International</H1>
	<div class="fieldsetborder">
		<ul>
		<li><s:a href="http://www.un.org/disabilities/convention/conventionfull.shtml" target="_blank">United Nations Convention on the Rights of Persons with Disabilites</s:a></li>
		</ul>
	</div>
	</s:form>
	
</body>
</html>