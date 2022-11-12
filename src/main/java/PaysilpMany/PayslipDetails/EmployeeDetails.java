package PaysilpMany.PayslipDetails;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.sun.istack.Nullable;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //tostring,getset
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeDetails
{
//primarykey  //Auto-increment
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empUsername;
	private String empPassword;
	private String empDesignation;
	private int empExp;
	private double empIncome;
	//fetch-runtime that data should be fetched lazily when it isfirst accessed
	//cascade-it will be activated by all operations
	@OneToMany(fetch =FetchType.LAZY,cascade   = CascadeType.ALL)
	@Nullable
	@JoinTable(name="AllRecords",joinColumns=@JoinColumn(name="empId"),inverseJoinColumns=@JoinColumn(name="payslipId"))
	private Collection<PaySlipDetails> mypayslip=new ArrayList<PaySlipDetails>();

}
