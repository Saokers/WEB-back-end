package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.Head;
import com.sybinal.shop.model.HeadVo;
import com.sybinal.shop.model.SystemDict;

public interface HeadMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Head record);

	int insertSelective(Head record);

	Head selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Head record);

	int updateByPrimaryKey(Head record);

	List<SystemDict> getSysDataDict(String dictType);

	List<Head> getNoteData(HeadVo headvo);

	List<Head> getAllNoteData(HeadVo headvo);

	int getCountByMakeEmp(Head head);

	int getCount();

	List<Head> getManageNoteData(HeadVo headvo);

	Head getManageNoteDataById(int id);
}