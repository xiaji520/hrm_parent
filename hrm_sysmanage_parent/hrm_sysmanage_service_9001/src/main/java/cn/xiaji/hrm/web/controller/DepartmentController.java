package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.IDepartmentService;
import cn.xiaji.hrm.domain.Department;
import cn.xiaji.hrm.query.DepartmentQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    public IDepartmentService departmentService;

    /**
     * 保存和修改公用的
     * @param department 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody Department department) {
        try {
            if (department.getId() != null){
                    departmentService.updateById(department);
            }else{
                    departmentService.insert(department);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！" + e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
                departmentService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public Department get(@PathVariable("id") Long id) {
        return departmentService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @PatchMapping
    public List<Department> list() {
        return departmentService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @PostMapping
    public PageList<Department> json(@RequestBody DepartmentQuery query) {
        Page<Department> page = new Page<Department>(query.getPage(), query.getRows());
        page = departmentService.selectPage(page);
        return new PageList<Department>(page.getTotal(), page.getRecords());
    }
}
