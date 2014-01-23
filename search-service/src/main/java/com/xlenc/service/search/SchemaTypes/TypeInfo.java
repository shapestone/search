package com.xlenc.service.search.schematypes;

import com.xlenc.service.search.schematypes.question.QuestionData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qureshit
 * Date: 1/15/14
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeInfo {
    private static List<String> typeList = new ArrayList<String>();
    private static Map<String,Class> mappingClasses = new HashMap<String, Class>();

    static{
        typeList.add("questions");
        mappingClasses.put("questions", QuestionData.class);
    }

    public static List<String> getTypeList(){
        return typeList;
    }
    public static Map<String,Class> getMappingClasses() {
        return mappingClasses;
    }
}
