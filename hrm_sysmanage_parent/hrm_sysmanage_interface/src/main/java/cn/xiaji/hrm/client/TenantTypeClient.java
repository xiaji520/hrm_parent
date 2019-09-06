package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.TenantType;
import cn.xiaji.hrm.query.TenantTypeQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ZUUL-GATEWAY", configuration = FeignClientsConfiguration.class,
        fallbackFactory = TenantTypeClientHystrixFallbackFactory.class)
@RequestMapping("/user/tenantType")
public interface TenantTypeClient {
    /**
     * 保存和修改公用的
     * @param tenantType 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    AjaxResult save(TenantType tenantType);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @GetMapping("/{id}")
    TenantType get(@RequestParam(value = "id", required = true) Long id);

    /**
     * 查看所有的员工信息
     * @return
     */
    @PatchMapping
    public List<TenantType> list();

    /**
     * 分页查询数据
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    PageList<TenantType> json(@RequestBody TenantTypeQuery query);
}
