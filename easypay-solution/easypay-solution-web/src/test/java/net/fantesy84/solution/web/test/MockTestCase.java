/**
 * Project: easypay-solution-web
 * Created: 2016年6月15日
 * ©gopay.com Inc.
 */
package net.fantesy84.solution.web.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Description:
 * <P>
 * @author junjie.ge
 * @since JDK1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-servlet.xml","file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class MockTestCase {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void init(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/**
	 * @return the mockMvc
	 */
	protected MockMvc getMockMvc() {
		return mockMvc;
	}

	/**
	 * @param mockMvc the mockMvc to set
	 */
	protected void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
	
}
