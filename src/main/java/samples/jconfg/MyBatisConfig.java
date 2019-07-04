package samples.jconfg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("mybatis.mappers")
public class MyBatisConfig {}
