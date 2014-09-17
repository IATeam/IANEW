package uow.ia.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import uow.ia.service.AdminService;
import uow.ia.service.NewCaseService;
import uow.ia.service.NewEnquiryService;
import uow.ia.service.UtilService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class BaseAction extends ActionSupport{
	
	@Resource
	protected NewEnquiryService services;
	
	@Resource
	protected NewCaseService caseServices;

	@Resource
	protected AdminService adminService;
	
	@Resource
	protected UtilService utilService;

	/**
	 * @return the utilService
	 */
	public UtilService getUtilService() {
		return utilService;
	}

	/**
	 * @param utilService the utilService to set
	 */
	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}

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
