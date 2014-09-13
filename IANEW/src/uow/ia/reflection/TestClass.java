package uow.ia.reflection;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.xml.Adapter1;

import com.sun.xml.registry.uddi.bindings_v2_2.Contact;

import uow.ia.bean.Addresses;
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.bean.IndividualCases;

public class TestClass {
	
	public static void main(String[] args) {
		
		newObject();
		
	}


	private static void newObject(){
		Enquiries e1 = new Enquiries();
		Enquiries e2 = new Enquiries();
		
		Reflection ref = new Reflection();
		e1 = (Enquiries) ref.initializeNewModel(e1);
		//ref.initializeNewModel(e1);
		
		//e2.setDescription("value");
		//e1.setDescription(new String());
		
		
		e1.getContact().setFirstname("Dav");
	
		if(e1.getContact().getFirstname() == null){
			System.out.println("e1 is null");
		}else
			System.out.println("first name is: " + e1.getContact().getFirstname());
		
		//e1.setId(1);
		e2.setId(4);
		//e1.setDescription("Hi Ho");
		
		Contacts contact = new Contacts();
		e2.setContact(contact);
		//e2.getContact().setFirstname(new String());
		e2.getContact().setFirstname("Hi Hi");

		//Address
		
		List<Addresses> A2 = new ArrayList<Addresses>();
		
		Addresses a1 = new Addresses();
		Addresses a2 = new Addresses();
		Addresses a3 = new Addresses();
		Addresses a4 = new Addresses();
		
		a1.setCountry("abc");
		a2.setCountry("ABC");
		a3.setCountry("def");
		a4.setCountry("DEF");
		 
		A2.add(a1); A2.add(a2); A2.add(a3); A2.add(a4);
		
		e2.getContact().setAddressesList(A2);
		
		//System.out.println(e1.getContact().getFirstname());
		//System.out.println(e2.getContact().getFirstname());
		
		ref.updateObject(e1, e2);
		
		System.out.println("o1 enquiryIssues after update");
		for(Addresses a: e1.getContact().getAddressesList()){
			System.out.println(" country: " + a.getCountry() );
		}
		
	}
	
	private static void existingObject(){
		Contacts one = new Contacts();
		Contacts two = new Contacts();
		
		Integer id = 1;
		
		one.setId(id);
		two.setId(id);
		
		
		System.out.println("Testing objects:");
		System.out.println(one);
		System.out.println(two);
		System.out.println("<<<<<<<<<<<<<<<<<<<");
	
		Contacts c1 = new Contacts();
		Contacts c2 = new Contacts();
		c1.setId(2);
		c2.setId(2);
		c1.setFirstname("Bill");
		c2.setFirstname("Jane");
		c2.setLastname("Carington");
		
		Enquiries o1 = new Enquiries();
		Enquiries o2 = new Enquiries();
		Enquiries s1 = new Enquiries();
		Enquiries s2 = new Enquiries();
		EnquiryTypes t1 = new EnquiryTypes();
		EnquiryTypes t2 = new EnquiryTypes();
		t1.setId(3);
		t2.setId(10);
		s1.setId(5);
		s2.setId(7);
		
		o1.setParentEnquiry(s1);
		o2.setParentEnquiry(s2);
		
		o1.setEnquiryType(t1);
		o2.setEnquiryType(t2);
		
		o1.setContact(c1);
		o2.setContact(c2);
		
		//Address
		List<Addresses> A1 = new ArrayList<Addresses>();
		List<Addresses> A2 = new ArrayList<Addresses>();
		
		Addresses a1 = new Addresses();
		Addresses a2 = new Addresses();
		Addresses a3 = new Addresses();
		Addresses a4 = new Addresses();
		
		a1.setId(9);
		a2.setId(11);
		a3.setId(1);
		a4.setId(23);
		
		A1.add(a1); A1.add(a2); 
		A2.add(a2); A2.add(a3); A2.add(a4);
		
		
		c1.setAddressesList(A1);
		c2.setAddressesList(A2);
		
		
		//employemnts list
		List<ContactEmployments> eml1 = new ArrayList<ContactEmployments>();
		List<ContactEmployments> eml2 = new ArrayList<ContactEmployments>();
		
		ContactEmployments em1 = new ContactEmployments();
		ContactEmployments em2 = new ContactEmployments();
		ContactEmployments em3 = new ContactEmployments();
		
		em1.setId(1);
		em2.setId(4);
		em3.setId(6);
		
		eml1.add(em1);
		eml2.add(em2);
		
		c1.setEmploymentsList(eml1);
		c2.setEmploymentsList(eml2);
		
		ContactTypes ct1 = new ContactTypes();
		ContactTypes ct2 = new ContactTypes();
		ct1.setId(3);
		ct2.setId(4);
		o1.setId(1);
		o2.setId(3);
		c1.setFirstname("kelly");
		c2.setFirstname("Michican");
		c2.setContactType(ct2);
		c1.setContactType(ct1);
	

		
		EnquiryIssues ei1 = new EnquiryIssues();
		EnquiryIssues ei2 = new EnquiryIssues();
		EnquiryIssues ei3 = new EnquiryIssues();
		EnquiryIssues ei4 = new EnquiryIssues();
		EnquiryIssues ei5 = new EnquiryIssues();
		
		ei1.setId(1);
		ei2.setId(2);
		ei3.setId(1);
		ei4.setId(2);
		ei5.setId(5);
		
		ei1.setComment("a");
		ei2.setComment("b");
		ei3.setComment("c");
		ei4.setComment(null);
		ei5.setComment("e");
		
		List<EnquiryIssues> ei1List = new ArrayList<EnquiryIssues>();
		List<EnquiryIssues> ei2List = new ArrayList<EnquiryIssues>();
		
		ei1List.add(ei1);
		ei1List.add(ei2);
		
		ei2List.add(ei3);
		ei2List.add(ei4);
		ei2List.add(ei5);
//		ei2List.add(ei5);
		
		o1.setEnquiryIssuesList(ei1List);
		o2.setEnquiryIssuesList(ei2List);
		
		
		
		//EnquiryList
		List<Enquiries> e1List = new ArrayList<Enquiries>();
		List<Enquiries> e2List = new ArrayList<Enquiries>();
		
		Enquiries le1 = new Enquiries();
		Enquiries le2 = new Enquiries();
		Enquiries le3 = new Enquiries();
		Enquiries le4 = new Enquiries();
		Enquiries le5 = new Enquiries();
		Enquiries le6 = new Enquiries();
		Enquiries le7 = new Enquiries();
		Enquiries le8 = new Enquiries();
		
		le1.setId(1);
		le2.setId(2);
		le3.setId(3);
		le4.setId(4);
		le5.setId(5);
		le6.setId(6);
		le7.setId(7);
		le8.setId(8);
		
		e1List.add(le1);
		e1List.add(le2);
		e1List.add(le3);
		e1List.add(le4);
		e1List.add(le5);
		
		e2List.add(le6);
		e2List.add(le7);
		e2List.add(le8);
		
		o1.setEnquiriesList(e1List);
		o2.setEnquiriesList(e2List);
		
		Reflection ref = new Reflection();
		ref.updateObject(c1, c2);
//		System.out.println("name: Contact " +  o1.getContact().getFirstname());
		System.out.println("o1 enquiryIssues after update");
		for(EnquiryIssues e: o1.getEnquiryIssuesList()){
			System.out.println(e.getId());
			System.out.println(e.getComment());
		}
	}
}
