package stdemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.std.model.Departments;
import com.std.model.DepartmentsExample;
import com.std.model.Resource;
import com.std.model.ResourceExample;
import com.std.model.ResourceExample.Criteria;
import com.std.model.Role;
import com.std.model.User;
import com.std.model.UserRole;
import com.std.service.DepartmentsService;
import com.std.service.ResourceService;
import com.std.service.RoleService;
import com.std.service.UserRoleService;
import com.std.service.UserService;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class SpringMyBatisTest {
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@Test
	public void tResource() {
		ResourceExample resourceExample = new ResourceExample();
		Criteria cre = resourceExample.createCriteria();
		cre.andDescriptionLike("%����");
		List<Resource> list = resourceService.selectByExample(resourceExample);
		for(Resource r:list) {
			System.out.println("�õ��Ľ����Ϊ   "+r);
		}
	}
	
	@Test
	public void test() {
		System.out.println("j"+userService);
		User user = new User();
		user.setAddress("�㶫����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("�ϻ�");
		userService.insertUser(user);
	}
	@Test
	public void testUsers() {
		System.out.println("j"+userService);
		User user = new User();
		user.setAddress("����");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("��1");
		List<User> list = new ArrayList<User>();
		list.add(user);
		userService.insertlist(list);
	}
	
	@Test
	public void testUpdate() {
		System.out.println("j"+userService);
		User user = new User();
		user.setAddress("����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setId(28);
		user.setUsername("����");
		userService.updateuser(user);
	}
	
	@Test
	public void testSelects() {
		List<User> users = userService.getUsers();
		for(User u:users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testSele() {
		User user = new User();
//		user.setId(1);
//		user.setUsername("upda");
		List<User> users = userService.selectByCondition(user);
//		System.out.println("�õ���������ֵ  "+user);
		for(User u:users) {
			System.out.println(u);
		}
	}
	
	private ResourceService resourceService;
	
	
	public ResourceService getResourceService() {
		return resourceService;
	}

	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Test
	public void testloadRe() {
//		List<Resource> res = resourceService.getResoueces(new Long(2));
//		for(Resource r:res) {
//			System.out.println(r.getDescription()+" "+r.getUrl());
//		}
		User us = new User();
		us.setUsername("upda");
		List<User> users = userService.selectByCondition(us);
		for(User u:users) {
			System.out.println(u);
		}
	}

	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Test
	public void loadRoles() {
		List<Role> rols = roleService.selectByExample(null);
		System.out.println("here ִ��");
		for(Role r:rols) {
			System.out.println(r);
		}
	}
	
	
	@Test
	public void loadResources() {
		List<Resource> resources = resourceService.selectByExample(null);
		for(Resource r:resources) {
			System.out.println(" ÿ��ֵΪ  "+r);
		}
	}
	
	private DepartmentsService departmentsService;
	
	
	public DepartmentsService getDepartmentsService() {
		return departmentsService;
	}

	@Autowired
	public void setDepartmentsService(DepartmentsService departmentsService) {
		this.departmentsService = departmentsService;
	}

	@Test
	public void tesLoad() {
		List<Departments> departments = departmentsService.selectByExample(null);
		for(Departments departments2:departments) {
			System.out.println("��������  "+departments2.getName()+"  ���ű��� "+departments2.getCode());
		}
	}
	
	private UserRoleService userRoleService;
	
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}
	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	@Test
	public void t() {
		List<UserRole> users = userRoleService.selectByUserId(new Long(22));
		for(UserRole u:users) {
			System.out.println(u.getRoleId()+"  �û���ϢΪ  "+u);
		}
	}
	
	
	@Test
	public void getDepartments() {
		DepartmentsExample example1 = new DepartmentsExample();
		com.std.model.DepartmentsExample.Criteria cre = example1.createCriteria();
		cre.andNameEqualTo("��Ʒ��");
		cre.andCodeEqualTo("185");
		List<Departments> des = departmentsService.selectByExample(example1);
		System.out.println("��ѯ�����Ľ��");
		for(Departments d:des) {
			System.out.println("name  "+d.getName()+" : code  "+d.getCode()+"  id  "+d.getId() );
		}
	}
}
