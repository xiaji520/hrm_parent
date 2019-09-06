package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.ICourseService;
import cn.xiaji.hrm.domain.Course;
import cn.xiaji.hrm.query.CourseQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import cn.xiaji.hrm.util.UserInfoHolder;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public ICourseService courseService;

    private Logger logger = LoggerFactory.getLogger(CourseController.class);

    /**
     * 保存和修改公用的
     *
     * @param course 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody Course course) {
        try {
            //tenantId tenantName userId userName
            // @TODO 以后登录成功都能获取,现在适用holder来模拟
            course.setTenantId(UserInfoHolder.getTenant().getId());
            course.setTenantName(UserInfoHolder.getTenant().getCompanyName());
            course.setUserId(UserInfoHolder.getLoginUser().getId());
            course.setUserName(UserInfoHolder.getLoginUser().getUsername());
            if (course.getId() != null) {
                courseService.updateById(course);
            } else {
                courseService.insert(course);
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
            courseService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public Course get(@PathVariable("id") Long id) {
        return courseService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     *
     * @return
     */
    @PatchMapping
    public List<Course> list() {
        return courseService.selectList(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    public PageList<Course> json(@RequestBody CourseQuery query) {
      /*  Page<Course> page = new Page<Course>(query.getPage(), query.getRows());
        page = courseService.selectPage(page);
        return new PageList<Course>(page.getTotal(), page.getRecords());*/
        return courseService.selectListPage(query);
    }

    @PostMapping("/onLine")
    public AjaxResult online(@RequestBody Long[] ids){
        try {
            courseService.onLine(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("online failed!"+e);
            return AjaxResult.me().setSuccess(false)
                    .setMessage("上线失败!"+e.getMessage());
        }
    }
    @PostMapping("/offLine")
    public AjaxResult offLine(@RequestBody Long[] ids){
        try {
            courseService.offLine(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("offline failed!"+e);
            return AjaxResult.me().setSuccess(false)
                    .setMessage("下线失败!"+e.getMessage());
        }
    }

}
