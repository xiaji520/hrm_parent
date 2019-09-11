package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.Site;
import cn.xiaji.hrm.query.SiteQuery;
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
public class SiteClientHystrixFallbackFactory implements FallbackFactory<SiteClient> {

    @Override
    public SiteClient create(Throwable throwable) {
        return new SiteClient() {
            @Override
            public AjaxResult save(Site site) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Site get(Long id) {
                return null;
            }

            @Override
            public List<Site> list() {
                return null;
            }

            @Override
            public PageList<Site> json(SiteQuery query) {
                return null;
            }
        };
    }
}
