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
	public DangerTypes getDangerTypeId(String name);
	
	public StatusTypes getStatusTypeId(String name);
	
	public TitleTypes getTitleTypeId(String name);
	
	public GenderTypes getGenderTypeId(String name);
	
	public CulturalBackgroundTypes getCulturalBackgroundTypeId(String name);
	
	public AccommodationTypes getAccommodationTypeId(String name);
	
	public DisabilityTypes getDisabilityTypeId(String name);
	
	public IssueTypes getIssueTypeId(String name);
	
	public EnquiryTypes getEnquiryTypeId(String name);
	
	public EmploymentTypes getEmploymentTypeId(String name);

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
