package com.sybinal.shop.service.advert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.mapper.AdvertMapper;
import com.sybinal.shop.model.Advert;
import com.sybinal.shop.utils.PagingTool;

@Service
public class AdvertServicelmpl implements AdvertService {

	@Autowired
	AdvertMapper advertMapper;

	@Autowired
	PagingTool pagingTool;

	@Override
	public Map<String, Object> getAdvertInfoByCondition(PageInformation pageInfo) {
		// TODO Auto-generated method stub
		int pageCount = advertMapper.selectCountByCondition();
		List<Advert> listAdvert = pagingTool.PagingData(
					"com.sybinal.shop.mapper.AdvertMapper.selectAdvertByCondition", null,
					Integer.parseInt(pageInfo.getiDisplayStart()) / Integer.parseInt(pageInfo.getiDisplayLength()) + 1,
					Integer.parseInt(pageInfo.getiDisplayLength()));
		
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("sEcho", pageInfo.getsEcho());
		datas.put("iTotalRecords", pageCount);
		datas.put("iTotalDisplayRecords", pageCount);
		datas.put("aaData", listAdvert);
		
		return datas;
	}

	@Override
	public Integer updateImage(Advert advert) {
		// TODO Auto-generated method stub
		return advertMapper.updateImage(advert);
	}

	@Override
	public Integer deleteAdert(Integer id) {
		// TODO Auto-generated method stub
		return advertMapper.deleteAdert(id);
	}

	@Override
	public Integer insertImage(Advert advert) {
		// TODO Auto-generated method stub
		Integer sortId = advertMapper.getMaxSortId();
		advert.setSortId(sortId+1);
		advertMapper.insertImage(advert);
		return advert.getId();
	}

	@Override
	public Integer updateUrl(Advert advert) {
		// TODO Auto-generated method stub
		return advertMapper.updateUrl(advert);
	}
}
