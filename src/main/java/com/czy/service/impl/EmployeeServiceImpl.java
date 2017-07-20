package com.czy.service.impl;

import com.czy.dao.EmployeeMapper;
import com.czy.entity.Employee;
import com.czy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jacky on 2017/7/20.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectEmployee(long id) {

        Employee employee = employeeMapper.selectById(id);
        return employee;
    }
}
