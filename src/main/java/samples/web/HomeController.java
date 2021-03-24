package samples.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
public class HomeController {

  @Autowired private HttpServletRequest request;

  @RequestMapping("/")
  public String index() throws UnknownHostException {
    InetAddress ia = InetAddress.getLocalHost();
    String host = ia.getHostName();
    String IP = ia.getHostAddress();
    System.out.println("Host," + host + ";IP," + IP);

    reqInfo();
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/test")
  public String test() throws UnknownHostException {
    InetAddress ia = InetAddress.getLocalHost();
    String host = ia.getHostName();
    String IP = ia.getHostAddress();
    System.out.println("Host," + host + ";IP," + IP);

    reqInfo();
    return "I am test method!";
  }

  private void reqInfo() {
    log.info(
        "\r\nServletPath: {}\r\n"
            + "PathInfo: {} \r\n"
            + "ContextPath: {}\r\n"
            + "RequestURI: {}\r\n"
            + "RequestURL: {}\r\n",
        request.getServletPath(),
        request.getPathInfo(),
        request.getContextPath(),
        request.getRequestURI(),
        request.getRequestURL());
  }
}
