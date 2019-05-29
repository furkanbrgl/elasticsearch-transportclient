package com.furkanbrgl.elastic.elasticsearchtransportclient;

import com.furkanbrgl.elastic.elasticsearchtransportclient.config.ElasticsearchConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElasticsearchTransportclientApplication {

	@Bean
	@ConfigurationProperties()
	public ElasticsearchConfig elasticsearchConfig() {
		return new ElasticsearchConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchTransportclientApplication.class, args);
	}

}
