package PaysilpMany.PayslipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService 
{
	@Autowired
	EmployeeDetailsRepositary repo;
	
	public EmployeeDetails create(EmployeeDetails emp)
	{
		return repo.save(emp);
	}
	public String erasing(int id)
	{
		EmployeeDetails emp=repo.findById(id).orElse(new EmployeeDetails());
		String tmp=emp.getEmpName()+"has been deleted successfully";
		repo.delete(emp);
		return tmp;
	}
	
	public EmployeeDetails gettingbyExactnumber(int id)
	{
		return repo.findById(id).orElse(new EmployeeDetails());
	}
	
	//findallbysalaryandname
	public List<EmployeeDetails> mekefetchSalaryName(double salary1,String emp1)
	
	{
		return repo.findAllByEmpnameandSalary(salary1, emp1);
	}
	
	//update by salary in name
	public void makeupdate(String which)
	{
		repo.updateSalaryByname(which);
	}

}
