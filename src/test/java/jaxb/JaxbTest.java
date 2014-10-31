package jaxb;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import com.gurdeep.oxm.bean.Employee;

public class JaxbTest {
	

	 ApplicationContext context;
	 Marshaller marshaller;
	 static Employee employee;
	 
	@BeforeClass
    public  static void setUpClass() throws Exception {
    	//System.out.println("//Code executed before the first test method, one-time initialization code");
		  employee=new Employee();  
		  employee.setId(100);  
		  employee.setName("Gurdeep Singh");  
		  employee.setSalary(10000);  
    }
    @Before
    public void setUp() throws Exception {
    	//System.out.println("//Code executed before each test");
 	    context = new ClassPathXmlApplicationContext("oxm-applicationContext.xml");  
		marshaller = (Marshaller)context.getBean("jaxb2Marshaller");
    }
    @Test
    public void testOneThing() throws Exception {
    	//System.out.println("//Code that tests one thing");
  	    marshaller.marshal(employee, new StreamResult(new FileWriter("C:/employee.xml")));  
    	System.out.println("Marshalling Done- XML Created Sucessfully");
    	
  	    Unmarshaller unMarshaller = (Unmarshaller)context.getBean("jaxbMarshallerBean");
  	    Employee emp = (Employee) unMarshaller.unmarshal(new StreamSource(new FileReader("C:/employee.xml")));
		System.out.println(emp.getName() + ":" + emp.getSalary());
    }
    @After
    public void tearDown() throws Exception {
    	//System.out.println("//Code executed after each test");   
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    	//System.out.println("//Code executed after the last test method"); 
    }

}