package studens;

import com.jdc.application.Inputs;
import com.jdc.application.Operation;

public class StudentSearchOperation extends Operation {

	private StudentRegistry registry;
	
	public StudentSearchOperation(int id, Inputs inputs) {
		super(id, "Search Student", inputs);
		registry = StudentRegistry.getInstance();
	}

	@Override
	protected void internalOperation() {

		var id = inputs.readInt("Student ID", 3);
		var student = registry.findById(id);
		
		if(null == student) {
			System.out.println("There is no student with id %d.%n".formatted(id));
			return;
		}
		
		System.out.printf("Student Name  : %s%n", student.name());
		System.out.printf("Student Phone : %s%n%n", student.phone());
	}

}
