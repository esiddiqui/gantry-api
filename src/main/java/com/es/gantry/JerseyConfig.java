package com.es.gantry;

import com.es.gantry.api.GenericExceptionMapper;
import com.es.gantry.api.ImageResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;


@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig {

    public void JerseyConfig() {
        configureEndpoints();
    }

    @PostConstruct
    private void configureEndpoints() {
        this.registerClasses(ImageResource.class
                /*,GenericExceptionMapper.class*/);
    }


}
