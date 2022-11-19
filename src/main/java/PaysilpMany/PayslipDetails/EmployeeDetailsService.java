package PaysilpMany.PayslipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService implements UserDetailsService
{
	@Autowired
	EmployeeDetailsRepositary repositary;
	
	public EmployeeDetails create(EmployeeDetails emp)
	{
		return repositary.save(emp);
	}
	public String erasing(int id)
	{
		EmployeeDetails emp=repositary.findById(id).orElse(new EmployeeDetails());
		String tmp=emp.getEmpName()+"has been deleted successfully";
		repositary.delete(emp);
		return tmp;
	}
	
	public EmployeeDetails gettingbyExactnumber(int id)
	{
		return repositary.findById(id).orElse(new EmployeeDetails());
	}
	
	//findallbysalaryandname
	public List<EmployeeDetails> mekefetchSalaryName(double salary1,String emp1)
	
	{
		return repositary.findAllByEmpnameandSalary(salary1, emp1);
	}
	
	//update by salary in name
	public void makeupdate(String which)
	{
		repositary.updateSalaryByname(which);
	}
	
	public List<EmployeeDetails> list()
	{
		return (List<EmployeeDetails>) repositary.findAll();
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// TODO Auto-generated method stub
		EmployeeDetails emp=repositary.findByEmpUsername(username);
		if(emp==null)
		{
			throw new UsernameNotFoundException(username);
		}
		return emp;
	}

}
