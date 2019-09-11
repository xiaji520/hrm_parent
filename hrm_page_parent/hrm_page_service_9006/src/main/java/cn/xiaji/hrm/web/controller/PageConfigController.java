package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.IPageConfigService;
import cn.xiaji.hrm.domain.PageConfig;
import cn.xiaji.hrm.query.PageConfigQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pageConfig")
public class PageConfigController {
    @Autowired
    public IPageConfigService pageConfigService;

    /**
     * 保存和修改公用的
     * @param pageConfig 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody PageConfig pageConfig) {
        try {
            if (pageConfig.getId() != null){
                    pageConfigService.updateById(pageConfig);
            }else{
                    pageConfigService.insert(pageConfig);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！" + e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
                pageConfigService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public PageConfig get(@PathVariable("id") Long id) {
        return pageConfigService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @PatchMapping
    public List<PageConfig> list() {
        return pageConfigService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @PostMapping
    public PageList<PageConfig> json(@RequestBody PageConfigQuery query) {
        Page<PageConfig> page = new Page<PageConfig>(query.getPage(), query.getRows());
        page = pageConfigService.selectPage(page);
        return new PageList<PageConfig>(page.getTotal(), page.getRecords());
    }
}
