package uow.ia.action;

import java.util.List;

import uow.ia.bean.IndividualCases;

import com.opensymphony.xwork2.ModelDriven;

public class CaseListAction extends BaseAction implements ModelDriven<List<IndividualCases>>{

	private List<IndividualCases> model;
	private String formTitle;
	int page;
	int numberOfRecords;
	long totalNumberOfRecords;
	long totalNumberOfPages;

	/**
	 * @author Matt
	 * @return
	 */
	public String getCaseList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setModel(caseServices.findCasesByPage(page,numberOfRecords));
		totalNumberOfRecords = caseServices.countCases();
		
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		
		if (mod != 0)
			mod = 1;
		
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		
		return SUCCESS;
	}
	
	/**
	 * Action Method for updating the case list after requesting a different page
	 * @return
	 */
	
	public String updateCaseList(){
		model = caseServices.findCasesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = caseServices.countCases();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if(mod != 0) mod = 1;
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
	 * @param model the model to set
	 */
	public void setModel(List<IndividualCases> model) {
		this.model = model;
	}

	
	@Override
	public List<IndividualCases> getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
