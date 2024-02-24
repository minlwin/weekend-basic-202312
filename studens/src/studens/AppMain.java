package studens;

import java.util.LinkedHashMap;

import com.jdc.application.ApplicationController;
import com.jdc.application.Inputs;
import com.jdc.application.Operation;

public class AppMain {

	public static void main(String[] args) {
		var inputs = new Inputs();
		var operations = new LinkedHashMap<Integer, Operation>();
		operations.put(1, new StudentAddOperation(1, inputs));
		operations.put(2, new StudentSearchOperation(2, inputs));
		operations.put(3, new StudentEditOperation(3, inputs));
		
		new ApplicationController(inputs, operations).launch();
	}
}
