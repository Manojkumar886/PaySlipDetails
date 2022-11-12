package PaysilpMany.PayslipDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySlipDetailsService 
{
	@Autowired
	PaySlipDetailsRepositary prepo;
	
	public PaySlipDetails newone(PaySlipDetails pay)
	{
		return prepo.save(pay);
	}
	
	public List<PaySlipDetails> getbyEmpDetails(EmployeeDetails emp)
	{
			return prepo.findAllByEmpDetails(emp);
	}

}
