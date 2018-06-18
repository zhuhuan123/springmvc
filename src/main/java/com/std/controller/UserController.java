package com.std.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.std.VO.UserVO;
import com.std.model.Departments;
import com.std.model.User;
import com.std.service.DepartmentsService;
import com.std.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@ResponseBody
	@RequestMapping(value="usersmap")
	public Map<String,Object> map(){
		HashMap<String,Object> hashMap = new HashMap<>();
		List<User> users = userService.getUsers();
		hashMap.put("Rows",users );
		hashMap.put("Total", users.size());
		return hashMap;
	}
	
	@ResponseBody
	@RequestMapping(value="users")
	public List<User> users(){
		List<User> users = userService.getUsers();
		return users;
	}
	@ResponseBody
	@RequestMapping(value="findByUserId")
	public User findByUserId(Integer id) {
		return userService.findByUserId(id);
	}
	//http://localhost:8080/stdemo2/insertUser?username=老王&sex=2&address=广东广州&birthday=1991-01-02
	@RequestMapping(value="insertUser")
	public String insertUser(User user) {
		System.out.println(user.getAddress()+" "+user.getSex());
		userService.insertUser(user);
		return "index";
	}
		
	
	@RequestMapping(value="updateuser")
	public String updateuser(User user,HttpServletRequest request) {
		request.setAttribute("name", "zhuhuanxiong");
		return "result";
	}
	
	@RequestMapping(value="showUsers")
	public ModelAndView showUsers(ModelAndView model) {
		List<User> users = userService.getUsers();
		model.addObject("users",users);
		model.setViewName("showUsers");
		return model;
	}
	@RequestMapping(value="updateUserToPage")
	public String updateUserToPage(Integer id,HttpServletRequest request) {
		User user = userService.findByUserId(id);
		List<Departments> list = departmentsService.selectByExample(null);
		request.setAttribute("list", list);
		System.out.println("用户所在的部门   "+user.getDep_id());
		if(user==null) {
			throw new RuntimeException("查找的用户不存在");
		}
		request.setAttribute("user", user);
		return "update";
	}
	@RequestMapping(value="updateUser")
	public String updateUser(User user) {
		userService.updateuser(user);
		return "forward:userUI";
	}
	private DepartmentsService departmentsService;
	
	public DepartmentsService getDepartmentsService() {
		return departmentsService;
	}
	@Autowired
	public void setDepartmentsService(DepartmentsService departmentsService) {
		this.departmentsService = departmentsService;
	}

	@RequestMapping(value="addUsertopage")
	public String addUsertopage(HttpServletRequest request) {
		List<Departments> list = departmentsService.selectByExample(null);
		request.setAttribute("list", list);
		return "add";
	}
	
	/**日期格式的转换
	 * @param binder
	 */
	@InitBinder  
	protected  void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}  
	@RequestMapping(value="addUser")
	public String addUser(User user) {
		System.out.println(user.getDep_id());
		userService.insertUser(user);
		return "registersuccess";
	}
	@ResponseBody
	@RequestMapping(value="addUserAjax")
	public HashMap<String,Object> addUserAjax(User user) {
		System.out.println(user.getDep_id());
		HashMap<String,Object> hashMap = new HashMap<>();
		userService.insertUser(user);
		hashMap.put("code", 200);
		hashMap.put("msg", "新增用户");
		
		return hashMap;
	}
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(Integer id) {
		userService.deleteUser(id);
		return "forward:userUI";
	}
	
	@RequestMapping(value="userUI")
	public String result() {
		return "userUI";
	}
	
	@ResponseBody
	@RequestMapping(value="selectByCondition")
	public Map<String,Object> selectByCondition(Integer page,Integer pagesize,User user){
		System.out.println(page+" : "+pagesize+" : "+user);
		HashMap<String,Object> hashMap = new HashMap<>();
		List<User> users = userService.selectByCondition(user);
		hashMap.put("Rows",users );
		hashMap.put("Total", users.size());
		return hashMap;
	}
	@ResponseBody
	@RequestMapping(value="selectByConditionPage")
	public Map<String,Object> selectByConditionPage(Integer page,Integer pagesize,User user){
//		User u = page.getUser();   //取得的结果值为 null
//		System.out.println(u);
		System.out.println(page+" : "+pagesize+" : "+user);
		HashMap<String,Object> hashMap = new HashMap<>();
		
		if(page==null) {
			page = 0;
		}else {
			page = page-1;
		}
		page = page*pagesize;
		
		hashMap.put("page", page);
		hashMap.put("pagesize", pagesize);
		hashMap.put("user", user);
		Integer total = userService.selectCountByConditionPage(user);
		List<User> users = userService.selectByConditionPage(hashMap);
		HashMap<String,Object> resulthashMap = new HashMap<>();
		resulthashMap.put("Rows",users );
		resulthashMap.put("Total", total);
		return resulthashMap;
	}
	
	@ResponseBody
	@RequestMapping(value="selectByPager")
	public Map<String,Object> selectByPager(Integer page,Integer pagesize,User user){
		System.out.println(page+" : "+pagesize+" : "+user);
		HashMap<String,Object> hashMap = new HashMap<>();
		
//		if(page==null) {
//			page = 0;
//		}else {
//			page = page-1;
//		}
//		page = page*pagesize;
		Integer total = userService.selectCountByConditionPage(user);
		PageHelper.startPage(page, pagesize);
		HashMap<String,Object> resulthashMap = new HashMap<>();
		List<User> users = userService.selectByCondition(user);
		resulthashMap.put("Rows",users );
		resulthashMap.put("Total", total);
		return resulthashMap;
	}
	
	@ResponseBody
	@RequestMapping(value="getBySessionId")
	public String getById(HttpServletRequest request) {
		UserVO userVO = (UserVO)request.getSession().getAttribute("username");
		Long r = userVO.getId();
		return ""+r;
	}
}
