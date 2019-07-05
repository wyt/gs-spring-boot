package samples.mapper;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import samples.domain.Emp;

import java.math.BigDecimal;
import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("EmpMapper测试用例")
public class EmpMapperTests {

  @Autowired private EmpMapper empMapper;

  @DisplayName("查询一个Emp")
  @Test
  public void selectEmpTest() {
    Emp emp = empMapper.selectEmp(7369);
    Assertions.assertEquals("SMITH", emp.getEname());
  }

  @DisplayName("查询一个Emp,By动态指定列")
  @Test
  public void findByColumnTest() {
    Emp emp = empMapper.findByColumn("ename", "SMITH");
    Assertions.assertEquals(7369, emp.getEmpno());
  }

  @DisplayName("插入一个Emp")
  @Test
  public void saveEmpTest() {
    Emp emp = new Emp();
    emp.setEname("YONGTAO");
    emp.setJob("PROGRAMMER");
    emp.setMgr(7369);
    emp.setHiredate(new Date(System.currentTimeMillis()));
    emp.setSal(new BigDecimal("52325.23"));
    emp.setDeptno(20);
    empMapper.saveEmp(emp);
  }
}
