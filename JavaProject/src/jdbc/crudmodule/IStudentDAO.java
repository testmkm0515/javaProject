package jdbc.crudmodule;

import java.util.ArrayList;

public interface IStudentDAO {
	public void insertStudent(StudentDTO dto);
	
	public ArrayList<StudentDTO> getAllStudent();
	
	public StudentDTO detailStudent(String stdNo);
	
	public void updateStudent(StudentDTO dto);
	
	public void deleteStudent(String stdNo);
	
	//과별 학생정보 검색 : 다중행 반환
	public ArrayList<StudentDTO> searchStudentDept(String dptName);
}
