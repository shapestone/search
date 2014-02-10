package com.xlenc.service.search;


/**
 * User: Michael Williams
 * Date: 12/7/13
 * Time: 11:55 AM
 */
public interface SearchPersistence {
    Object updateIndexDocument(String index, String type, String id, String data);
    Object getIndexDocument(String index, String type, String id);
    Object deleteIndexDocument(String index, String type, String id);
}
