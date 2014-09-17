package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

public interface CaseService {
	
	public static final String SERVICENAME = "CaseService";
	
	public List<DangerTypes> findDangerTypes();
	
	public List<StatusTypes> findStatusTypes();
	
	public List<TitleTypes> findTitleTypes();
	
	public List<GenderTypes> findGenderTypes();
	
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<PriorityTypes> findPriorityTypes();
	
	/** 
     * retrieve with List<object> of Disability Types from Disability_Types table
     *  
     * @return List<Object>
     */
	public List<DisabilityTypes> findDisabilityTypes();
	
	public List<IssueTypes> findIssueTypes();
	
	public List<EnquiryTypes> findEnquiryTypes();
	
	public List<EmploymentTypes> findEmploymentTypes();
	
	public List<CommunicationTypes> findCommunicationTypes();
	
	public List<GoalTypes> findGoalTypes();
	
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
}
