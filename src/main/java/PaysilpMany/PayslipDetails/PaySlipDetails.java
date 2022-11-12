package PaysilpMany.PayslipDetails;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaySlipDetails 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payslipId;
	@Temporal(TemporalType.DATE)
	private Date payslipDate;
	private double paysilpBasicSalary;//divided by 12
	private double paysliptds;
	private double payslipAllowance;
	private double payslipTakehome;
	@ManyToOne
	@Nullable
	@JoinColumn(name = "empId")
	public EmployeeDetails empDetails;
	
	
	
	
	

}
