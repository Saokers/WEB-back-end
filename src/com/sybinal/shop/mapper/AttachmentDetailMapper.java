package com.sybinal.shop.mapper;

import com.sybinal.shop.model.AttachmentDetail;
import com.sybinal.shop.model.Head;

public interface AttachmentDetailMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Head head);

    int insertSelective(AttachmentDetail record);

    AttachmentDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttachmentDetail record);

    int updateByPrimaryKey(AttachmentDetail record);
    
    int deleteByHeadKey(Integer id);
}