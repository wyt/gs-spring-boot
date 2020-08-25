package samples.web;

import io.mysnippet.msconfig.HelloService;
import io.mysnippet.msconfig.HelloServiceProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@SuppressWarnings("all")
public class HomeController {

  @Autowired private HelloService helloService;

  @Autowired private HelloServiceProps helloServiceProps;

  @RequestMapping("/")
  public String index() throws UnknownHostException {
    InetAddress ia = InetAddress.getLocalHost();
    String host = ia.getHostName();
    String IP = ia.getHostAddress();
    System.out.println("Host," + host + ";IP," + IP);
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/hello")
  public String hello() {
    System.out.println("msg: " + helloServiceProps.getMsg());
    return helloService.sayHello();
  }
}
