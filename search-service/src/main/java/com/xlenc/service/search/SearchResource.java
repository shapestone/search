package com.xlenc.service.search;

import com.xlenc.service.search.SchemaTypes.question.QuestionData;
import com.yammer.metrics.annotation.Timed;

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

    private SearchService searchService;

    public SearchResource(SearchService searchService) {
        this.searchService = searchService;
    }

    @GET
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response getQuestion(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 @PathParam("id") String id) {
        final QuestionData questionData;
        questionData = searchService.getQuestion(index, type, id);
        return Response.ok(questionData).build();
    }

    @DELETE
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response deleteQuestion(@PathParam("index") String index,
                                @PathParam("type") String type,
                                @PathParam("id") String id) {
        final Object stringObjectMap;
        stringObjectMap = searchService.deleteQuestion(index, type, id);
        return Response.ok(stringObjectMap).build();
    }


    @PUT
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response updateIndexItem(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 @PathParam("id") String id,
                                 QuestionData itemToIndex) {
        final Object stringObjectMap;
        stringObjectMap = searchService.updateQuestion(index, type, id, itemToIndex);
        return Response.ok(stringObjectMap).build();
    }

    @POST
    @Timed
    @Path("/{index}/{type}")
    public Response addIndexItem(@PathParam("index") String index,
                                    @PathParam("type") String type,
                                    QuestionData itemToIndex) {
        final Object stringObjectMap;
        stringObjectMap = searchService.addQuestion(index, type, itemToIndex);
        return Response.ok(stringObjectMap).build();
    }
}
