/**
 * 
 */
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
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;

/**
 * @author ZhiYu Yang
 * @date 23/08/2014
 *   @author davidforbes
     *  @date 09/09/2014
 *
 */
public interface AdminService {

	public static final String SERVICENAME = "AdminService";

	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Accommodation Type ServiceMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */
	/** 
     * retrieve with List<object> of Accommodation Types from Accommodation_Types table
     * @return List<Object>
     */
	public List<AccommodationTypes> findAccommodationTypes();
	
	/** 
     * save Accommodation Types object to Accommodation_Types table
     * 
     * @param AccommodationTypes a
     * @return boolean
     */
	public boolean saveAccommodationType(AccommodationTypes a);
	
	/** 
     * update Accommodation Types object to Accommodation_Types table
     * @param AccommodationTypes a
     * @return boolean
     */
	public boolean updateAccommodationType(AccommodationTypes a);
	
	 /* ----------------------------------------------------------------------------------------------------------
		 * CulturalBackground Type ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
	
	/** 
     * retrieve with List<object> of Cultural Background Types from CulturalBackground_Types table
     * @return List<Object>
     */
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	/** 
     * save Cultural Background  Types object to CulturalBackground_Types table
     * 
     * @param CulturalBackgroundTypes cbt
     * @return boolean
     */
	public boolean saveCulturalBackgroundType(CulturalBackgroundTypes cbt);
	
	/** 
     * update Cultural Background  Types object to CulturalBackground_Types table
     * @param CulturalBackgroundTypes cbt
     * @return boolean
     */
	public boolean updateCulturalBackgroundType(CulturalBackgroundTypes cbt);
	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Danger Type Type ServiceMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */
	/** 
     * retrieve with List<object> of Danger Type from Danger_Types table
     * @return List<Object>
     */
	public List<DangerTypes> findDangerTypes();
	
	/** 
     * save Danger Types object to Danger_Types table
     * 
     * @param DangerTypes dt
     * @return boolean
     */
	public boolean saveDangerType(DangerTypes dt);
	
	/** 
     * update DangerTypes object to Danger_Types table
     * @param DangerTypes dt
     * @return boolean
     */
	public boolean updateDangerType(DangerTypes dt);
	
	 /* ----------------------------------------------------------------------------------------------------------
		 * EmploymentType ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Employment Type from Employment_Types table
	     * @return List<Object>
	     */
		public List<EmploymentTypes> findEmploymentTypes();
		
		/** 
	     * save Employment Types object to Employment_Types table
	     * 
	     * @param EmploymentType et
	     * @return boolean
	     */
		public boolean saveEmploymentType(EmploymentTypes et);
		
		/** 
	     * update EmploymentType object to Employment_Types table
	     * @param EmploymentTypes et
	     * @return boolean
	     */
		public boolean updateEmploymentType(EmploymentTypes et);
		
		/* ----------------------------------------------------------------------------------------------------------
		 * EnquiryType ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Enquiry Type from Enquiry_Type table
	     * @return List<Object>
	     */
		public List<EnquiryTypes> findEnquiryTypes();
		
		/** 
	     * save Enquiry Types object to Enquiry_Types table
	     * 
	     * @param EnquiryType enqt
	     * @return boolean
	     */
		public boolean saveEnquiryType(EnquiryTypes enqt);
		
		
		/** 
	     * update EnquiryType object to Enquiry_Types table
	     * @param EnquiryTypes enqt
	     * @return boolean
	     */
		public boolean updateEnquiryType(EnquiryTypes enqt);
		
		/* ----------------------------------------------------------------------------------------------------------
		 * GenderType ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Gender Type from Gender_Type table
	     * @return List<Object>
	     */
		public List<GenderTypes> findGenderTypes();
		
		/** 
	     * save Gender Types object to Gender_Types table
	     * 
	     * @param GenderType gt
	     * @return boolean
	     */
		public boolean saveGenderType(GenderTypes gt);
		
		/** 
	     * update GenderType object to Gender_Types table
	     * @param GenderTypes gt
	     * @return boolean
	     */
		public boolean updateGenderType(GenderTypes gt);
		
		/* ----------------------------------------------------------------------------------------------------------
		 * StatusType ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Status Type from Status_Type table
	     * @return List<Object>
	     */
		public List<StatusTypes> findStatusTypes();
		
		/** 
	     * save Status Types object to Status_Types table
	     * 
	     * @param StatusType st
	     * @return boolean
	     */
		public boolean saveStatusType(StatusTypes st);
		
		/** 
	     * update StatusType object to Status_Types table
	     *  @author davidforbes
	     * @return boolean
	     */
		public boolean updateStatusType(StatusTypes st);
		
