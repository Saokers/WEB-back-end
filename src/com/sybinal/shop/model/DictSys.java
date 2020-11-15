package com.sybinal.shop.model;

import java.util.Date;

public class DictSys {
    private Integer id;

    private String dictType;

    private String dictCode;

    private String dictName;

    private String remark;

    private Short flagStatus;

    private Long flagSort;

    private Integer makeEmp;

    private Date makeDate;

    private Integer modifyEmp;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Short flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Long getFlagSort() {
        return flagSort;
    }

    public void setFlagSort(Long flagSort) {
        this.flagSort = flagSort;
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