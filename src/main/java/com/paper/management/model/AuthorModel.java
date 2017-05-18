package com.paper.management.model;

import com.paper.management.entity.Papers;

import java.io.Serializable;

/**
 * Created by liumengyao on 17/5/18.
 */
public class AuthorModel implements Serializable {

    private static final long serialVersionUID = 9198356746740500825L;
    private Long authorId;

    private String authorName;

    private String contact;

    private String comment;

    private PapersModel paper;

    public void setPaper(PapersModel paper) {
        this.paper = paper;
    }

    public PapersModel getPaper() {
        return paper;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
