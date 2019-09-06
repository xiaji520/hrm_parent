package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.ICourseTypeService;
import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.query.CourseTypeQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/courseType")
public class CourseTypeController {
    @Autowired
    public ICourseTypeService courseTypeService;

    /**
     * 保存和修改公用的
     *
     * @param courseType 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody CourseType courseType) {
        try {
            if (courseType.getId() != null) {
                courseType.setUpdateTime(new Date());
                courseTypeService.updateById(courseType);
            } else {
                courseType.setCreateTime(new Date());
                courseTypeService.insert(courseType);
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
            courseTypeService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public CourseType get(@PathVariable("id") Long id) {
        return courseTypeService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     *
     * @return
     */
    @PatchMapping
    public List<CourseType> list() {
        return courseTypeService.selectList(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    public PageList<CourseType> json(@RequestBody CourseTypeQuery query) {
       /* Page<CourseType> page = new Page<CourseType>(query.getPage(), query.getRows());
        page = courseTypeService.selectPage(page);
        return new PageList<CourseType>(page.getTotal(), page.getRecords());*/
        return courseTypeService.selectListPage(query);
    }
}
