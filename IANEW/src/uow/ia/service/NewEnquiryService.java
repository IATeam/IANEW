package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.TitleTypes;

public interface NewEnquiryService {
	
	public static final String SERVICENAME = "NewEnquiryService";
	
	public List<TitleTypes> findTitleTypes();
	
	public List<GenderTypes> findGenderTypes();
	
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<DisabilityTypes> findDisabilityTypes();
	
	public List<IssueTypes> findIssueTypes();
}
