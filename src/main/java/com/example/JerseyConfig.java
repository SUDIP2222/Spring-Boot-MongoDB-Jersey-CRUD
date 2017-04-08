package com.example;

import com.example.Controller.EmployeeController;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.ws.rs.ApplicationPath;

/**
 * Created by sudip sarker on 4/9/2017.
 */
@Configuration
@Controller
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){

        register(MultiPartFeature.class);

        register(EmployeeController.class);

    }
}
