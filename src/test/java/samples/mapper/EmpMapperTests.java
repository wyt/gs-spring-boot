package samples.mapper;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import samples.domain.Emp;

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
}
