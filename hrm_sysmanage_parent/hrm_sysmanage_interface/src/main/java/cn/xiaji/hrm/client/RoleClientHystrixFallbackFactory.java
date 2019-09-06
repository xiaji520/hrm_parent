package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.Role;
import cn.xiaji.hrm.query.RoleQuery;
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
public class RoleClientHystrixFallbackFactory implements FallbackFactory<RoleClient> {

    @Override
    public RoleClient create(Throwable throwable) {
        return new RoleClient() {
            @Override
            public AjaxResult save(Role role) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Role get(Long id) {
                return null;
            }

            @Override
            public List<Role> list() {
                return null;
            }

            @Override
            public PageList<Role> json(RoleQuery query) {
                return null;
            }
        };
    }
}
