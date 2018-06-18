package stdemo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.std.controller.DepartmentsContoller;



@RunWith(SpringJUnit4ClassRunner.class)   
@WebAppConfiguration(value = "WebContent")   
@ContextConfiguration({"classpath:spring.xml", "classpath:spring-mybatis.xml" ,"classpath:springmvc-servlet.xml" })    
public class DepartmentController {
	
	@Autowired      
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  
    @Autowired  
    ServletContext context;  
    
    private DepartmentsContoller departmentsContoller;
    
    
    public DepartmentsContoller getDepartmentsContoller() {
		return departmentsContoller;
	}

    @Autowired
	public void setDepartmentsContoller(DepartmentsContoller departmentsContoller) {
		this.departmentsContoller = departmentsContoller;
	}

	@Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.standaloneSetup(departmentsContoller).build() ;  
    }  
	
	@Test
	public void run() throws Exception{
		assertNotNull(mockMvc); 
		System.out.println("这里输出结果");
		mockMvc.perform(MockMvcRequestBuilders.post("/selectDepartmentsByExample")
				.param("page", "1")
				.param("pagesize", "5")
				.param("name", "产品部")
				.param("code", "")
				).andDo(print());
	}
	
	@Test
	public void d() throws Exception{
		assertNotNull(mockMvc); 
		System.out.println("这里输出结果");
		mockMvc.perform(MockMvcRequestBuilders.post("/selectDepartmentsByExample")
				.param("page", "1")
				.param("pagesize", "5")
				.param("name", "产品部")
				.param("code", "")
				).andDo(print());
	}
	
	@Test
	public void ts() throws Exception{
		assertNotNull(mockMvc);
		mockMvc.perform(MockMvcRequestBuilders.post("/selectDepartmentsByPrimaryKey")
				.param("id", "1")
				).andDo(print());
	}
	
	@Test
	public void testselectDepartmentsByPrimaryKey() throws Exception{
		assertNotNull(mockMvc);
		mockMvc.perform(MockMvcRequestBuilders.post("/selectDepartmentsByPrimaryKey")
				.param("id", "1")
				).andDo(print());
	}
	
	@Test
	public void test() {
		
	}

}
