import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


@SpringBootApplication(scanBasePackages = "com.soa_service_a")
public class SoaServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoaServiceAApplication.class, args);
    }
}