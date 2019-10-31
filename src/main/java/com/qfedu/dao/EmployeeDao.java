package com.qfedu.dao;

import com.qfedu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
public interface EmployeeDao {
    public List<Employee> findAll();
    public void add(Employee employee);
    public void del(int id);
    public void upd(Employee employee);
    public Employee findEmpById(int id);

    public List<Employee> findByIndexAndSize(@Param("index") Integer index,@Param("size") Integer size);
    public  int count();

}
