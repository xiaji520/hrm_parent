package cn.xiaji.hrm.web.controller;

import cn.xiaji.hrm.service.IPagerService;
import cn.xiaji.hrm.domain.Pager;
import cn.xiaji.hrm.query.PagerQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pager")
public class PagerController {
    @Autowired
    public IPagerService pagerService;

    /**
     * 保存和修改公用的
     *
     * @param pager 传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult save(@RequestBody Pager pager) {
        pager.setCreateTime(new Date());
        try {
            if (pager.getId() != null) {
                pagerService.updateById(pager);
            } else {
                pagerService.insert(pager);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！" + e.getMessage());
        }
    }

    /**
     * 删除对象信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            pagerService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public Pager get(@PathVariable("id") Long id) {
        return pagerService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     *
     * @return
     */
    @PatchMapping
    public List<Pager> list() {
        return pagerService.selectList(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping
    public PageList<Pager> json(@RequestBody PagerQuery query) {
        Page<Pager> page = new Page<Pager>(query.getPage(), query.getRows());
        page = pagerService.selectPage(page);
        return new PageList<Pager>(page.getTotal(), page.getRecords());
    }
}
