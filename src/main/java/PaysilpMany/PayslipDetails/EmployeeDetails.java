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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.Nullable;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //tostring,getset
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeDetails implements UserDetails
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return empPassword;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return empUsername;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
