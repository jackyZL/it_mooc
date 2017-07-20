package com.czy.controller;

import com.czy.entity.Employee;
import com.czy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jacky on 2017/7/20.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 通过雇员id，获取雇员对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Employee getEmployeeById(@RequestParam(value = "id") long id) {

        Employee employee = employeeService.selectEmployee(id);

        return employee;

    }
}
