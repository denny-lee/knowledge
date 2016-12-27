package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.infosys.knowledge.Application;
import com.infosys.knowledge.dao.TestMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class DemoApplicationTests {

//	private MockMvc mvc;
	
//	@Autowired  
//    private WebApplicationContext webApplicationConnect; 
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void del() {
		mapper.delete();
	}
	
	/*@Before  
    public void setUp() throws JsonProcessingException {  
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }
	
	@Test
	public void contextLoads() throws Exception {
        String uri = "/greeting";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).param("name", "Denny").accept(MediaType.APPLICATION_JSON))
                .andReturn();  
        int status = mvcResult.getResponse().getStatus();  
        String content = mvcResult.getResponse().getContentAsString();  
        System.out.println(content);
  
        Assert.assertTrue("OK, 200", status == 200);
	}*/

}
