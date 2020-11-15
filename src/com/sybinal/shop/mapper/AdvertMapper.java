package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.Advert;

public interface AdvertMapper {

	List<Advert> selectAdvertByCondition();
	
	Integer selectCountByCondition();
	
	Integer updateImage(Advert advert);
	
	Integer deleteAdert(Integer id);
	
	Integer insertImage(Advert advert);
	
	Integer getMaxSortId();
	
	Integer updateUrl(Advert advert);
}
