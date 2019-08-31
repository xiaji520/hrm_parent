package cn.xiaji.hrm;

import cn.xiaji.hrm.domain.Systemdictionary;
import cn.xiaji.hrm.service.ISystemdictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysManage9001Application.class)
public class SystemdictionaryitemServiceImplTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;

    @Test
    public void test() throws Exception {
        systemdictionaryService.selectList(null).forEach(e -> System.out.println(e));
    }

    @Test
    public void testOne() throws Exception {
        System.out.println(systemdictionaryService.selectById(2L));
    }
    @Test
    public void testDel() throws Exception {
       systemdictionaryService.deleteById(9L);
    }


    @Test
    public void testSave() throws Exception {
        Systemdictionary systemdictionary = new Systemdictionary();
        systemdictionary.setName("222");
        systemdictionaryService.insert(systemdictionary);
    }
    @Test
    public void testUpdate() throws Exception {
        Systemdictionary systemdictionary = new Systemdictionary();
        systemdictionary.setId(10L);
        systemdictionary.setName("233");
        systemdictionaryService.updateById(systemdictionary);
    }
}