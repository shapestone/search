package com.xlenc.service.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlenc.service.search.schematypes.TypeInfo;
import com.xlenc.service.search.schematypes.question.QuestionData;
import com.yammer.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 7:27 PM
 */
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    final static Logger logger = LoggerFactory.getLogger(SearchResource.class);
    private SearchService searchService;

    public SearchResource(SearchService searchService) {
        this.searchService = searchService;
    }

    @GET
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response getIndexDocumentData(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 @PathParam("id") String id) {
        if (!isValidType(type)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        final Object indexData;
        indexData = searchService.getIndexDocument(index, type, id);
        return Response.ok(indexData).build();
    }

    @DELETE
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response deleteIndexDocument(@PathParam("index") String index,
                                @PathParam("type") String type,
                                @PathParam("id") String id) {
        if (!isValidType(type)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        final Object stringObjectMap;
        stringObjectMap = searchService.deleteIndexDocument(index, type, id);
        return Response.ok(stringObjectMap).build();
    }


    @PUT
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response updateIndexItem(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 @PathParam("id") String id,
                                 String jsonObject) {
        if (!isValidType(type)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        final Object stringObjectMap;
        Object itemToIndex = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            itemToIndex = objectMapper.readValue(jsonObject, TypeInfo.getMappingClasses().get(type));
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Error occurred while trying to map input string to object!");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        stringObjectMap = searchService.updateIndexDocument(index, type, id, itemToIndex);
        return Response.ok(stringObjectMap).build();
    }

    private boolean isValidType(String type) {
        if (TypeInfo.getTypeList().contains(type)) {
            logger.error("Unrecognized 'type' specified!");
            return true;
        }
        return false;
    }

}
