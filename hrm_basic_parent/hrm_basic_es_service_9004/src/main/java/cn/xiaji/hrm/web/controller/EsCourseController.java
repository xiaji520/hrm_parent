package cn.xiaji.hrm.web.controller;


import cn.xiaji.hrm.doc.EsCourse;
import cn.xiaji.hrm.query.EsCourseQuery;
import cn.xiaji.hrm.service.IEsCourseService;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esCourse")
public class EsCourseController {
    @Autowired
    public IEsCourseService esCourseService;

    /**
     * 保存和修改公用的
     *
     * @param esCourse 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody EsCourse esCourse) {
        try {
            if (esCourse.getId() != null) {
                esCourseService.updateById(esCourse);
            } else {
                esCourseService.insert(esCourse);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！" + e.getMessage());
        }
    }

    /**
     * 删除对象信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            esCourseService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败!" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public EsCourse get(@PathVariable("id") Long id) {
        return esCourseService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     *
     * @return
     */
    @PatchMapping
    public List<EsCourse> list() {
        return esCourseService.selectList(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    public PageList<EsCourse> json(@RequestBody EsCourseQuery query) {
        return esCourseService.selectListPage(query);
    }

    @PostMapping("/online")
    AjaxResult batchSave(@RequestBody List<EsCourse> esCourseList) {
        System.out.println(esCourseList.size() + "-------");
        try {
            esCourseService.batchSave(esCourseList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("批量添加失败!" + e.getMessage());
        }
    }

    @PostMapping("/offline")
    AjaxResult batchDel(@RequestBody List<EsCourse> esCourseList) {
        System.out.println(esCourseList.size() + "=========");
        try {
            esCourseService.batchDel(esCourseList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("批量删除失败!" + e.getMessage());
        }
    }
}
