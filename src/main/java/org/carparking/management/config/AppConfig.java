package org.carparking.management.config;

import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author nareshd
 *
 */
@Configuration
@EnableTransactionManagement
public class AppConfig {
	@Bean
	@ConfigurationProperties(prefix = "parking.datasource")
	public DataSource parkingServiceDS() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return builder;
	}
}
