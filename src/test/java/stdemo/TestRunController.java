package stdemo;

import static org.junit.Assert.assertNotNull;

import javax.servlet.ServletContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.junit.Test;

import com.std.controller.RoleController;
import com.std.controller.TestController;



@RunWith(SpringJUnit4ClassRunner.class)   
@WebAppConfiguration(value = "WebContent")   
@ContextConfiguration({"classpath:spring.xml", "classpath:spring-mybatis.xml" ,"classpath:springmvc-servlet.xml" })    
//@ContextConfiguration("file:src/main/resources/applicationContext.xml")


public class TestRunController {  
    @Autowired      
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  

    @Autowired  
    ServletContext context;  
      
    @Before  
    public void setUp() {  
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
        mockMvc = MockMvcBuilders.standaloneSetup(roleController).build() ;  
    }  
   
    @Test  
    public void test() throws Exception {  
        assertNotNull(mockMvc);  
        mockMvc.perform( MockMvcRequestBuilders.get("index") )  
                        .andReturn()  ;    
   
    }  
      
    @Test  
    public void testB() throws Exception {  
        assertNotNull(mockMvc);  
        mockMvc.perform( MockMvcRequestBuilders.post("/test/testB.action" ).content("aaa") )  
                        .andReturn()  ;    
    }  
    
    @Test
    public void d() throws Exception{
    	assertNotNull(mockMvc);
    	mockMvc.perform(MockMvcRequestBuilders.get("update")).andDo(print());
    	
    }
    
    @Test
    public void no() throws Exception{
    	System.out.println("≈–∂œmvc   «∑ÒŒ™ø’÷µ ");
    	assertNotNull(mockMvc);
    	mockMvc.perform(MockMvcRequestBuilders.post("/getRoles").param("page", "1").param("pagesize", "5")).andDo(print());
    }
    
    
    @Test
    public void tes() {
    	System.out.println("≤‚ ‘test");
    }
    
    private RoleController roleController;

	public RoleController getRoleController() {
		return roleController;
	}
	
	@Autowired
	public void setRoleController(RoleController roleController) {
		this.roleController = roleController;
	}
    
    
}  