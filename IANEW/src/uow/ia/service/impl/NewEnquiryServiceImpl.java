/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uow.ia.bean.*;
import uow.ia.dao.*;
import uow.ia.service.NewEnquiryService;

/**
 * @author bruce
 *
 */
@Service(NewEnquiryService.SERVICENAME)
public class NewEnquiryServiceImpl implements
		NewEnquiryService {
	
	@Resource
    private TitleTypesDao<TitleTypes> titleTypesDao;
	
	@Resource
	private GenderTypesDao<GenderTypes> genderTypesDao;
	
	@Resource
	private CulturalBackgroundTypesDao<CulturalBackgroundTypes> culturalBackgroundTypesDao;
	
	@Resource
    private AccommodationTypesDao<AccommodationTypes> accommodationTypesDao;
	
	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;
	
	@Resource
	private IssueTypesDao<IssueTypes> issueTypesDao;
	
	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		return accommodationTypesDao.find(" from AccommodationTypes");
	}

	@Override
	public List<TitleTypes> findTitleTypes() {
		return titleTypesDao.find(" from TitleTypes");
	}

	@Override
	public List<GenderTypes> findGenderTypes() {
		return genderTypesDao.find(" from GenderTypes");
	}

	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return culturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}

	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}

	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}

}
