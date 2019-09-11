package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.PageConfig;
import cn.xiaji.hrm.query.PageConfigQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author xiaji
 * @since 2019-09-08
 */
@Component
public class PageConfigClientHystrixFallbackFactory implements FallbackFactory<PageConfigClient> {

    @Override
    public PageConfigClient create(Throwable throwable) {
        return new PageConfigClient() {
            @Override
            public AjaxResult save(PageConfig pageConfig) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public PageConfig get(Long id) {
                return null;
            }

            @Override
            public List<PageConfig> list() {
                return null;
            }

            @Override
            public PageList<PageConfig> json(PageConfigQuery query) {
                return null;
            }
        };
    }
}
