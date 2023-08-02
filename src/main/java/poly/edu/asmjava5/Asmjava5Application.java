package poly.edu.asmjava5;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import poly.edu.asmjava5.config.StorageProperties;
import poly.edu.asmjava5.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Asmjava5Application {

	public static void main(String[] args) {
		SpringApplication.run(Asmjava5Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args -> {
			storageService.init();
		});
	}
}
