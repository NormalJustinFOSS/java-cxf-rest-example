package service;

import javax.jws.WebService;
import javax.validation.Valid;

import model.EmployeeResponse;
import model.NewEmployeeRequest;

@WebService
public interface EmployeeService {
	public EmployeeResponse insertEmployee(@Valid NewEmployeeRequest newEmployeeRequest);
}
