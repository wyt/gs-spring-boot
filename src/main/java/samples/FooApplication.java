package samples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import samples.domain.Emp;
import samples.mapper.EmpMapper;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class FooApplication implements CommandLineRunner {

  public static void main(String[] args) {

    ApplicationContext ctx = SpringApplication.run(FooApplication.class, args);

    log.info("Let's inspect the beans provided by Spring Boot:");
    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String beanName : beanNames) {
      log.info(beanName);
    }
  }

  @Autowired private EmpMapper empMapper;

  @Override
  public void run(String... args) throws Exception {
    Emp emp = empMapper.selectEmp(7369);
    System.out.println("Hello, " + emp.getEname() + " !");
  }
}