		/* ----------------------------------------------------------------------------------------------------------
		 * TitleType ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Title Type from Title_Type table
	     * @return List<Object>
	     */
		public List<TitleTypes> findTitleTypes();
		
		/** 
	     * save Title Types object to Title_Types table
	     * 
	     * @param TitleType tt
	     * @return boolean
	     */
		public boolean saveTitleType(TitleTypes tt);
		
		/** 
	     * update TitleType object to Title_Types table
	     * @param TitleTypes tt
	     * @return boolean
	     */
		public boolean updateTitleType(TitleTypes tt);
	
		
	 /* ----------------------------------------------------------------------------------------------------------
		 * Disability Type ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
	*/
	
	/** 
     * retrieve with List<object> of Disability Types from Disability_Types table
     *  
     * @return List<Object>
     */
	public List<DisabilityTypes> findDisabilityTypes();
	
	/** 
     * save Disability Types object to Disability_Types table
     * 
     * @param DisabilityTypes d
     * @return boolean
     */
	public boolean saveDisabilityType(DisabilityTypes d);
	
	/** 
     * update Disability Types object to Disability_Types table
     * @param DisabilityTypes d
     * @return boolean
     */
	public boolean updateDisabilityType(DisabilityTypes d);
	
	/** 
     * Login
     * @param String username, String password
     * @return Users
     */
	public Users login(String username, String password);
	
	/** 
     * getUsers
     * @param String username
     * @return Users
     */
	public Users getUsers(String username);
	 /* ----------------------------------------------------------------------------------------------------------
	 * Issue Type ServiceMethods
	 * ----------------------------------------------------------------------------------------------------------
*/
	/** 
     * retrieve with List<object> of Issue Types from Issue_Types table
     *  
     * @return List<Object>
     */
	public List<IssueTypes> findIssueTypes();
	
	/** 
     * save Issue Types object to Issue_Types table
     * 
     * @param IssueTypes i
     * @return boolean
     */
	public boolean saveIssueType(IssueTypes i);
	
	/** 
     * update Issue Types object to Issue_Types table
     * 
     * @param IssueTypes i
     * @return boolean
     */
	public boolean updateIssueType(IssueTypes i);
	
	
	 /* ----------------------------------------------------------------------------------------------------------
		 * Contacts ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
	*/
		/** 
	     * retrieve with List<Contacts> of Contacts from Contacts table
	     *  
	     * @return List<Contacts>
	     */
		public List<Contacts> findContacts();
		
		/** 
	     * save Contacts object to Contacts table
	     * 
	     * @param Contacts c
	     * @return boolean
	     */
		public boolean saveContact(Contacts c);
		
		
		/** 
	     * update Contacts object to Contacts table
	     * 
	     * @param Contact c
	     * @return boolean
	     */
		public boolean updateContact(Contacts c);
		
		
		
		
		
		 /* ----------------------------------------------------------------------------------------------------------
		 * Communication Type ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Communication Types from Communication_Types table
	     * @return List<Object>
	     */
		public List<CommunicationTypes> findCommunicationTypes();
		
		/** 
	     * save Communication Types object to Communication_Types table
	     * 
	     * @param CommunicationTypes c
	     * @return boolean
	     */
		public boolean saveCommunicationType(CommunicationTypes c);
		
		/** 
	     * update Communication Types object to Communication_Types table
	     * @param CommunicationTypes a
	     * @return boolean
	     */
		public boolean updateCommunicationType(CommunicationTypes c);
		
		 /* ----------------------------------------------------------------------------------------------------------
		 * Goal Type ServiceMethods
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/** 
	     * retrieve with List<object> of Goal Types from Goal_Types table
	     * @return List<Object>
	     */
		public List<GoalTypes> findGoalTypes();
		
		/** 
	     * save Goal Types object to Goal_Types table
	     * 
	     * @param GoalTypes g
	     * @return boolean
	     */
		public boolean saveGoalType(GoalTypes g);
		
		/** 
	     * update Goal Types object to Goal_Types table
	     * @param GoalTypes g
	     * @return boolean
	     */
		public boolean updateGoalType(GoalTypes g);
		
		
		 /* ----------------------------------------------------------------------------------------------------------
			 * Priority Type ServiceMethods
			 * ----------------------------------------------------------------------------------------------------------
			 */
			/** 
		     * retrieve with List<object> of Priority Types from Priority_Types table
		     * @return List<Object>
		     */
			public List<PriorityTypes> findPriorityTypes();
			
			/** 
		     * save Priority Types object to Priority_Types table
		     * 
		     * @param PriorityTypes p
		     * @return boolean
		     */
			public boolean savePriorityType(PriorityTypes p);
			
			/** 
		     * update Priority Types object to Priority_Types table
		     * @param PriorityTypes p
		     * @return boolean
		     */
			public boolean updatePriorityType(PriorityTypes p);
}
