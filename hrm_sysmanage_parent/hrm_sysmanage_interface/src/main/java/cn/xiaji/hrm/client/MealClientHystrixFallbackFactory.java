package cn.xiaji.hrm.client;

import cn.xiaji.hrm.domain.Meal;
import cn.xiaji.hrm.query.MealQuery;
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
public class MealClientHystrixFallbackFactory implements FallbackFactory<MealClient> {

    @Override
    public MealClient create(Throwable throwable) {
        return new MealClient() {
            @Override
            public AjaxResult save(Meal meal) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Meal get(Long id) {
                return null;
            }

            @Override
            public List<Meal> list() {
                return null;
            }

            @Override
            public PageList<Meal> json(MealQuery query) {
                return null;
            }
        };
    }
}
