package uow.ia.service;

import java.util.List;

import uow.ia.bean.Contacts;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.ReviewFrequencies;

public interface CaseService {
	
	public static final String SERVICENAME = "CaseService";
	
	public List<IndividualCases> findCases();
	
	/** 
     * retrieve with List<object> 
     *  
     * @param pageNo 
     * @param rows
     * @return List<Object>
     */
	public List<IndividualCases> findCasesByPage(int pageNo, int rows);

	public Long countCases();

	public IndividualCases getCase(int id);
	
	public List<Contacts> findAdvocates();
	
	public List<ReviewFrequencies> findReviewFrequencies();
	
	public boolean saveOrUpdateCase(IndividualCases ic, Contacts c);
	
	public boolean saveCase(IndividualCases ic);
	
	public boolean deleteCase(IndividualCases ic);
	
	public boolean updateCase(IndividualCases ic);
	
	public IndividualCases mergeCase(IndividualCases ic);
	
	public boolean saveOrUpdateCase(IndividualCases ic);
}
