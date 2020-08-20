package samples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"samples", "com.yiche.redis"})
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

  @Override
  public void run(String... args) throws Exception {
    System.out.println("哥被调用了~啊哈哈哈~~~");
  }
}
