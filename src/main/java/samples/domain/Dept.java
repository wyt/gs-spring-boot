package samples.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dept {

  /** 部门编号 */
  private int deptno;

  /** 部门名称 */
  private String dname;

  /** 部门位置 */
  private String loc;
}
