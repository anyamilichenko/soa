

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class,
//        JdbcTemplateAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class,
//        LiquibaseAutoConfiguration.class,
//        SqlInitializationAutoConfiguration.class,
//        CouchbaseDataAutoConfiguration.class,
//        CouchbaseReactiveDataAutoConfiguration.class
//})

@SpringBootApplication(scanBasePackages = "com.soa_service_a")
public class SoaServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoaServiceAApplication.class, args);
    }
}