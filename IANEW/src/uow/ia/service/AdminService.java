/**
 * 
 */
package uow.ia.service;

import java.io.Serializable;
import java.util.List;

import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Users;

/**
 * @author ZhiYu Yang
 * @date 23/08/2014
 *
 */
public interface AdminService {

	public static final String SERVICENAME = "AdminService";
	
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
     * @return List<Object>
     */
	public boolean saveDisabilityType(DisabilityTypes d);
	
	/** 
     * delete Disability Types object to Disability_Types table
     * 
     * @param DisabilityTypes d
     * @return List<Object>
     */
	public boolean deleteDisabilityType(DisabilityTypes d);
	
	/** 
     * update Disability Types object to Disability_Types table
     * 
     * @param DisabilityTypes d
     * @return List<Object>
     */
	public boolean updateDisabilityType(DisabilityTypes d);
	
	public Users login(String username, String password);
}
