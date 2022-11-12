package PaysilpMany.PayslipDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepositary extends CrudRepository<EmployeeDetails, Integer>
{
	

}
