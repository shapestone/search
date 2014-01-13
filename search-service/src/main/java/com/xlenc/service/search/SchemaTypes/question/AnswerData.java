package com.xlenc.service.search.SchemaTypes.question;

/**
 * Created with IntelliJ IDEA.
 * User: qureshit
 * Date: 1/12/14
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnswerData {
    private String id;
    private String text;
    private boolean correct;
    private int ordinal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
