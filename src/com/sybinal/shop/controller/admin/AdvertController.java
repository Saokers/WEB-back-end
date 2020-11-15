package com.sybinal.shop.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sybinal.shop.common.ApiServiceException;
import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.Advert;
import com.sybinal.shop.service.advert.AdvertService;

@Controller
public class AdvertController {

	@Autowired
	AdvertService advertService;

	@RequestMapping(value = "/admin/advert", method = RequestMethod.GET)
	public ModelAndView getAdvert() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/advert/advertMain");
		return model;
	}

	@RequestMapping(value = "/admin/advertInfoDataTable", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> advertInfoDataTable(PageInformation pageInfo) {
		return advertService.getAdvertInfoByCondition(pageInfo);
	}
	
	@RequestMapping(value = "/admin/updateImage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateImage(@RequestBody Advert advert)throws ApiServiceException{
		int i = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			i = advertService.updateImage(advert);
			if (i > 0) {
				map.put("error", "0"); // 成功
				map.put("data", null); // 数据
			} else {
				map.put("error", "-1"); // 失败
			}
		} catch (Exception e) {
			map.put("error", "-1"); // 失败
		}
		return map;
	}
	
	@RequestMapping(value = "/admin/insertImage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertImage(@RequestBody Advert advert)throws ApiServiceException{
		int i = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		advert.setImage(advert.getImage());
		try {
			i = advertService.insertImage(advert);
			if (i > 0) {
				map.put("error", "0"); // 成功
				map.put("data", i); // 数据
			} else {
				map.put("error", "-1"); // 失败
			}
		} catch (Exception e) {
			map.put("error", "-1"); // 失败
		}
		return map;
	}
	
	
	@RequestMapping(value = "/admin/deleteAdert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteAdert(@RequestBody Advert advert)throws ApiServiceException{
		int i = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			i = advertService.deleteAdert(advert.getId());
			if (i > 0) {
				map.put("error", "0"); // 成功
				map.put("data", null); // 数据
			} else {
				map.put("error", "-1"); // 失败
			}
		} catch (Exception e) {
			map.put("error", "-1"); // 失败
		}
		return map;
	}
	
	@RequestMapping(value = "/admin/updateUrl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUrl(@RequestBody Advert advert)throws ApiServiceException{
		int i = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			i = advertService.updateUrl(advert);
			if (i > 0) {
				map.put("error", "0"); // 成功
				map.put("data", null); // 数据
			} else {
				map.put("error", "-1"); // 失败
			}
		} catch (Exception e) {
			map.put("error", "-1"); // 失败
		}
		return map;
	}
}
