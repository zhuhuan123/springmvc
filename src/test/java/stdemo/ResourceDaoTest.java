package stdemo;
import java.util.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.std.model.Resource;
import com.std.model.ResourceExample;
import com.std.model.ResourceExample.Criteria;
import com.std.service.ResourceService;
import static java.lang.Math.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class ResourceDaoTest {

	private ResourceService resourceService;
	
	
	public ResourceService getResourceService() {
		return resourceService;
	}

	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@Test
	public void test() {
		ResourceExample resourceExample = new ResourceExample();
		Criteria cr = resourceExample.createCriteria();
		cr.andNameLike("%管理");
		cr.andNameLike("用户%");
//		resourceService.countByExample(resourceExample);
		List<Resource> list = resourceService.selectByExample(resourceExample);
		
		for(Resource r:list) {
			System.out.println(r);
		}
	}
	
	@Test
	public void res (){
		List<Resource> res = resourceService.selectByExample(null);
		for(Resource r:res) {
			System.out.println("查询得到的资源信息为  "+r);
		}
	}
	

	@Test
	public void t() {
		System.out.println(PI);
	}
}
