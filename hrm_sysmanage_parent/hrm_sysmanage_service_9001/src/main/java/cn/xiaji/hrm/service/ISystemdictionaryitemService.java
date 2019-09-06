package cn.xiaji.hrm.service;

import cn.xiaji.hrm.domain.Systemdictionaryitem;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaji
 * @since 2019-09-01
 */
public interface ISystemdictionaryitemService extends IService<Systemdictionaryitem> {
    //通过parent的sn查询明细
    List<Systemdictionaryitem> listByParentSn(String sn);
}
