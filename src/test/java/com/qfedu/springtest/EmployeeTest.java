package com.qfedu.springtest;

import com.qfedu.pojo.Employee;
import com.qfedu.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/6/5.
 */
public class EmployeeTest extends BaseTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void add(){
        Employee employee = new Employee();
        employee.setPhone("11111");
        employeeService.add(employee);
    }
}
