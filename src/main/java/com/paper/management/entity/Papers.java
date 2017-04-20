package com.paper.management.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

/**
 * Created by liumengyao on 17/4/20.
 */
@Table(name = "papers")
public class Papers implements Serializable{

    private static final long serialVersionUID = 2812753212750331908L;

    private String doi;

    private String paperName;

    private String notePath;

    private String noteSummary;

    private Year publishYear;

    private Date firstReadTime;

    private Date lastReadTime;

    private Date finishReadTime;

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

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
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
