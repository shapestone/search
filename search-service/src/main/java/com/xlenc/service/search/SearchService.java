package com.xlenc.service.search;

import com.xlenc.service.search.SchemaTypes.question.QuestionData;

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

    public Object updateQuestion(String index, String type, String id, QuestionData itemToIndex) {
        return searchPersistence.updateQuestion(index, type, id, itemToIndex);
    }

    public Object addQuestion(String index, String type, QuestionData itemToIndex) {
        return searchPersistence.addQuestion(index, type, itemToIndex);
    }

    public QuestionData getQuestion(String index, String type, String id) {
        return searchPersistence.getQuestionData(index, type, id);
    }

    public Object deleteQuestion(String index, String type, String id) {
        return searchPersistence.deleteQuestion(index, type, id);
    }
}
