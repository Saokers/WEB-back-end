package com.sybinal.shop.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AttachmentDetail {
    private Integer id;

    private Integer noteDataId;

    private String attachmentName;

    private String attachmentPath;

    private Integer makeEmp;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date makeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoteDataId() {
        return noteDataId;
    }

    public void setNoteDataId(Integer noteDataId) {
        this.noteDataId = noteDataId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath == null ? null : attachmentPath.trim();
    }

    public Integer getMakeEmp() {
        return makeEmp;
    }

    public void setMakeEmp(Integer makeEmp) {
        this.makeEmp = makeEmp;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

	@Override
	public String toString() {
		return "AttachmentDetail [id=" + id + ", noteDataId=" + noteDataId + ", attachmentName=" + attachmentName
				+ ", attachmentPath=" + attachmentPath + ", makeEmp=" + makeEmp + ", makeDate=" + makeDate + "]";
	}
    
}