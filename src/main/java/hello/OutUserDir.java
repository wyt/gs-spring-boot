package hello;

public class OutUserDir {
    public static void main(String[] args) {

        // java -classpath E:\idea\projects\myself\gs-spring-boot\target\classes hello.OutUserDir
        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir: " + userDir);
    }
}
