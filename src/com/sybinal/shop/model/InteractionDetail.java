package com.sybinal.shop.model;

import java.util.Date;

public class InteractionDetail {
    private Integer id;

    private Integer noteDataId;

    private Integer makeEmp;

    private Date makeDate;

    private Integer dataType;

    private String commentaryDescription;

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

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getCommentaryDescription() {
        return commentaryDescription;
    }

    public void setCommentaryDescription(String commentaryDescription) {
        this.commentaryDescription = commentaryDescription == null ? null : commentaryDescription.trim();
    }

	@Override
	public String toString() {
		return "InteractionDetail [id=" + id + ", noteDataId=" + noteDataId + ", makeEmp=" + makeEmp + ", makeDate="
				+ makeDate + ", dataType=" + dataType + ", commentaryDescription=" + commentaryDescription + "]";
	}
    
    
}