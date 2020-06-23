package com.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.entity.Dept;
import com.entity.LayUiTable;
import com.entity.ResultData;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author AAATeacherChen
 * @since 2020-06-14
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService service;

    @ResponseBody
    @RequestMapping("/selectDept")
    public LayUiTable selectDept(Integer page, Integer limit, String deptId, String deptName) {
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("del_flag", "0");

        if (deptId != null && !deptId.equals("")) {
            wrapper.like("dept_id", deptId);
        }
        if (deptName != null && !deptName.equals("")) {
            wrapper.like("dept_name", deptName);
        }

        Page<Dept> pageinfo = new Page<>(page, limit);
        Page<Dept> deptPage = service.selectPage(pageinfo, wrapper);
        List<Dept> depts = deptPage.getRecords();

        int i = service.selectCount(wrapper);

        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("成功");
        layUiTable.setCount(i);
        layUiTable.setData(depts);
        return layUiTable;
    }

    @ResponseBody
    @RequestMapping("/insertDept")
    public ResultData insertDept(Dept dept) {
        boolean insert;
        if (dept.getDeptId() != null) {
            insert = service.updateById(dept);
        } else {
            insert = service.insert(dept);
        }
        ResultData resultData;
        if (insert) {
            resultData = new ResultData(true, "成功", null);
        } else {
            resultData = new ResultData(false, "失败", null);
        }
        return resultData;
    }

    @ResponseBody
    @RequestMapping("/selectDeptByid")
    public Dept selectDeptByid(Dept dept) {
        Dept dept1 = service.selectById(dept);
        return dept1;
    }

    @ResponseBody
    @RequestMapping("/delectDept")
    public ResultData delectDept(Dept dept) {
        dept.setDelFlag("1");
        boolean insert = service.updateById(dept);
        ResultData resultData;
        if (insert) {
            resultData = new ResultData(true, "成功", null);
        } else {
            resultData = new ResultData(false, "失败", null);
        }
        return resultData;
    }

    @ResponseBody
    @RequestMapping("/deleteAll")
    public ResultData delectAll(@RequestBody List<Dept> depts) {
        ResultData resultData;
        for (int i = 0; i < depts.size(); i++) {
            Dept dept = depts.get(i);
            dept.setDelFlag("1");
        }
        boolean insert = service.updateBatchById(depts);
        if (insert) {
            resultData = new ResultData(true, "成功", null);
        } else {
            resultData = new ResultData(false, "失败", null);
        }
        return resultData;
    }

    @RequestMapping("/toDept")
    public String toDept() {
        return "deptList";
    }
}

