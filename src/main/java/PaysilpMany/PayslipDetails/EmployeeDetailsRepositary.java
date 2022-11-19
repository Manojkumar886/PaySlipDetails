package PaysilpMany.PayslipDetails;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepositary extends CrudRepository<EmployeeDetails, Integer>
{
	
	public EmployeeDetails findByEmpUsername(String Username);
	
	@Transactional
	@Modifying
	@Query("update from EmployeeDetails set empIncome=empIncome+(empIncome*20/100) where empName=:emp")
	public void updateSalaryByname(String emp);
	
	
	@Query("from EmployeeDetails where empIncome>=:salary or empName=:emp")//hql query
	public List<EmployeeDetails> findAllByEmpnameandSalary(double salary,String emp);
	

}
