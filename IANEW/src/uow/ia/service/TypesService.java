/**
 * 
 */
package uow.ia.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CommunicationTypes;
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
import uow.ia.bean.ReviewFrequencies;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

/**
 * @author ZhiYu Yang
 * @date 17/09/2014
 *
 */
public interface TypesService {
	public static final String SERVICENAME = "TypesService";

	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	public List<DangerTypes> findDangerTypes();
	
	public List<DisabilityTypes> findDisabilityTypes();
	
	public List<EmploymentTypes> findEmploymentTypes();
	
	public List<EnquiryTypes> findEnquiryTypes();
	
	public List<GenderTypes> findGenderTypes();
	
	public List<IssueTypes> findIssueTypes();
	
	public List<StatusTypes> findStatusTypes(int id);
	
	public List<TitleTypes> findTitleTypes();
	
	public List<CommunicationTypes> findCommunicationTypes();
	
	public List<GoalTypes> findGoalTypes();
	
	public List<PriorityTypes> findPriorityTypes();
	
	/*
	 * 
	 */
	public DangerTypes getDangerTypeId(int id);
	
	public StatusTypes getStatusTypeId(int id);
	
	public TitleTypes getTitleTypeId(int id);
	
	public GenderTypes getGenderTypeId(int id);
	
	public CulturalBackgroundTypes getCulturalBackgroundTypeId(int id);
	
	public AccommodationTypes getAccommodationTypeId(int id);
	
	public DisabilityTypes getDisabilityTypeId(int id);
	
	public IssueTypes getIssueTypeId(int id);
	
	public EnquiryTypes getEnquiryTypeId(int id);
	
	public EmploymentTypes getEmploymentTypeId(int id);
	
	public ReviewFrequencies getReviewFrequencyId(Integer id);
	
	public GoalTypes getGoalTypeId(Integer id);
	
	public CommunicationTypes getCommunicationTypeId(Integer id);

	/*
	 *
	 */
	public DangerTypes getDangerTypeByName(String name);
	
	public StatusTypes getStatusTypeByName(String name);
	
	public TitleTypes getTitleTypeByName(String name);
	
	public GenderTypes getGenderTypeByName(String name);
	
	public CulturalBackgroundTypes getCulturalBackgroundTypeByName(String name);
	
	public AccommodationTypes getAccommodationTypeByName(String name);
	
	public DisabilityTypes getDisabilityTypeByName(String name);
	
	public IssueTypes getIssueTypeByName(String name);
	
	public EnquiryTypes getEnquiryTypeByName(String name);
	
	public EmploymentTypes getEmploymentTypeByName(String name);
	
	public List<?> find(String name) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException;
}
