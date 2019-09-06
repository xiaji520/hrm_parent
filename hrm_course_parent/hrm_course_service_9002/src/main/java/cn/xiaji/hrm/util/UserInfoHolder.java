package cn.xiaji.hrm.util;


import cn.xiaji.hrm.domain.Employee;
import cn.xiaji.hrm.domain.Tenant;

public class UserInfoHolder {
    public static Tenant getTenant() {
        Tenant currentLoginUserTenant = new Tenant();
        currentLoginUserTenant.setId(26L);
        currentLoginUserTenant.setCompanyName("战斧公司");
        return currentLoginUserTenant;
    }

    public static Employee getLoginUser() {
        Employee employee = new Employee();
        employee.setId(42L);
        employee.setUsername("xj");
        return employee;
    }
}
