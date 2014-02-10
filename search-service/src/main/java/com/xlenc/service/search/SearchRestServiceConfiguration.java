package com.xlenc.service.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 7:34 PM
 */
public @Data
class SearchRestServiceConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("searchServer")
    private SearchServerConfiguration searchServerConfiguration = new SearchServerConfiguration();

    public SearchServerConfiguration getSearchServerConfiguration() {
        return searchServerConfiguration;
    }

}
