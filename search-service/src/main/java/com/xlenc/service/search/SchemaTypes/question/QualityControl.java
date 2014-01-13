package com.xlenc.service.search.SchemaTypes.question;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qureshit
 * Date: 1/12/14
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class QualityControl {
        private String id;
        private String status;
        private List<String> reviewers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<String> reviewers) {
        this.reviewers = reviewers;
    }
}
