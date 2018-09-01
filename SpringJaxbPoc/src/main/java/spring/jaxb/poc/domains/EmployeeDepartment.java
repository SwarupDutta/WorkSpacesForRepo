package spring.jaxb.poc.domains;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="DEPT")
public class EmployeeDepartment {

    @Override
	public String toString() {
		return "EmployeeDepartment [deptName=" + deptName + ", empList=" + empList + ", departmentId=" + departmentId
				+ "]";
	}



	private String deptName;
	private EmployeeList empList;
	private String departmentId;

    public EmployeeList getEmpList() {
		return empList;
	}

	public void setEmpList(EmployeeList empList) {
		this.empList = empList;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

    @XmlElement(name="DeptName")

	public String getDeptName() {
		return deptName;
	}
    public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}



  public EmployeeDepartment() {
        // TODO Auto-generated constructor stub
    }
}