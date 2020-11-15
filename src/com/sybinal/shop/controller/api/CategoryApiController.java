package com.sybinal.shop.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.service.catalog.CategoryService;

@RestController
@RequestMapping("api/v1")
public class CategoryApiController extends AbstractApiController {

	@Autowired
	CategoryService categoryService;

	/**
	 * 商品分类数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "catalog/category/{categoryId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject getCategoryByIdJSON(@PathVariable("categoryId") int categoryId) {
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap.put("categoryId",categoryId);
		Object re = null;
		if ((re = categoryService.getCategoryById(reqMap)) != null)
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		return this.reponseJSON(ApiResponseEnum.ERROR_PARAM.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), re);
	}

	/**
	 * 分类数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "catalog/all", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject searchAllCategory() {
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getAllCategory());
	}
	
	/**
	 * 分类数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "catalog/category/condition", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getCategoryByCondition(Map<String, Object> reqMap) {
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getCategoryByCondition(reqMap));
	}
	
	@RequestMapping(value = "catalog/category/condition", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject getCategoryByConditionVue(Map<String, Object> reqMap) {
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getCategoryByCondition(reqMap));
	}
	
	
	/**
	 * 查询主页数据 Category{ Product }
	 * 
	 * @return
	 */
	@RequestMapping(value = "catalog/category/product/{pageSize}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject searchIndexProductByHotJSON(@PathVariable("pageSize") int pageSize) {
		Map<String,Object> reqMap = new HashMap<String, Object>();
		reqMap.put("pageSize", pageSize);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getCategoryRelation(reqMap));
	}

}