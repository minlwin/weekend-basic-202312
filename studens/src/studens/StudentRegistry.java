package studens;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
	
	private Map<Integer, Student> students;
	private int id;
	
	private static StudentRegistry instance;
	
	public static StudentRegistry getInstance() {
		if(null == instance) {
			instance = new StudentRegistry();
		}
		return instance;
	}
	
	private StudentRegistry() {
		students = new HashMap<>();
	}

	public void add(Student student) {
		students.put(student.id(), student);
	}
	
	public Student findById(int id) {
		return students.get(id);
	}
	
	public int nextId() {
		return ++ id;
	}
}
