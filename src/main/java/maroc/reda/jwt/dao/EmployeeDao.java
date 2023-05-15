package maroc.reda.jwt.dao;

import maroc.reda.jwt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
