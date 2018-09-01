package spring.jaxb.poc.domains;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="CLG_DEPT")
public class CollegeDepartment
{
	private String collegeDepartmentName;
	private int collegeDepartmentId;
	private ProfessorList professorList;



	//private List<Professor>professors;
	@XmlElement(name="DEPT_NAME")
	public String getCollegeDepartmentName() {
		return collegeDepartmentName;
	}
	public void setCollegeDepartmentName(String collegeDepartmentName) {
		this.collegeDepartmentName = collegeDepartmentName;
	}
	@XmlElement(name="DEPT_ID")

	public int getCollegeDepartmentId() {
		return collegeDepartmentId;
	}
	public void setCollegeDepartmentId(int collegeDepartmentId) {
		this.collegeDepartmentId = collegeDepartmentId;
	}
	/*@XmlElement(name="PROF")

	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}*/
	
	@XmlElement(name="PROF_LIST")
	public ProfessorList getProfessorList() {
		return professorList;
	}
	public void setProfessorList(ProfessorList professorList) {
		this.professorList = professorList;
	}




	
	public String toString()
	{
		return collegeDepartmentName+" "+collegeDepartmentId+" "+professorList.getProfList();
	}

	
}
