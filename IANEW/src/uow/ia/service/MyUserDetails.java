/**
 * 
 */
package uow.ia.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ZhiYu Yang
 * @date 18/10/2014
 *
 */
public interface MyUserDetails extends UserDetailsService {
	public static final String SERVICENAME = "MyUserDetails";

}
