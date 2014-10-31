package com.gurdeep.oxm.bean;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.NONE)
public class Employees{
	
    @XmlElement(name="employee")
    private Collection<Employee> employees;
    public Collection<Employee> getUsers() {
        return employees;
    }
    public void setUsers(Collection<Employee> users) {
        this.employees = users;
    }
}