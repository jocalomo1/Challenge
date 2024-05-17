package org.Challenge.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {
    private final WSInterceptor wsInterceptor;

    public WSConfig(WSInterceptor wsInterceptor) {
        this.wsInterceptor = wsInterceptor;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "PokemonApi")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonApiSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PokemonApi");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://jocalomo.dev/challenge");
        wsdl11Definition.setSchema(pokemonApiSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema pokemonApiSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    }

    public void addInterceptors(List<EndpointInterceptor> registry) {
        try {
            registry.add(wsInterceptor);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
