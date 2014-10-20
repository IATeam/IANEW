/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uow.ia.bean.UserRoles;
import uow.ia.bean.Users;
import uow.ia.dao.UserRolesDao;
import uow.ia.dao.UsersDao;
import uow.ia.service.MyUserDetails;

/**
 * @author ZhiYu Yang
 * @date 18/10/2014
 * 
 */
@Service(MyUserDetails.SERVICENAME)
public class MyUserDetailsServiceImpl implements MyUserDetails {

	@Autowired
	private UsersDao<Users> usersDao;

	@Autowired
	private UserRolesDao<UserRoles> userRolesDao;

	/**
	 * 
	 */
	public MyUserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users users= usersDao.get(" from Users where username=?", new Object[] {userName} );
		System.out.println("username is: " + userName);
		UserRoles userRoles = null;
		if(users!=null) {
			userRoles = userRolesDao.get(" from UserRoles where userId=?", new Object[] {users.getId()});
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		if(userRoles!=null) {
			return new User(users.getUsername(),
							users.getPassword(),
							enabled,
							accountNonExpired,
							credentialsNonExpired,
							accountNonLocked,
							getAuthorities(userRoles.getRoleId().intValue())
							);
		} else {
			return null;
		}
		
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		System.out.println("authList----------->" + authList);
		return authList;
	}

	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_ADMIN");
		}
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			System.out.println("role----------->" + role);
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
