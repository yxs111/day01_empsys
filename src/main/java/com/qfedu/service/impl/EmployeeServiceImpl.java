package com.qfedu.service.impl;

import com.qfedu.dao.EmployeeDao;
import com.qfedu.pojo.Employee;
import com.qfedu.service.EmployeeService;
import com.qfedu.vo.VPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> findAll(){

//        PageHelper.startPage(pageNum:1,pageSize:5);
       return employeeDao.findAll();
//       List<Employee>list=employeeDao.findAll();
//        long total= ((Page)list).getTotal();
   }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public void del(int id) {
        employeeDao.del(id);
    }

    @Override
    public void upd(Employee employee) {
        employeeDao.upd(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findEmpById(id);
    }

    @Override
    public VPageInfo<Employee> findByPage(Integer page, Integer size) {
        VPageInfo<Employee> vPageInfo = new VPageInfo<>();
        int index = (page - 1)* size;
         List<Employee> employees = employeeDao.findByIndexAndSize(index ,size);
        vPageInfo.setCurrentPage(page);
        vPageInfo.setPageList(employees);
        int totalPage = 0;
        int count = employeeDao.count();
        if (count % size ==0){
            totalPage = count / size;
        }else {
            totalPage = count / size + 1;
        }
        vPageInfo.setTotalPage(totalPage);
        return vPageInfo ;
    }


}
