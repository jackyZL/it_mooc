package com.czy.entity;

/**
 * employee 雇员实体对象
 * <p>
 * Created by jacky on 2017/7/20.
 */
public class Employee {

    /**
     * 主键id
     */
    private long id;

    /**
     * 雇员名称
     */
    private String empName;

    /**
     * 雇员所属部分id
     */
    private long deptId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }
}
