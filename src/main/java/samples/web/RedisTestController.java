package samples.web;

import com.yiche.redis.api.spring.YcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyongtao
 * @date 2020-8-19
 */
@RestController
public class RedisTestController {

  @Autowired
  private YcRedisService ycRedisService;

  String preffix = "com.yiche.redis.sdk:key";

  @RequestMapping("/chaotic")
  public void chaotic() throws InterruptedException {
    for (int i = 0; i < 1000; i++) {
      ycRedisService.set(preffix + i, i);
    }

    Random rand = new Random();
    rand.setSeed(System.nanoTime());

    for (; ; ) {
      Object obj = ycRedisService.get(preffix + rand.nextInt(100));
    }
  }
}
