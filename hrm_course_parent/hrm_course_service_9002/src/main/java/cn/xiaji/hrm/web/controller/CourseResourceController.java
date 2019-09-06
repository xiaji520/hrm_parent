package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.ICourseResourceService;
import cn.xiaji.hrm.domain.CourseResource;
import cn.xiaji.hrm.query.CourseResourceQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseResource")
public class CourseResourceController {
    @Autowired
    public ICourseResourceService courseResourceService;

    /**
     * 保存和修改公用的
     * @param courseResource 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody CourseResource courseResource) {
        try {
            if (courseResource.getCourseId() != null){
                    courseResourceService.updateById(courseResource);
            }else{
                    courseResourceService.insert(courseResource);
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
                courseResourceService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public CourseResource get(@PathVariable("id") Long id) {
        return courseResourceService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @PatchMapping
    public List<CourseResource> list() {
        return courseResourceService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @PostMapping
    public PageList<CourseResource> json(@RequestBody CourseResourceQuery query) {
        Page<CourseResource> page = new Page<CourseResource>(query.getPage(), query.getRows());
        page = courseResourceService.selectPage(page);
        return new PageList<CourseResource>(page.getTotal(), page.getRecords());
    }
}
