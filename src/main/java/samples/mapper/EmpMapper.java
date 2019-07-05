package samples.mapper;

import org.apache.ibatis.annotations.Param;
import samples.domain.Emp;

public interface EmpMapper {

  Emp selectEmp(int empno);

  Emp findByColumn(@Param("column") String column, @Param("value") String value);

  void saveEmp(Emp emp);
}
