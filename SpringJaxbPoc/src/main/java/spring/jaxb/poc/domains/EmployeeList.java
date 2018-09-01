package spring.jaxb.poc.domains;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EMP_LIST")

public class EmployeeList {

	@Override
	public String toString() {
		return "EmployeeList [empList=" + empList + "]";
	}

	List <Employee>  empList=new ArrayList<Employee>();

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}


}
