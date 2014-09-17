package uow.ia.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import uow.ia.service.AdminService;
import uow.ia.service.ContactService;
import uow.ia.service.CaseService;
import uow.ia.service.EnquiryService;
import uow.ia.service.TypesService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class BaseAction extends ActionSupport{
	
	protected final String ENQUIRY = "enquiry";
	protected final String CONTACT = "contact";
	protected final String ADMIN = "adimin";
	protected final String USER = "user";
	
	@Resource
	protected TypesService typesService;
	
	@Resource
	protected ContactService contactService;
	
	@Resource
	protected EnquiryService enquiryService;
	
	@Resource
	protected CaseService caseServices;

	@Resource
	protected AdminService adminService;

	public CaseService getCaseServices() {
		return caseServices;
	}

	public void setCaseServices(CaseService caseServices) {
		this.caseServices = caseServices;
	}

	public EnquiryService getServices() {
		return enquiryService;
	}

	public void setServices(EnquiryService services) {
		this.enquiryService = services;
	}
	
	protected String redirectUrl;
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	public String redirect(String to) {
		redirectUrl = to;
		return "redirect";
	}
	
}
