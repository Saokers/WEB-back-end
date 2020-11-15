package com.sybinal.shop.mapper;

import com.sybinal.shop.model.Head;
import com.sybinal.shop.model.LabelDetail;

public interface LabelDetailMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Head head);

    int insertSelective(LabelDetail record);

    LabelDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelDetail record);

    int updateByPrimaryKey(LabelDetail record);
    
    int deleteHeadKey(Integer  id);
}