package service;

import java.util.Date;

import model.EmployeeResponse;
import model.NewEmployeeRequest;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public EmployeeResponse insertEmployee(NewEmployeeRequest newEmployeeRequest) {
		return new EmployeeResponse(1, newEmployeeRequest.getName(), newEmployeeRequest.getStartDate() == null ? new Date() : newEmployeeRequest.getStartDate());
	}
	
	@Override
	public String deleteEmployee(int id) {
		return "Employee: " + id + " was deleted";
	}

}
