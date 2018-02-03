package com.es.gantry.api;

import com.es.gantry.image.ImageService;
import com.es.gantry.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/images")
@Produces(MediaType.APPLICATION_JSON)
public class ImageResource {

    @Autowired
    ImageService service;

    @GET
    public Response getImages() {
        try {
            return ApiUtils.buildHttp200Ok("Yay !!!");
        } catch (Exception ex) {
            return ApiUtils.buildHttp500InternalServerError(ex.getMessage());

        }

    }
}
