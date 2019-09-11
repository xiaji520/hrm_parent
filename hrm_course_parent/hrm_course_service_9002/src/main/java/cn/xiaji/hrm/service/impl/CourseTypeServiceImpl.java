package cn.xiaji.hrm.service.impl;

import cn.xiaji.hrm.cache.CourseTypeCache;
import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.mapper.CourseTypeMapper;
import cn.xiaji.hrm.query.CourseTypeQuery;
import cn.xiaji.hrm.service.ICourseTypeService;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author xiaji
 * @since 2019-09-01
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Autowired
    private CourseTypeCache courseTypeCache;

    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Page page = new Page(query.getPage(), query.getRows());
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<>(page.getTotal(), courseTypes);
    }

   /* @Override
    public List<CourseType> selectTypeTree(long pid) {
        //递归
        //return getCourseTypesRecursion(pid);
        //采用循环方式 递归不行
        return getCourseTypesLoop(pid);
    }*/

    @Override
    public List<CourseType> selectTypeTree(long pid) {
        List<CourseType> courseTypes = courseTypeCache.getCourseTypes();
        if (courseTypes == null || courseTypes.size() < 1) {
            //递归
            //return getCourseTypesRecursion(pid);
            //采用循环方式 递归不行
            List<CourseType> courseTypesLoop = getCourseTypesLoop(pid);
            //为[]时
            if (courseTypesLoop == null || courseTypesLoop.size() < 1) {
                courseTypesLoop = new ArrayList<>();
            }
            //将数据加入缓存
            courseTypeCache.setCourseTypes(courseTypesLoop);
            return courseTypesLoop;
        }
        return courseTypes;
    }


    //方案1:递归,每次都要发送sql效率低下
    private List<CourseType> getCourseTypesRecursion(long pid) {
        //注意:要有出口
        List<CourseType> children = courseTypeMapper.selectList(new EntityWrapper<CourseType>().eq("pid", pid));
        //出口
        if (children == null || children.size() < 1) {
            return null;
        } else {
            //自己调用自己
            for (CourseType child : children) {
                List<CourseType> courseTypes = selectTypeTree(child.getId());
                child.setChildren(courseTypes);
            }
            return children;
        }
    }


    //方案2:循环方案:一次sql
    private List<CourseType> getCourseTypesLoop(long pid) {
        List<CourseType> result = new ArrayList<>();
        //1 查询所有类型
        List<CourseType> allTypes = courseTypeMapper.selectList(null);

        //建立id和CourseType的关联关系
        Map<Long, CourseType> allTypesDto = new HashMap<>();
        for (CourseType allType : allTypes) {
            allTypesDto.put(allType.getId(), allType);
        }
        //2 遍历判断是否是第一级 pid为传入id
        for (CourseType type : allTypes) {
            Long pidTmp = type.getPid();
            //2.1是父级 直接加入返回列表
            if (pidTmp.longValue() == pid) {
                result.add(type);
            } else {
                //2.2不是父级 要把自己作为父亲儿子
                //通过pid获取父亲
                //方案1:遍历所有,通过父亲id来获取父亲
                    /*
                    for (CourseType courseType : allTypes) {
                        if(courseType.getId().longValue() == pidTmp.longValue()){
                            courseType.getChildren().add(type);
                        }
                    }*/
                //方案2:通过map获取
                CourseType parent = allTypesDto.get(pidTmp);
                //获取父亲儿子集合 把自己加进去
                parent.getChildren().add(type);
            }
        }
        return result;
    }
}
