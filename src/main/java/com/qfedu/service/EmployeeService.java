package com.qfedu.service;

import com.qfedu.pojo.Employee;
import com.qfedu.vo.VPageInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
public interface EmployeeService {

    public List<Employee> findAll();
    public void add(Employee employee);
    public void del(int id);
    public void upd(Employee employee);
    public Employee findById(int id);
    public VPageInfo<Employee> findByPage (Integer page, Integer size);
}
