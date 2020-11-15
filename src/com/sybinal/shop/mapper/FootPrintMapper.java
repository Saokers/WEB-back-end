package com.sybinal.shop.mapper;

import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.FootPrintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootPrintMapper {
    long countByExample(FootPrintExample example);

    int deleteByExample(FootPrintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootPrint record);

    int insertSelective(FootPrint record);

    List<FootPrint> selectByExample(FootPrintExample example);

    FootPrint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootPrint record, @Param("example") FootPrintExample example);

    int updateByExample(@Param("record") FootPrint record, @Param("example") FootPrintExample example);

    int updateByPrimaryKeySelective(FootPrint record);

    int updateByPrimaryKey(FootPrint record);
    
    
}