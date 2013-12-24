package com.xlenc.service.search;

import java.util.Map;

/**
 * User: Michael Williams
 * Date: 12/7/13
 * Time: 11:55 AM
 */
public interface SearchPersistence {
    Map<String,Object> addIndexItem(String index, String type, String id, Map<String, Object> map);
}
