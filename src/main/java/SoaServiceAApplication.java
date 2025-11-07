import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
        "com.soa_service_a",
        "dragon",
        "dragonHead",
        "coordinates",
        "mapstruct"
})

public class SoaServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoaServiceAApplication.class, args);
    }
}