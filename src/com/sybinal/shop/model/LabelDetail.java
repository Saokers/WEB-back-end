package com.sybinal.shop.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LabelDetail {
    private Integer id;

    private Integer noteDataId;

    private Integer dataDictId;

    private Integer makeEmp;
    
    private String labelName;

    public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

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

    public Integer getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(Integer dataDictId) {
        this.dataDictId = dataDictId;
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
		return "LabelDetail [id=" + id + ", noteDataId=" + noteDataId + ", dataDictId=" + dataDictId + ", makeEmp="
				+ makeEmp + ", labelName=" + labelName + ", makeDate=" + makeDate + "]";
	}
    
}