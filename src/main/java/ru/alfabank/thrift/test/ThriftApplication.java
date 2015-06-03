package ru.alfabank.thrift.test;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.alfabank.thrift.service.EntityService;

import javax.servlet.Servlet;

/**
 * Created by aleksandr on 03.06.15.
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class ThriftApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThriftApplication.class, args);
    }

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public Servlet thriftServlet(TProtocolFactory protocolFactory, EntityServiceBean handler) {
        return new TServlet(new EntityService.Processor<>(handler), protocolFactory);
    }
}
