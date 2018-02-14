package com.prs.aop.springaop;

import com.prs.aop.springaop.dto.EmployeeDTO;
import com.prs.aop.springaop.service.EmployeeManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {
	@Autowired
	private EmployeeManager em;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testAop(){
		em.createEmployee(new EmployeeDTO());
		em.deleteEmployee(1);
		em.getAllEmployee();
		em.getEmployeeById(1);
		em.updateEmployee(new EmployeeDTO());
	}

}
