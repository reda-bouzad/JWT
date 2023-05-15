package maroc.reda.jwt.service;

import maroc.reda.jwt.dao.EmployeeDao;
import maroc.reda.jwt.dto.EmployeeDto;
import maroc.reda.jwt.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;




}
