package samples.mapper;

import org.apache.ibatis.annotations.Mapper;
import samples.domain.Emp;

@Mapper
public interface EmpMapper {

  Emp selectEmp(int empno);
}
