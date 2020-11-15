package com.sybinal.shop.mapper;

import com.sybinal.shop.model.DictSys;

public interface DictSysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictSys record);

    int insertSelective(DictSys record);

    DictSys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictSys record);

    int updateByPrimaryKey(DictSys record);
}