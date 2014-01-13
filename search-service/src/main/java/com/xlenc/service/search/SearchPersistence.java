package com.xlenc.service.search;

import com.xlenc.service.search.SchemaTypes.question.QuestionData;

/**
 * User: Michael Williams
 * Date: 12/7/13
 * Time: 11:55 AM
 */
public interface SearchPersistence {
    Object updateQuestion(String index, String type, String id, QuestionData itemToIndex);
    Object addQuestion(String index, String type, QuestionData itemToIndex);
    QuestionData getQuestionData(String index, String type, String id);
    Object deleteQuestion(String index, String type, String id);
}
