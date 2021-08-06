package com.InHouseMarketPlace.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.InHouseMarketPlace.entity.Employee;
import com.InHouseMarketPlace.service.EmployeeService;

@DataJpaTest
class EmployeeRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception
	{
		Employee e = Employee.builder().empId(101).build();	
		
		entityManager.persist(e);
	}
	
	@Test
	void whenFindByEmployeeIdthenReturnEmployee()
	{
		Employee e = Employee.builder().empId(101).build();
		Employee emp = employeeRepository.findByEmployeeId(101);
		assertEquals(e, emp);
	}

}
