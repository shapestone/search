package com.xlenc.service.search;

import com.xlenc.service.search.schematypes.question.QuestionData;

/**
 * User: Michael Williams
 * Date: 12/7/13
 * Time: 11:55 AM
 */
public interface SearchPersistence {
    Object updateIndexDocument(String index, String type, String id, Object itemToIndex);
    Object getIndexDocument(String index, String type, String id);
    Object deleteIndexDocument(String index, String type, String id);
}
