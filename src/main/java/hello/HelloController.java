package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

  @RequestMapping("/")
  public String index() throws UnknownHostException {
    InetAddress ia = InetAddress.getLocalHost();
    String host = ia.getHostName();
    String IP = ia.getHostAddress();
    System.out.println("Host," + host + ";IP," + IP);
    return "Greetings from Spring Boot!";
  }
}
