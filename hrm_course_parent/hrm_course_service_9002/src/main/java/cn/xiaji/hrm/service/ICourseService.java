package cn.xiaji.hrm.service;

import cn.xiaji.hrm.domain.Course;
import cn.xiaji.hrm.query.CourseQuery;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiaji
 * @since 2019-09-03
 */
public interface ICourseService extends IService<Course> {
    //分页+高级查询+关联查询
    PageList<Course> selectListPage(CourseQuery query);

    //上线
    void onLine(Long[] ids);

    //下线
    void offLine(Long[] ids);
}
