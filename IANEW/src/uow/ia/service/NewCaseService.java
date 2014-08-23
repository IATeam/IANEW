package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

public interface NewCaseService {
	
	public static final String SERVICENAME = "NewCaseService";
	
	public List<DangerTypes> findDangerTypes();
	
	public List<StatusTypes> findStatusTypes();
	
	public List<TitleTypes> findTitleTypes();
	
	public List<GenderTypes> findGenderTypes();
	
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<DisabilityTypes> findDisabilityTypes();
	
	public List<IssueTypes> findIssueTypes();
	
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
}
