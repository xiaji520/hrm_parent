package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.CourseType;
import cn.xiaji.hrm.query.CourseTypeQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ZUUL-GATEWAY", configuration = FeignClientsConfiguration.class,
        fallbackFactory = CourseTypeClientHystrixFallbackFactory.class)
@RequestMapping("/courseType")
public interface CourseTypeClient {
    /**
     * 保存和修改公用的
     * @param courseType 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    AjaxResult save(CourseType courseType);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @GetMapping("/{id}")
    CourseType get(@RequestParam(value = "id", required = true) Long id);

    /**
     * 查看所有的员工信息
     * @return
     */
    @PatchMapping
    public List<CourseType> list();

    /**
     * 分页查询数据
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    PageList<CourseType> json(@RequestBody CourseTypeQuery query);
}
