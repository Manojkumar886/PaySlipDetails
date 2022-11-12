package PaysilpMany.PayslipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeDetailsService service;
	@Autowired
	PaySlipDetailsService pserv;
	
	@PostMapping("/newone")
	public String makecreate(@RequestBody EmployeeDetails emp)
	{
		return service.create(emp).getEmpName()+"employee has been added";
	}
	@PutMapping("/update")
	public String updating(@RequestBody EmployeeDetails emp)
	{
		EmployeeDetails obj=service.create(emp);
		return obj.getEmpName()+"has been updated succesffully";
	}
	
	@DeleteMapping("/Delete/{key}")
	public String erasing(@PathVariable("key")int key)
	{
		return service.erasing(key);
	}
	
	@PostMapping("/creatinganpayslip")
	public PaySlipDetails callbynewslip(@RequestBody PaySlipDetails paydetails)
	{
		EmployeeDetails temp=service.gettingbyExactnumber(paydetails.getEmpDetails().getEmpId());
		double month=temp.getEmpIncome()/12;
		double basic=month-(month*(paydetails.getPayslipAllowance())/100);
		paydetails.setPaysilpBasicSalary(basic);
		month=basic-paydetails.getPaysliptds()/100;
		paydetails.setPayslipTakehome(month);
		temp.getMypayslip().add(paydetails);
		pserv.newone(paydetails);
		service.create(temp);
		return paydetails;
	}
	
	@GetMapping("/getAll/{empid}")
	public List<PaySlipDetails> callbyallpayslip(@PathVariable("empid")int empid)
	{
		EmployeeDetails emp=service.gettingbyExactnumber(empid);
		return pserv.getbyEmpDetails(emp);
	}

}
