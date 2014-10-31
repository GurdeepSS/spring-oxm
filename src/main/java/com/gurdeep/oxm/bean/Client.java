package com.gurdeep.oxm.bean;

import java.io.FileReader;
import java.io.FileWriter;  
import java.io.IOException;  

import javax.xml.transform.stream.StreamResult;  
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.oxm.Marshaller;  
import org.springframework.oxm.Unmarshaller;
  
public class Client{  
	
	 public static void main(String[] args)throws IOException{
		 
		  ApplicationContext context = new ClassPathXmlApplicationContext("oxm-applicationContext.xml");  
		  Marshaller marshaller = (Marshaller)context.getBean("jaxb2Marshaller");  
		          
		  Employee employee=new Employee();  
		  employee.setId(100);  
		  employee.setName("Gurdeep Singh");  
		  employee.setSalary(10000);  
		          
		  marshaller.marshal(employee, new StreamResult(new FileWriter("C:/employee.xml")));  
		  System.out.println("Marshalling Done- XML Created Sucessfully");

		  Unmarshaller unMarshaller = (Unmarshaller)context.getBean("jaxbMarshallerBean");  
		  Employee emp = (Employee) unMarshaller.unmarshal(new StreamSource(new FileReader("C:/employee.xml")));
		  System.out.println(emp.getName() + ":" + emp.getSalary());
		  System.out.println("UNMarshalling Done.");
	 }  
 }  