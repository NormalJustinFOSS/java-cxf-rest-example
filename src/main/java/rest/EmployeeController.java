package rest;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.EmployeeResponse;

@RestController
public class EmployeeController {
	@RequestMapping("/employee/{id}")
	public EmployeeResponse lookUpEmployeeById(@PathVariable("id") int id) {
		return new EmployeeResponse(id, "snicklefritz", new Date());
	}
}
