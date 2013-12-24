package com.xlenc.service.search;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 7:29 PM
 */
public class SearchServiceServer extends Service<SearchRestServiceConfiguration> {

    @Override
    public void initialize(Bootstrap<SearchRestServiceConfiguration> bootstrap) {
        bootstrap.setName("Search Rest Service");
    }

    @Override
    public void run(SearchRestServiceConfiguration configuration, Environment environment) throws Exception {
        setUpSwagger(environment);
        setUpSearchService(environment);
    }

    private void setUpSwagger(Environment environment) {
        environment.addResource(new ApiListingResourceJSON());
        environment.addProvider(new ResourceListingProvider());
        environment.addProvider(new ApiDeclarationProvider());
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());
        // Todo: Verify if this id needed for swagger to work
        ConfigFactory.config();
    }


    private void setUpSearchService(Environment environment) {

        final SearchServer searchServer = new SearchServer();
        environment.manage(searchServer);

        final SearchService searchService = new SearchService(searchServer);

        final SearchResource searchRestResource = new SearchResource(searchService);
        environment.addResource(searchRestResource);
    }

    public static void main(String[] args) throws Exception {
        new SearchServiceServer().run(args);
    }

}
