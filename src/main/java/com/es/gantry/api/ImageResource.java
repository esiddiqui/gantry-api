package com.es.gantry.api;

import com.es.gantry.image.ImageService;
import com.es.gantry.util.ApiUtils;
import com.spotify.docker.client.messages.Image;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;


@Component
@Path("/images")
@Produces(MediaType.APPLICATION_JSON)
public class ImageResource {

    @Autowired
    ImageService service;

    @GET
    public Response getImages(@QueryParam("pattern") String pattern) {
        try {
             if (StringUtils.isEmpty(pattern))
                return ApiUtils.buildHttp200Ok(service.findAll());
             else
                 return ApiUtils.buildHttp200Ok(service.findAllMatching(pattern));
        } catch (Exception ex) {
            return ApiUtils.buildHttp500InternalServerError(ex.getMessage());

        }
    }


    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id ) {
        try {
            Optional<Image> _image = this.service.findById(id);
            if (_image.isPresent())
                    return ApiUtils.buildHttp200Ok(_image.get());
            else return ApiUtils.buildHttp404NotFound(id);
        } catch (Exception ex) {
            return ApiUtils.buildHttp500InternalServerError(ex.getMessage());
        }
    }
}
