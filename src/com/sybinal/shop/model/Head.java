package com.sybinal.shop.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Head{
    private Integer id;

    private String noteContent;

    private Integer dataDictId;

    private Integer flagDelete;

    private Integer makeEmp;

    private Integer isPraise;
    
    private Integer isCollection;
    
    private String topicName;
    
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date makeDate;

    private Integer praiseNum;
    
    private Integer collectionNum;
    
    private Integer commentaryNum;
    
    private Integer modifyEmp;

    private Date modifyDate;
    
    private Integer opType;
    
    private Integer dataType;
    
    private Integer nowPage;
    
    private String userName;
    
    private String image;
    
	List<LabelDetail> label_rows_data;
    
    List<AttachmentDetail> attachment_rows_data;
    
    List<InteractionDetail> interaction_rows_data;

      
	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Integer getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(Integer isPraise) {
		this.isPraise = isPraise;
	}

	public Integer getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Integer isCollection) {
		this.isCollection = isCollection;
	}
    
    public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}

	public Integer getCommentaryNum() {
		return commentaryNum;
	}

	public void setCommentaryNum(Integer commentaryNum) {
		this.commentaryNum = commentaryNum;
	}

	public Integer getOpType() {
		return opType;
	}

	public void setOpType(Integer opType) {
		this.opType = opType;
	}
    
    public List<InteractionDetail> getInteraction_rows_data() {
		return interaction_rows_data;
	}

	public void setInteraction_rows_data(List<InteractionDetail> interaction_rows_data) {
		this.interaction_rows_data = interaction_rows_data;
	}

	public List<LabelDetail> getLabel_rows_data() {
		return label_rows_data;
	}

	public void setLabel_rows_data(List<LabelDetail> label_rows_data) {
		this.label_rows_data = label_rows_data;
	}

	public List<AttachmentDetail> getAttachment_rows_data() {
		return attachment_rows_data;
	}

	public void setAttachment_rows_data(List<AttachmentDetail> attachment_rows_data) {
		this.attachment_rows_data = attachment_rows_data;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent == null ? null : noteContent.trim();
    }

    public Integer getDataDictId() {
        return dataDictId;
    }

    public void setDataDictId(Integer dataDictId) {
        this.dataDictId = dataDictId;
    }

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
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

    public Integer getModifyEmp() {
        return modifyEmp;
    }

    public void setModifyEmp(Integer modifyEmp) {
        this.modifyEmp = modifyEmp;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

	@Override
	public String toString() {
		return "Head [id=" + id + ", noteContent=" + noteContent + ", dataDictId=" + dataDictId + ", flagDelete="
				+ flagDelete + ", makeEmp=" + makeEmp + ", isPraise=" + isPraise + ", isCollection=" + isCollection
				+ ", topicName=" + topicName + ", makeDate=" + makeDate + ", praiseNum=" + praiseNum
				+ ", collectionNum=" + collectionNum + ", commentaryNum=" + commentaryNum + ", modifyEmp=" + modifyEmp
				+ ", modifyDate=" + modifyDate + ", opType=" + opType + ", dataType=" + dataType + ", nowPage="
				+ nowPage + ", userName=" + userName + ", image=" + image + ", label_rows_data=" + label_rows_data
				+ ", attachment_rows_data=" + attachment_rows_data + ", interaction_rows_data=" + interaction_rows_data
				+ "]";
	}  
}