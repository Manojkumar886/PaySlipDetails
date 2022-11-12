package PaysilpMany.PayslipDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaySlipDetailsRepositary extends JpaRepository<PaySlipDetails, Integer>
{
	
	public List<PaySlipDetails> findAllByEmpDetails(EmployeeDetails emp);

}
