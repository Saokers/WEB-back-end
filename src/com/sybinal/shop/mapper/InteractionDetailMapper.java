package com.sybinal.shop.mapper;

import com.sybinal.shop.model.InteractionDetail;

public interface InteractionDetailMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteHeadKey(Integer id);

    int insert(InteractionDetail record);

    int insertSelective(InteractionDetail record);

    InteractionDetail selectByPrimaryKey(Integer id);
    
    int selectCount(InteractionDetail record);

    int updateByPrimaryKeySelective(InteractionDetail record);

    int updateByPrimaryKey(InteractionDetail record);
    
    int setInteraction(InteractionDetail interactionDetail);
}