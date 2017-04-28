package com.paper.management.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumengyao on 17/4/20.
 */
@Table(name = "papers")
public class Papers implements Serializable {

    private static final long serialVersionUID = 2812753212750331908L;

    private String doi;

    private String paperName;

    private String notePath;

    private String noteSummary;

    private Date publishYear;

    private Date firstReadTime;

    private Date lastReadTime;

    private Date finishReadTime;
    private String paperPath;

    private List<Author> authors = new LinkedList<Author>();

    public List<Author> getAuthors() {
        return authors;
    }

    public void setPaperPath(String paperPath) {
        this.paperPath = paperPath;
    }

    public String getPaperPath() {
        return paperPath;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getNotePath() {
        return notePath;
    }

    public void setNotePath(String notePath) {
        this.notePath = notePath;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getNoteSummary() {
        return noteSummary;
    }

    public void setNoteSummary(String noteSummary) {
        this.noteSummary = noteSummary;
    }

    public Date getFirstReadTime() {
        return firstReadTime;
    }

    public void setFirstReadTime(Date firstReadTime) {
        this.firstReadTime = firstReadTime;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public Date getFinishReadTime() {
        return finishReadTime;
    }

    public void setFinishReadTime(Date finishReadTime) {
        this.finishReadTime = finishReadTime;
    }
}
