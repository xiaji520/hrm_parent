package cn.xiaji.hrm.service;

import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.query.CourseTypeQuery;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author xiaji
 * @since 2019-09-01
 */
public interface ICourseTypeService extends IService<CourseType> {
    //高级查询+分页+关联查询
    PageList<CourseType> selectListPage(CourseTypeQuery query);
    //通过父亲id获取儿子 及其儿子的儿子等子子孙孙
    List<CourseType> selectTypeTree(long pid);
}
