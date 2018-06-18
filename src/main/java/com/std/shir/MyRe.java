package com.std.shir;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.service.UserService;

@Component
public class MyRe extends AuthorizingRealm {

	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//登录的时候执行这里
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken sy = (UsernamePasswordToken) token;
		String username = (String)token.getPrincipal();
		String pass = new String((char[])token.getCredentials());
		System.out.println(sy);
		String password = userService.findByLoginName(username);
//		String password = userService.findByLoginName(username);
		if(pass.equals(password)) {
			SimpleAuthenticationInfo sim = new SimpleAuthenticationInfo(username,password,username);
//			sim.s
//			sim.
			System.out.println("sy");
			return sim;
		}else {
			System.out.println("密码不对");
			return null;
		}
		
		
	}
	
	//认证的时候执行这里  授权，那个人具有哪些权限。
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行这里吗");
		String usen = (String) principals.getPrimaryPrincipal();
		
		 String username = (String) getAvailablePrincipal(principals);
		
		System.out.println("这是主要的东西  "+usen+"   后面得到的东西为  "+username);
		SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
		simpleAuthenticationInfo.addRole("ROLE_USER");
//		simpleAuthenticationInfo.addStringPermission("");
		return simpleAuthenticationInfo;
		
	}
	

}
