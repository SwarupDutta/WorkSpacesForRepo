package spring.jaxb.poc.domains;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="PROFESSOR_LIST")
public class ProfessorList {

List <Professor>  profList=new ArrayList<Professor>();
@XmlElement(name="PROF")

public List<Professor> getProfList() {
	return profList;
}

public void setProfList(List<Professor> profList) {
	this.profList = profList;
}
}
