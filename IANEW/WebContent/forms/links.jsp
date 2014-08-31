<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>    

<!--  
 * @author David
 *
 -->
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
					<s:text name="Advocacy Links" />
				</div>
			</div>
	</section>
	<div class="fieldsetborder">
		<ul>
			<li><s:a href="https://www.lifeline.org.au/">Lifeline</s:a></li>
		</ul>
	</div>
	<H1 class="h1">Illawarra</H1>
	<div class="fieldsetborder">
		<div class="row">
		<ul>
			<li><s:a href="http://www.headway.org.au/" >Headway Illawarra Inc.</s:a></li>
			<li><s:a href="http://www.illawarralegalcentre.org.au/" >Illawarra Legal Centre</s:a></li>
			<li><s:a href="http://www.wollongong.nsw.gov.au/services/community/pages/seniorsdisability.aspx" >Wollongong City Council</s:a></li>
			<li><s:a href="http://www.legalaid.nsw.gov.au/home" >Legal Aid Services for NSW</s:a></li>
		</ul>
		</div>
	</div>
	<H1 class="h1">NSW State</H1>
	<div class="fieldsetborder">
		<div class="row">
		<ul>
			<li><s:a href="http://www.adnnsw.org.au/" >Aboriginal Disability Network NSW</s:a></li>
			<li><s:a href="http://www.adhc.nsw.gov.au/" >Ageing, Disability and Home Care (ADHC)</s:a></li>
			<li><s:a href="http://www.antidiscrimination.lawlink.nsw.gov.au/adb/adb1_index.html" >Anti-Discrimination Board</s:a></li>
			<li><s:a href="http://www.acdnsw.org.au/" >Association for Children with a Disability NSW</s:a></li>
			<li><s:a href="http://www.biansw.org.au/" >Brain Injury Association of New South Wales</s:a></li>
			<li><s:a href="http://www.lawlink.nsw.gov.au/Lawlink/DiversityServices/ll_DiversitySrvces.nsf/pages/disability_index" >Department of Justice and Attorney General</s:a></li>
			<li><s:a href="http://www.austlii.edu.au/au/legis/qld/consol_act/dsa2006213/" >Disabilty Services Act 2006 (NSW)</s:a></li>
			<li><s:a href="http://www.community.nsw.gov.au/welcome_to_docs_website.html" >Family and Community Services (FACS) – formally DOCS</s:a></li>
			<li><s:a href="http://www.headspace.org.au/" >Headspace</s:a></li>
			<li><s:a href="https://www.humanrights.gov.au/about-commission-0" >Human Rights and Equal Opprotunity Commision – Disability Discrimination</s:a></li>
			<li><s:a href="http://www.ideas.org.au/" >IDEAS</s:a></li>
			<li><s:a href="http://www.idrs.org.au/home/index.php" >Intellectual Disability Rights Service (IDRS)
		</s:a></li>
			<li><s:a href="http://www.piac.asn.au/" >Public Interest Advocacy Centre (PIAC)</s:a></li>
			<li><s:a href="http://www.ncat.nsw.gov.au/ncat/index.html" >NCAT (Guardianship Tribunal)</s:a></li>
			<li><s:a href="http://www.nswcid.org.au/" >NSW Council for People with Disability</s:a></li>
			<li><s:a href="http://www.dan-inc.net.au/" >Disability Advocacy Network (DAN)</s:a></li>
			<li><s:a href="https://www.ombo.nsw.gov.au/" >NSW Ombudsman</s:a></li>
			<li><s:a href="http://www.pwd.org.au/" >People with Disability Australia</s:a></li>
			<li><s:a href="http://www.austlii.edu.au/au/nsw/">Australasian Legal Information Institute(NSW)</s:a></li>	
		</ul>
	</div>
	</div>
	<H1 class="h1">National</H1>
	<div class="fieldsetborder">
		<ul>
		<li><s:a href="http://www.humanservices.gov.au/customer/dhs/centrelink" >Centrelink</s:a></li>
		<li><s:a href="http://www.dss.gov.au/" >Department of Social Services</s:a></li>
		<li><s:a href="http://www.dana.org.au/" >Disability Advocacy Network Australia (DANA)
		</s:a></li>
		<li><s:a href="http://www.ndis.gov.au/" >National Disability Insurance Scheme (NDIS)</s:a></li>
		<li><s:a href="http://www.nds.org.au/" >National Disbility Services</s:a></li>
		<li><s:a href="http://www.neda.org.au/" >National Ethnic Disability Alliance</s:a></li>
		<li><s:a href="http://nationalrespiteaustralia.com.au/" >National Respite Association</s:a></li>
		</ul>
	</div>
	<H1 class="h1">International</H1>
	<div class="fieldsetborder">
		<ul>
		<li><s:a href="http://www.un.org/disabilities/convention/conventionfull.shtml" >United Nations Convention on the Rights of Persons with Disabilites</s:a></li>
		</ul>
	</div>
	</s:form>
	
</body>
</html>