package com.xlenc.service.search.SchemaTypes.question;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qureshit
 * Date: 1/12/14
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionData {
    private String id;
    private String text;
    private String type;
    private String freeMium;
    private QualityControl qualityControl;
    private List<AnswerData> answers;
    private List<String> tags;
    private String difficultyLevel;
    private String author;
    private long version;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFreeMium() {
        return freeMium;
    }

    public void setFreeMium(String freeMium) {
        this.freeMium = freeMium;
    }

    public QualityControl getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControl qualityControl) {
        this.qualityControl = qualityControl;
    }

    public List<AnswerData> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerData> answers) {
        this.answers = answers;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
