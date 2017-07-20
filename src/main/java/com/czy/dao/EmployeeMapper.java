package com.czy.dao;

import com.czy.entity.Employee;

/**
 * Created by jacky on 2017/7/20.
 */
public interface EmployeeMapper {

    /**
     * 通过主键id获取雇员实体
     *
     * @param id
     * @return
     */
    public Employee selectById(long id);

    /**
     * 通过主键列表，获取过个雇员列表
     * @param ids
     * @return
     */
    /*public List<Employee> selectByIds(List<Long> ids);*/
}
