package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
@Indexed
public class EnquiryTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String enquiryTypeName;
	
	private String enquiryTypeDescription;
	
	private List<Enquiries> enquiriesList = new ArrayList<Enquiries>();

	

	/**
	 * 
	 */
	public EnquiryTypes() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param id
	 * @param enquiryTypeName
	 * @param enquiryTypeDescription
	 * @param enquiriesList
	 */
	public EnquiryTypes(Integer id, String enquiryTypeName,
			String enquiryTypeDescription, List<Enquiries> enquiriesList) {
		super();
		this.id = id;
		this.enquiryTypeName = enquiryTypeName;
		this.enquiryTypeDescription = enquiryTypeDescription;
		this.enquiriesList = enquiriesList;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the enquiryTypeName
	 */
	public String getEnquiryTypeName() {
		return this.enquiryTypeName;
	}

	/**
	 * @param enquiryTypeName the enquiryTypeName to set
	 */
	public void setEnquiryTypeName(String enquiryTypeName) {
		this.enquiryTypeName = enquiryTypeName;
	}

	/**
	 * @return the enquiryTypeDescription
	 */
	public String getEnquiryTypeDescription() {
		return this.enquiryTypeDescription;
	}

	/**
	 * @param enquiryTypeDescription the enquiryTypeDescription to set
	 */
	public void setEnquiryTypeDescription(String enquiryTypeDescription) {
		this.enquiryTypeDescription = enquiryTypeDescription;
	}



	/**
	 * @return the enquiriesList
	 */
	public List<Enquiries> getEnquiriesList() {
		return this.enquiriesList;
	}



	/**
	 * @param enquiriesList the enquiriesList to set
	 */
	public void setEnquiriesList(List<Enquiries> enquiriesList) {
		this.enquiriesList = enquiriesList;
	}
}
