package spring.jaxb.poc.domains;


import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="employee")
public class Employee {

    private String name;
    private int age;
    private double salary;
 
    public Employee() {
    }
 
    public Employee(String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    @XmlElement(name="EMP_NAME")

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="EMP_AGE")

    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
    @XmlElement(name="EMP_SAL")

    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
 
    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
                + "]";
    }
 
}