package mungsanbackend.daemaAuction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DaemaAuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaemaAuctionApplication.class, args);
	}

}
