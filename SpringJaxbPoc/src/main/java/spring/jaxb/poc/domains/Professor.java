package spring.jaxb.poc.domains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PROFESSOR")

public class Professor {
	private String professorName;
	  private int age;
	  private double salary;
	  private String professorSubject;
	  public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professor(String professorName, int age, double salary, String professorSubject) {
		super();
		this.professorName = professorName;
		this.age = age;
		this.salary = salary;
		this.professorSubject = professorSubject;
	}
	
		@XmlElement(name="PROF_NAME")

	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	@XmlElement(name="PROF_AGE")

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@XmlElement(name="PROF_SAL")

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@XmlElement(name="PROF_SUB")

	public String getProfessorSubject() {
		return professorSubject;
	}
	public void setProfessorSubject(String professorSubject) {
		this.professorSubject = professorSubject;
	}
	
	
	public String toString()
	{
		return professorName+" "+age+" "+salary+" "+professorSubject;
	}

	  
}
