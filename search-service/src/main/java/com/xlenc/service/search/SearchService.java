package com.xlenc.service.search;

import com.xlenc.service.search.schematypes.question.QuestionData;

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

    public Object updateIndexDocument(String index, String type, String id, Object itemToIndex) {
        return searchPersistence.updateIndexDocument(index, type, id, itemToIndex);
    }

    public Object getIndexDocument(String index, String type, String id) {
        return searchPersistence.getIndexDocument(index, type, id);
    }

    public Object deleteIndexDocument(String index, String type, String id) {
        return searchPersistence.deleteIndexDocument(index, type, id);
    }
}
