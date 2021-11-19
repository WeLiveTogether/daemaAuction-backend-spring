package mungsanbackend.daemaAuction;

import mungsanbackend.daemaAuction.config.properties.AppProperties;
import mungsanbackend.daemaAuction.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableJpaAuditing
@SpringBootApplication
@CrossOrigin(origins = {"https://daemaauction.herokuapp.com", "http://localhost:3000", "http://localhost:8080"})
@EnableConfigurationProperties({
		AppProperties.class,
		CorsProperties.class
})
public class DaemaAuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaemaAuctionApplication.class, args);
	}

}
