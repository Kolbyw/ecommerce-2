package wallin.software.ecommerce;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.username("")
				.password("")
				.url("jdbc:postgresql://localhost:5432/Commerce")
				.driverClassName("org.postgresql.Driver")
				.build();
	}
}
