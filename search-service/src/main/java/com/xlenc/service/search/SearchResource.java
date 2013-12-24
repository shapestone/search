package com.xlenc.service.search;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

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

    @PUT
    @Timed
    @Path("/{index}/{type}/{id}")
    public Response addIndexItem(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 @PathParam("id") String id,
                                 Map<String, Object> map) {
        final Map<String, Object> stringObjectMap;
        stringObjectMap = searchService.addIndexItem(index, type, id, map);
        return Response.ok(stringObjectMap).build();
    }
}
