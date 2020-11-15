package com.sybinal.shop.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice {
    private Integer id;

    private Integer noticeType;

    private Date noticeDate;

    private String noticeInfo;

    private Integer billPkid;

    private Integer toEmp;

    private Integer flagStatus;

    private Integer receiveEmp;

    private Integer makeEmp;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date makeDate;

    private Integer modifyEmp;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeInfo() {
        return noticeInfo;
    }

    public void setNoticeInfo(String noticeInfo) {
        this.noticeInfo = noticeInfo == null ? null : noticeInfo.trim();
    }

    public Integer getBillPkid() {
        return billPkid;
    }

    public void setBillPkid(Integer billPkid) {
        this.billPkid = billPkid;
    }

    public Integer getToEmp() {
        return toEmp;
    }

    public void setToEmp(Integer toEmp) {
        this.toEmp = toEmp;
    }

    public Integer getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Integer getReceiveEmp() {
        return receiveEmp;
    }

    public void setReceiveEmp(Integer receiveEmp) {
        this.receiveEmp = receiveEmp;
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
}