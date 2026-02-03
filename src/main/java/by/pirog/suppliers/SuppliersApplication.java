package by.pirog.suppliers;

import by.pirog.suppliers.api.usecase.FindProductUseCase;
import by.pirog.suppliers.spi.spring.jpa.JpaClientFindProductById;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuppliersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppliersApplication.class, args);
	}


}
