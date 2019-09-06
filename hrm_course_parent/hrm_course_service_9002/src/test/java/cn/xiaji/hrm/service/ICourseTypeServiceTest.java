package cn.xiaji.hrm.service;

import cn.xiaji.hrm.Course9002Application;
import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.query.CourseTypeQuery;
import cn.xiaji.hrm.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Course9002Application.class)
public class ICourseTypeServiceTest {

    @Autowired
    private ICourseTypeService courseTypeService;
    @Test
    public void selectListPage() {
        PageList<CourseType> page = courseTypeService.selectListPage(new CourseTypeQuery());
        System.out.println(page.getTotal());
        System.out.println(page.getRows().size());
        for (CourseType courseType : page.getRows()) {
            System.out.println(courseType);
            System.out.println(courseType.getParent());
            System.out.println("========================");
        }
    }
}