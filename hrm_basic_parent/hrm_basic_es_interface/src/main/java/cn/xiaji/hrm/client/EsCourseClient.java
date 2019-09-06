package cn.xiaji.hrm.client;

import cn.xiaji.hrm.doc.EsCourse;
import cn.xiaji.hrm.query.EsCourseQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//一定要注意 value = "HRM-ES"
@FeignClient(value = "HRM-ES", configuration = FeignClientsConfiguration.class,
        fallbackFactory = EsCourseClientHystrixFallbackFactory.class)
@RequestMapping("/esCourse")
public interface EsCourseClient {
    //保存和修改公用的
    @PutMapping
    AjaxResult save(EsCourse esCourse);

    //删除对象信息
    @DeleteMapping("/{id}")
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @GetMapping("/{id}")
    EsCourse get(@RequestParam(value = "id", required = true) Long id);


    //查看所有的员工信息
    @PatchMapping
    public List<EsCourse> list();

    //分页查询数据
    @PostMapping
    PageList<EsCourse> json(@RequestBody EsCourseQuery query);

    @PostMapping("/online")
    AjaxResult batchSave(List<EsCourse> esCourseList);

    @PostMapping("/offline")
    void batchDel(List<EsCourse> esCourseList);
}
