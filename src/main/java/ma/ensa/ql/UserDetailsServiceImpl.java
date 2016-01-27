package ma.ensa.ql;

import java.util.ArrayList;
import java.util.Collection;

import ma.ensa.dao.Dao;
import ma.ensa.dao.Idao;
import ma.ensa.model.Roles;
import ma.ensa.model.User;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService
{
	private Idao dao;
	private User user;
	@Autowired
	public void setDao(Idao dao)
	{
		this.dao = dao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException 
	{
		user=dao.getUserByLogin(login);
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		System.out.println(user.getRoleses());
		for (Roles role: user.getRoleses()) 
		{
			authorities.add(new GrantedAuthorityImpl(role.getRole()));
		}
		org.springframework.security.core.userdetails.User userDetails =new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPwd(), user.isActive(), user.isActive(), user.isActive(), user.isActive(), authorities);
		return userDetails;
	}
	public User getUser() 
	{
		return user;
	}

	
		
}
