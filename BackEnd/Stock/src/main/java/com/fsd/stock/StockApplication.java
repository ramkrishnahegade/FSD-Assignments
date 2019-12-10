package com.fsd.stock;

import javax.annotation.PreDestroy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.SamplerAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;

//import io.netty.channel.nio.NioEventLoopGroup;

@SpringBootApplication
@EnableEurekaClient
public class StockApplication {

	//private NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}


	@Bean
	public SamplerAutoConfiguration defaultSampler() {
		return new SamplerAutoConfiguration();
	}	
	/*
	 * @Bean public MongoClientSettingsBuilderCustomizer sslCustomizer() { return
	 * clientSettingsBuilder -> clientSettingsBuilder
	 * .applyToSslSettings(SslSettings.builder().enabled(true)
	 * .invalidHostNameAllowed(true))
	 * .streamFactoryFactory(NettyStreamFactoryFactory.builder()
	 * .eventLoopGroup(eventLoopGroup).build()); }
	 */
	  
	/*
	 * @PreDestroy public void shutDownEventLoopGroup() { eventLoopGroup.shutdown();
	 * }
	 */
	 }
