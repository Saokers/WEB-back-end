
package com.sybinal.shop.service.advert;

import java.util.Map;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.Advert;


public interface AdvertService {
	
	Map<String, Object> getAdvertInfoByCondition(PageInformation pageInfo);
	
	Integer updateImage(Advert advert);
	
	Integer insertImage(Advert advert);
	
	Integer deleteAdert(Integer id);
	
	Integer updateUrl(Advert advert);
}
