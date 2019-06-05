package sample.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SampleRedisApplication implements CommandLineRunner {

  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Override
  public void run(String... args) throws Exception {
    String value = stringRedisTemplate.opsForList().rightPop("myList");
    System.out.println("myList right pop: " + value);
  }

  private void forList() {

    stringRedisTemplate.opsForList().leftPush("myList", new Random().nextLong() + "");

    List<String> myList = stringRedisTemplate.opsForList().range("myList", 0, -1);

    for (String s : myList) {
      System.out.println(s);
    }
  }

  private void forVal() {
    ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
    String key = "spring.boot.redis.test";
    if (!this.stringRedisTemplate.hasKey(key)) {
      ops.set(key, "foo");
    }
    System.out.println("Found key " + key + ", value=" + ops.get(key));
  }

  public static void main(String[] args) {
    // Close the context so it doesn't stay awake listening for redis
    SpringApplication.run(SampleRedisApplication.class, args).close();
  }
}
