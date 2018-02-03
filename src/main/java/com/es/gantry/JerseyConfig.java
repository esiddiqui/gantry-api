package com.es.gantry;

import com.es.gantry.api.ImageResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public void JerseyConfig() {
        this.packages("com.es.gantry.api");
        this.registerClasses(ImageResource.class);
    }



}
