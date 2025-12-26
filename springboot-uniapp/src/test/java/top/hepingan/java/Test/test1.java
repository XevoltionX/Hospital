package top.hepingan.java.Test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test1 {

    @Value("${ali-oss.endpoint}")
    private String endpoint;

    @Test
    public void nacosTest(){
        System.out.println(endpoint);
    }
}
