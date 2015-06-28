package junit;


import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Person;
import service.impl.PersonService;

public class PersonServiceImplTest {
	static PersonService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
			service=(PersonService) context.getBean("personServiceImpl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		service.save();
	}

	@Test
	public void testUpdate() {
		service.update(1);
	}

	@Test
	public void testFind() {
		service.find(1);
	}

	@Test
	public void testDelete() {
		service.delete(1);
	}

	@Test
	public void testGetAll() {
		List<Person> list=service.getAll();
		for (Person person:list) {
			System.out.println(person);
		}
		
	}

}
