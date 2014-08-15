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
	      
<s:head/>

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
	<div id="lifeLine">
		<s:a href="https://www.lifeline.org.au/">Lifeline</s:a>
	</div>
	Illawarra
	<div id="Illawarra">
		<s:a id="HeadwayIllawarra" href="http://www.headway.org.au/" >Headway Illawarra Inc.</s:a>
		<br>
		<s:a id="IllawarraLegalCentre" href="http://www.illawarralegalcentre.org.au/" >Illawarra Legal Centre</s:a>
		<br>
		<s:a id="WollongongCityCouncil" href="http://www.wollongong.nsw.gov.au/services/community/pages/seniorsdisability.aspx" >Wollongong City Council</s:a>
		<br>
		<s:a id="LegalAidServicesNSW" href="http://www.legalaid.nsw.gov.au/home" >Legal Aid Services for NSW</s:a>
	</div>
	NSW State
	<div id="NSWState">
		<s:a id="AboriginalDisabilityNetwork" href="http://www.adnnsw.org.au/" >Aboriginal Disability Network NSW</s:a>
		<br>
		<s:a id="AgeingDisabilityHomeCare" href="http://www.adhc.nsw.gov.au/" >Ageing, Disability and Home Care (ADHC)</s:a>
		<br>
		<s:a id="AntiDiscriminationBoard" href="http://www.antidiscrimination.lawlink.nsw.gov.au/adb/adb1_index.html" >Anti-Discrimination Board</s:a>
		<br>
		<s:a id="AssociationForChildrenWithaDisabilityNSW" href="http://www.acdnsw.org.au/" >Association for Children with a Disability NSW</s:a>
		<br>
		<s:a id="BrainInjuryAssociationNSW" href="http://www.biansw.org.au/" >Brain Injury Association of New South Wales</s:a>
		<br>
		<s:a id="DepartmentOfJusticeAndAttorneyGeneral" href="http://www.lawlink.nsw.gov.au/Lawlink/DiversityServices/ll_DiversitySrvces.nsf/pages/disability_index" >Department of Justice and Attorney General</s:a>
		<br>
		<s:a id="DisabilityServicesAct2006" href="http://www.austlii.edu.au/au/legis/qld/consol_act/dsa2006213/" >Disabilty Services Act 2006 (NSW)</s:a>
		<br>
		<s:a id="FamilyAndCommunitySerives" href="http://www.community.nsw.gov.au/welcome_to_docs_website.html" >Family and Community Services (FACS) – formally DOCS</s:a>
		<br>
		<s:a id="HeadSpace" href="http://www.headspace.org.au/" >Headspace</s:a>
		<br>
		<s:a id="HumanRightsAndEqualOppurtunityCommision" href="https://www.humanrights.gov.au/about-commission-0" >Human Rights and Equal Opprotunity Commision – Disability Discrimination</s:a>
		<br>
		<s:a id="IDEAS" href="http://www.ideas.org.au/" >IDEAS</s:a>
		<br>
		<s:a id="IntellectualDisabilityRightsService" href="http://www.idrs.org.au/home/index.php" >Intellectual Disability Rights Service (IDRS)
		</s:a>
		<br>
		<s:a id="PublicInterestAdvocacyCentre" href="http://www.piac.asn.au/" >Public Interest Advocacy Centre (PIAC)</s:a>
		<br>
		<s:a id="NCAT" href="http://www.ncat.nsw.gov.au/ncat/index.html" >NCAT (Guardianship Tribunal)</s:a>
		<br>
		<s:a id="NSWCouncilForPeopleWithDisability" href="http://www.nswcid.org.au/" >NSW Council for People with Disability</s:a>
		<br>
		<s:a id="DisabilityAdvocacyNetwork" href="http://www.dan-inc.net.au/" >Disability Advocacy Network (DAN)</s:a>
		<br>
		<s:a id="NSWOmbudsman" href="https://www.ombo.nsw.gov.au/" >NSW Ombudsman</s:a>
		<br>
		<s:a id="PeopleWithDisabilityAustralia" href="http://www.pwd.org.au/" >People with Disability Australia</s:a>
		<br>
		<s:a id="AustralasianLegalInformationInstitute" href="http://www.austlii.edu.au/au/nsw/">Australasian Legal Information Institute(NSW)</s:a>	
	</div>
	National
	<div id="National">
		<s:a id="CenterLink" href="http://www.humanservices.gov.au/customer/dhs/centrelink" >Centrelink</s:a>
		<br>
		<s:a id="DepartmentOfSocialSerives" href="http://www.dss.gov.au/" >Department of Social Services</s:a>
		<br>
		<s:a id="DisabilityAdvocacyNetworkAustralia" href="http://www.dana.org.au/" >Disability Advocacy Network Australia (DANA)
		</s:a>
		<br>
		<s:a id="NationalDisabilityInsuranceScheme" href="http://www.ndis.gov.au/" >National Disability Insurance Scheme (NDIS)</s:a>
		<br>
		<s:a id="NationalDisabilityServices" href="http://www.nds.org.au/" >National Disbility Services</s:a>
		<br>
		<s:a id="NationalEthnicDisabilityAlliance" href="http://www.neda.org.au/" >National Ethnic Disability Alliance</s:a>
		<br>
		<s:a id="NationalRespiteAssociation" href="http://nationalrespiteaustralia.com.au/" >National Respite Association</s:a>
	</div>
	International
	<div id ="International">
		<s:a id="UnitedNationsConventionOnTheRightsOfPersonsWithDisabilities" href="http://www.un.org/disabilities/convention/conventionfull.shtml" >United Nations Convention on the Rights of Persons with Disabilites</s:a>
	</div>
	</s:form>
	
</body>
</html>