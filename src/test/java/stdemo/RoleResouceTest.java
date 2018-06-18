package stdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import com.std.model.Resource;
import com.std.model.ResourceExample;
import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;
import com.std.model.RoleResourceExample.Criteria;
import com.std.service.ResourceService;
import com.std.service.RoleResourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class RoleResouceTest {
	private RoleResourceService roleResourceService;

	public RoleResourceService getRoleResourceService() {
		return roleResourceService;
	}

	@Autowired
	public void setRoleResourceService(RoleResourceService roleResourceService) {
		this.roleResourceService = roleResourceService;
	}
	
	@Test
	public void RoleRes() {
		System.out.println("开始----");
		RoleResourceExample record = new RoleResourceExample();
		Criteria cr = record.createCriteria();
		cr.andRoleIdEqualTo(new Long(1));
		
		System.out.println("得到的值为  "+record);
		List<RoleResource> li = roleResourceService.getRoleResource(record);
		System.out.println("zh ");
		for(RoleResource r:li) {
			System.out.print(r.getRoleId()+" :  "+r.getResourceId());
			Resource res = resourceService.selectByPrimaryKey(r.getResourceId());
			System.out.println(res.getDescription()+" :  "+res.getName());
		}
		System.out.println("结束----");
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
	public void g() {
		ResourceExample resourceExample = new ResourceExample();
		com.std.model.ResourceExample.Criteria cr = resourceExample.createCriteria();
		cr.andNameEqualTo("角色管理");
		List<Resource> res = resourceService.selectByExample(resourceExample);
		for(Resource r:res) {
			System.out.println(r.getUrl()+"  :  "+r.getDescription()+" : "+r.getName());
		}
		
	}
}
