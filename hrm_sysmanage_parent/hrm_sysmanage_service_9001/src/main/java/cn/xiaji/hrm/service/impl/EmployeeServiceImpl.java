package cn.xiaji.hrm.service.impl;

import cn.xiaji.hrm.domain.Employee;
import cn.xiaji.hrm.mapper.EmployeeMapper;
import cn.xiaji.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaji
 * @since 2019-09-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
