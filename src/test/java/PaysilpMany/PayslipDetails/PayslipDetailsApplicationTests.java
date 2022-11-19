package PaysilpMany.PayslipDetails;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PayslipDetailsApplicationTests 
{
	@Autowired
	EmployeeDetailsService service;
	
	@MockBean
	EmployeeDetailsRepositary repo;
	
	@Test
	public void test1()
	{
		EmployeeDetails emp=new EmployeeDetails(101, "Manojkumar", "Maddy434", "maddy@43434343", "JavaDeveloper", 2, 24000.0, null);
		EmployeeDetails emp1=new EmployeeDetails(102, "Ajithkumar", "Thala", "VandhaThala", "CinemaIndustry", 20, 2400000.0, null);
		
		when(repo.save(emp)).thenReturn(emp);
		//assertEquals(service.mekefetchSalaryName(240000.0, "Manojkumar"), service.mekefetchSalaryName(2400000.0, "Ajithkumar"));
		
		assertSame("Manojkumar", service.create(emp).getEmpName());
	}
	@Test
	public void test2()
	{
		EmployeeDetails emp=new EmployeeDetails(101, "Manojkumar", "Maddy434", "maddy@43434343", "JavaDeveloper", 2, 24000.0, null);
		EmployeeDetails emp1=new EmployeeDetails(102, "Ajithkumar", "Thala", "VandhaThala", "CinemaIndustry", 20, 2400000.0, null);
		
		
		when(repo.findAll()).thenReturn(Stream.of(emp,emp1).collect(Collectors.toList()));
		
		assertNotNull(service.list());
	}
	
}
