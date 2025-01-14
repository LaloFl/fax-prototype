package fax.fax_prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "fax.fax_prototype")
@EnableScheduling
@EnableJpaRepositories(basePackages = "fax.fax_prototype")
@EntityScan(basePackages = "fax.fax_prototype")
public class FaxPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaxPrototypeApplication.class, args);
	}

}
