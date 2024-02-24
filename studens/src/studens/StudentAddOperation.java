package studens;

import com.jdc.application.Inputs;
import com.jdc.application.Operation;

public class StudentAddOperation extends Operation{
	
	private StudentRegistry registry;

	public StudentAddOperation(int id, Inputs inputs) {
		super(id, "Add New Student", inputs);
		registry = StudentRegistry.getInstance();
	}

	@Override
	protected void internalOperation() {
		
		// Get Name
		var name = inputs.readString("Name", 3);
		
		// Get Phone
		var phone = inputs.readString("Phone", 3);
		
		var id = registry.nextId();
		
		var student = new Student(id, name, phone);
		registry.add(student);
		
		// Show Message
		System.out.printf("%s has been registered with id %d.%n%n", 
				name, id);
	}


}
