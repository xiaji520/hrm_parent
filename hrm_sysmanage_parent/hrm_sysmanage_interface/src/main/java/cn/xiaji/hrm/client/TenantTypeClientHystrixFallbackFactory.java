package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.TenantType;
import cn.xiaji.hrm.query.TenantTypeQuery;
import cn.xiaji.hrm.util.AjaxResult;
import cn.xiaji.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author xiaji
 * @since 2019-09-02
 */
@Component
public class TenantTypeClientHystrixFallbackFactory implements FallbackFactory<TenantTypeClient> {

    @Override
    public TenantTypeClient create(Throwable throwable) {
        return new TenantTypeClient() {
            @Override
            public AjaxResult save(TenantType tenantType) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public TenantType get(Long id) {
                return null;
            }

            @Override
            public List<TenantType> list() {
                return null;
            }

            @Override
            public PageList<TenantType> json(TenantTypeQuery query) {
                return null;
            }
        };
    }
}
