package uow.ia.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import uow.ia.service.AdminService;
import uow.ia.service.NewCaseService;
import uow.ia.service.NewEnquiryService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class BaseAction extends ActionSupport{
	
	protected final String ENQUIRY = "enquiry";
	protected final String CONTACT = "contact";
	protected final String ADMIN = "adimin";
	protected final String USER = "user";
	
	@Resource
	protected NewEnquiryService services;
	
	@Resource
	protected NewCaseService caseServices;

	@Resource
	protected AdminService adminService;

	public NewCaseService getCaseServices() {
		return caseServices;
	}

	public void setCaseServices(NewCaseService caseServices) {
		this.caseServices = caseServices;
	}

	public NewEnquiryService getServices() {
		return services;
	}

	public void setServices(NewEnquiryService services) {
		this.services = services;
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
