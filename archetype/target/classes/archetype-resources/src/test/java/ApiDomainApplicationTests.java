#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.ApiDomainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiDomainApplication.class)
public class ApiDomainApplicationTests {

	@Test
	public void contextLoads() {
	}

}
