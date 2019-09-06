package cn.xiaji.hrm.mapper;

import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.query.CourseTypeQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程目录 Mapper 接口
 * </p>
 *
 * @author xiaji
 * @since 2019-09-01
 */
public interface CourseTypeMapper extends BaseMapper<CourseType> {

    List<CourseType> loadListPage(Pagination page, @Param("query") CourseTypeQuery query);
}
