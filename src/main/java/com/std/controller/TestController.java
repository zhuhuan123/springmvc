package com.std.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.std.dao.UserMapper;
import com.std.model.User;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="ge")
	public String ge() {
		System.out.println("ge test  method ");
		return"string ge infomatio";
	}
	
	
	@RequestMapping(value="update")
	@ResponseBody
	public List<String> update(){
		List<String> list = new ArrayList<String>();
		list.add("test");
		list.add("add");
		list.add("update");
		return list;
	}
	
	@RequiresRoles(value="ROLE_USER")
	@ResponseBody
	@RequestMapping(value="showstu")
	public String showstu() {
		return "showstu";
	}
	

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@ResponseBody
	@RequestMapping(value="getSql")
	public List<User> getSql() {
		String res = "res";
		System.out.println(res);
		List<User> users = userMapper.findByUser();
//		String res = sqlSessionFactory.toString();
		System.out.println("得到的连接为  "+res);
		return users;
	}
	
	@RequestMapping(value="geModelAndView")
	public ModelAndView ge(ModelAndView model) {
		ModelAndView mode = new ModelAndView();
		mode.addObject("user", "朱焕雄");
		mode.addObject("age", "12");
//		model.
		mode.setViewName("modl");
		return mode;
	}
	
	@RequestMapping(value="index")
	public String jsresult(HttpServletRequest request) {
//		request.setAttribute("name", "zhuhuanxiong");
		return "index";
	}
	@RequestMapping(value="home")
	public String home(HttpServletRequest request) {
//		request.setAttribute("name", "zhuhuanxiong");
		return "NewFile";
	}
	@RequestMapping(value="fileUploadtoPage")
	public String fileUploadtoPage(HttpServletRequest request)throws RuntimeException {
//		request.setAttribute("name", "zhuhuanxiong");
//		if(id==1) {
//			throw new RuntimeException("exception message");
//		}
		return "FileUpload";
	}
	/**文件上传
	 * @param request
	 * @param upfile
	 * @return
	 */
	@RequestMapping(value="fileUpload")
	public String fileUpload(HttpServletRequest request,@RequestParam("upfile") MultipartFile [] upfile) {
		for(MultipartFile fe:upfile) {
		try {
			InputStream in = fe.getInputStream();
			File f = new File("e:\\zhx\\file");
			if(!f.exists()) {
				f.mkdirs();
			}
			
			FileOutputStream output = new FileOutputStream(new File("e:\\zhx\\file\\"+fe.getOriginalFilename()));  
			IOUtils.copy(in, output);
//			fe.transferTo(dest);
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return "FileUploadsucces";
	}
	
	@RequestMapping(value="getparam")
	public String param(@RequestParam("name") String name,Model mo) {
		System.out.println("接受到的参数值为 "+name);
		mo.addAttribute("name", name);   //Model  模型 的使用，将数据传输前端进行使用。
		return "head";
	}
	
	@RequestMapping(value="deleteById")
	public String deleteById(Integer id) {
		return "head";
	}
	
	@RequestMapping(value="test")
	public String test() {
		return "test";
	}
	
	@ResponseBody
	@RequestMapping(value="getresult")
	public ArrayList<Ts> getresult() {
		ArrayList<Ts> ar = new ArrayList<>();
		Ts ts = new Ts();
		ts.setStuAge("201");
		ts.setStuName("df");
		ts.setStuNo("stuNo");
		ts.setStuSex("sdf");
		ar.add(ts);
		return ar;
	}
	
	@RequestMapping(value="fomda")
	public String ge(String Title,String addDate,String Country,String City) {
		System.out.println(Title+" : "+addDate+" : "+Country+" : "+City);
		return "index";
	}
	
	
	
	
	
	/**
	 * @param con
	 * @param request
	 * @return
	 */
	@RequestMapping(value="con")
	public String con(String con,HttpServletRequest request) {
		System.out.println("post  请求得到的值为  "+con);
		try {
			//post  请求
			request.setCharacterEncoding("utf-8");
			String re = request.getParameter("con");
			System.out.println(re);
			//get  请求  需要转换格式
//			byte[] reByte = re.getBytes("iso8859-1");
//			re = new String(reByte,"utf-8");
//			System.out.println(re);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.setAttribute("con", con);
		System.out.println("后端接收参数  "+con);
		return "showedit";
	}
	
	@RequestMapping(value="tree")
	public String tree() {
		return "tree";
	}
	@RequestMapping(value="RoleLi")
	public String roleLi() {
		return "RoleLi";
	}
	
	@RequestMapping(value="gpo")
	public String gpo(String name,MultipartFile filename) throws Exception {
		System.out.println(name);
		System.out.println(filename);
		//原图就是原来的文件。缩列图就是_filename.
		File f= new File("E:\\log\\"+filename.getOriginalFilename());
		InputStream in = filename.getInputStream();
		OutputStream out = new FileOutputStream(f);
		IOUtils.copy(in,out );
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		return "login";
	}
	
	@RequestMapping(value="mymm")
	public String m(ModelMap map) {
		map.put("ag", "12");
		return "mm";
	}
}
