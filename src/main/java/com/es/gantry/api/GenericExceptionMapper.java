package com.es.gantry.api;

import com.es.gantry.util.ApiUtils;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper {

    @Override
    public Response toResponse(Throwable exception) {
        return ApiUtils.buildHttp500InternalServerError(exception.getMessage());
    }
}