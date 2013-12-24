package com.xlenc.service.search;

import java.util.Map;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 9:16 PM
 */
public class SearchService {

    private SearchPersistence searchPersistence;

    public SearchService(SearchPersistence searchPersistence) {
        this.searchPersistence = searchPersistence;
    }

    public Map<String, Object> addIndexItem(String index, String type, String id, Map<String, Object> map) {
        return searchPersistence.addIndexItem(index, type, id, map);
    }

}
