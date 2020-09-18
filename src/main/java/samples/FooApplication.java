package samples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
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
    System.out.println("启动时被调用.");
  }
}
