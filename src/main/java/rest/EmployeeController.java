package rest;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.EmployeeResponse;
import model.NewEmployeeRequest;

@RestController
public class EmployeeController {
	
	@RequestMapping("/employee/{id}")
	public EmployeeResponse lookUpEmployeeById(@PathVariable("id") int id) {
		return new EmployeeResponse(id, "snicklefritz", new Date());
	}
	
	@RequestMapping(value="/employee/add", method = RequestMethod.POST)
	public EmployeeResponse addNewEmployee(@RequestBody NewEmployeeRequest newEmployeeRequest) {
		return new EmployeeResponse(1, newEmployeeRequest.getName(), newEmployeeRequest.getStartDate() == null ? new Date() : newEmployeeRequest.getStartDate());
	}
}
