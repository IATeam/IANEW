package uow.ia.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import uow.ia.service.NewEnquiryService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class BaseAction extends ActionSupport{
	
	@Resource
	protected NewEnquiryService services;

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
