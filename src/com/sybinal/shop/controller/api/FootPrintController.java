package com.sybinal.shop.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sybinal.shop.common.AjaxResult;
import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.model.Comments;
import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.service.footprint.FootPrintService;

@RestController
@RequestMapping("api/v1")
public class FootPrintController extends AbstractApiController {
	@Autowired
	FootPrintService footPrintService;

	@RequestMapping(value = "footprint/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject addFootPrint(@RequestBody FootPrint footPrint) {
		footPrint.setDateTime(new Date());
		int id = footPrintService.equal(footPrint);
		if (id != 0) {
			footPrint.setId(id);
			footPrintService.update(footPrint);
		} else {
			footPrintService.insert(footPrint);
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),
				new AjaxResult(true));
	}

	@RequestMapping(value = "footprint/select", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Map<String, List<FootPrint>> getFootPrint(@RequestBody FootPrint footPrint) {
		Map<String, List<FootPrint>> map = new HashMap<>();
		List<FootPrint> gettodayfoot = footPrintService.gettodayfoot(footPrint);
		List<FootPrint> gettodayfoot2 = footPrintService.gethistoryfoot(footPrint);
		map.put("today", gettodayfoot);
		map.put("history", gettodayfoot2);
		return map;
	}

}
