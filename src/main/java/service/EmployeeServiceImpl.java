package service;

import model.EmployeeResponse;
import model.NewEmployeeRequest;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public EmployeeResponse insertEmployee(NewEmployeeRequest newEmployeeRequest) {
		return new EmployeeResponse(1, newEmployeeRequest.getName(), newEmployeeRequest.getStartDate());
	}

}
