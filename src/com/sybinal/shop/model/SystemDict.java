package com.sybinal.shop.model;

import java.math.BigDecimal;
import java.util.Date;

public class SystemDict {

	private int id;
	private String dictType;
	private String dictCode;
	private String dictName;
	private String remark;
	private BigDecimal flagStatus;
	private BigDecimal flag_sort;
	private int makeEmp;
	private Date makeDate;
	private int modifyEmp;
	private Date modifyDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(BigDecimal flagStatus) {
		this.flagStatus = flagStatus;
	}

	public BigDecimal getFlag_sort() {
		return flag_sort;
	}

	public void setFlag_sort(BigDecimal flag_sort) {
		this.flag_sort = flag_sort;
	}

	public int getMakeEmp() {
		return makeEmp;
	}

	public void setMakeEmp(int makeEmp) {
		this.makeEmp = makeEmp;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public int getModifyEmp() {
		return modifyEmp;
	}

	public void setModifyEmp(int modifyEmp) {
		this.modifyEmp = modifyEmp;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
