package samples.jconfg;

import com.yiche.redis.api.conf.config.YcRedisTemplateService;
import com.yiche.redis.api.spring.YcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class RedisConfig {
  @Autowired YcRedisTemplateService ycRedisTemplateService;

  @Bean
  @RefreshScope
  public YcRedisService redisService() {
    YcRedisService ycRedisService = ycRedisTemplateService.getRedisServiceMap().get("node1");
    return ycRedisService;
  }
}
