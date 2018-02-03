package com.es.gantry.util;

import com.es.gantry.core.GenericResponse;
import org.springframework.data.domain.Page;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static com.es.gantry.util.ApiUtils.Header.*;

/**
 * Utility class for API response builders, header and other common constants
 */
public class ApiUtils {

    public static class Header {
        public static final String X_LENGTH ="X-Length";
        public static final String X_PAGE ="X-Page";
        public static final String X_TOTAL="X-Total";
        public static final String X_TOTAL_PAGES="X-Total-Pages";
    }

    public static class HttpStatus {

        public static final int HTTP_200 = 200;
        public static final int HTTP_201 = 201;
        public static final int HTTP_400 = 400;
        public static final int HTTP_401 = 401;
        public static final int HTTP_403 = 403;
        public static final int HTTP_404 = 404;
        public static final int HTTP_500 = 500;

        public static final String HTTP_200_OK = "OK";
        public static final String HTTP_201_CREATED = "Created";
        public static final String HTTP_400_BAD_REQUEST = "Bad Request";
        public static final String HTTP_401_UNAUTHORIZED = "Unauthorized";
        public static final String HTTP_403_FORBIDDEN = "Forbidden";
        public static final String HTTP_404_NOT_FOUND = "Not Found";
        public static final String HTTP_500_INTERNAL_SERVER_ERROR = "Internal Server Error";
    }

    public enum YesNoParameter {
        YES(1), NO(0);

        private int type = 0;

        YesNoParameter(int type) {
            this.type=type;
        }

        public static YesNoParameter fromString(String value) {
            if ("yes".equalsIgnoreCase(value))
                return YesNoParameter.YES;
            else
                return YesNoParameter.NO;
        }

        /**
         * Equates to YesNoParameter.YES is true & YesNoParameter.NO is false
         *
         * @return a boolean representation
         */
        public boolean toBoolean() {
            return type==1;
        }
    }

    public static Response buildHttp200Ok(Object entity) {
        return Response.ok().entity(entity).build();
    }

    public static Response buildHttp200OkPageable(Page page) {
        return Response.ok()
                .header(X_LENGTH, page.getNumberOfElements())
                .header(X_PAGE, page.getNumber())
                .header(X_TOTAL, page.getTotalElements())
                .header(X_TOTAL_PAGES, page.getTotalPages()).entity(page.getContent()).build();
    }

    public static Response buildHttp201Created(Object id) {
        return Response.status(Status.CREATED).entity(new GenericResponse(id + " was created")).build();
    }

    public static Response buildHttp400BadRequest() {
        return  Response.status(Status.BAD_REQUEST).entity(new GenericResponse("")).build();
    }

    public static Response buildHttp400BadRequest(String message) {
        return  Response.status(Status.BAD_REQUEST).entity(new GenericResponse(message)).build();
    }

    public static Response buildHttp404NotFound() {
        return  Response.status(Status.NOT_FOUND).entity(new GenericResponse("")).build();
    }
    public static Response buildHttp404NotFound(Object id) {
        String idStr = id==null?"Object":id.toString();
        return  Response.status(Status.NOT_FOUND).entity(new GenericResponse(idStr + " not found")).build();
    }

    public static Response buildHttp500InternalServerError() {
        return  Response.serverError().entity(new GenericResponse("")).build();
    }

    public static Response buildHttp500InternalServerError(String message) {
        return  Response.serverError().entity(new GenericResponse(message)).build();
    }

}


