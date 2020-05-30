package com.brain.software.config;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.brain.software.resource.ArtistResource;

 
@Component

public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
        register(ArtistResource.class);
    }
}