package cn.xiaji.hrm.mapper;

import cn.xiaji.hrm.domain.Course;
import cn.xiaji.hrm.query.CourseQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiaji
 * @since 2019-09-03
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> loadListPage(Page<Course> page, @Param("query") CourseQuery query);

    //上线
    void batchOnline(List<Map<String, Object>> idsMap);

    //下线
    void batchOffline(List<Long> asList);
}
