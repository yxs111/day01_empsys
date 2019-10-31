package com.qfedu.controller;


import com.qfedu.common.JsonBean;
import com.qfedu.pojo.Employee;
import com.qfedu.service.EmployeeService;
import com.qfedu.vo.VPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
@Controller
@RequestMapping("/ssm")
@ResponseBody
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/list.do")
    public JsonBean list(){
        System.out.println("进来======================");
        List<Employee> list = employeeService.findAll();
        System.out.println(list);
        return new JsonBean(1, list);
    }
    @RequestMapping("/add.do")
    public JsonBean add(Employee employee){
        employeeService.add(employee);
      return new JsonBean( 1, null);

    }
    @RequestMapping("/del.do")
    public JsonBean del(int id) {
        employeeService.del(id);
        return new JsonBean(1,null);
    }
    @RequestMapping("/upd.do")
    public JsonBean upd(Employee employee){
        employeeService.upd(employee);
        return new JsonBean(1,null);
    }
    @RequestMapping("/find.do")
    public JsonBean find(int id){
        Employee employee =employeeService.findById(id);
        return new JsonBean(1,employee);

    }
    @RequestMapping("/page.do")
    public JsonBean findByPage (Integer page, Integer size){
        VPageInfo<Employee> pageInfo = employeeService.findByPage(page, size);
        return new JsonBean(1, pageInfo);
    }

}
