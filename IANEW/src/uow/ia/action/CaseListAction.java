package uow.ia.action;

import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.Contacts;
import uow.ia.bean.IndividualCases;

import com.opensymphony.xwork2.ModelDriven;

public class CaseListAction extends BaseAction implements ModelDriven<List<IndividualCases>>{

	private List<IndividualCases> caseList;
	private String formTitle;
	int page;
	int numberOfRecords;
	long totalNumberOfRecords;
	long totalNumberOfPages;
	private Contacts contact;

	/**
	 * @return the contact
	 */
	public Contacts getContact() {
		return contact;
	}


	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}


	/**
	 * @author Matt
	 * @return
	 */
	public String getCaseList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setCaseList(caseServices.findCasesByPage(page,numberOfRecords));
		totalNumberOfRecords = caseServices.countCases();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod!= 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		System.out.println(totalNumberOfPages);
		return SUCCESS;
	}
	
	
	/**
	 * Action Method for updating the case list after requesting a different page
	 * @return
	 */
	public String updateCaseList(){
		caseList = caseServices.findCasesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = caseServices.countCases();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
		return SUCCESS;
	}
	
	/**
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * @param formTitle the formTitle to set
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the numberOfRecords
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	/**
	 * @param numberOfRecords the numberOfRecords to set
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	/**
	 * @return the totalNumberOfRecords
	 */
	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}

	/**
	 * @param totalNumberOfRecords the totalNumberOfRecords to set
	 */
	public void setTotalNumberOfRecords(long totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}

	/**
	 * @return the totalNumberOfPages
	 */
	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	/**
	 * @param totalNumberOfPages the totalNumberOfPages to set
	 */
	public void setTotalNumberOfPages(long totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}


	/**
	 * @param caseList the caseList to set
	 */
	public void setCaseList(List<IndividualCases> caseList) {
		this.caseList = caseList;
	}


	@Override
	public List<IndividualCases> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
