package com.sybinal.shop.service.footprint;

import java.util.List;

import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.model.FootPrint;

public interface FootPrintService {
	public int insert(FootPrint record);

	public int equal(FootPrint record);

	public int update(FootPrint record);

	public List<FootPrint> gettodayfoot(FootPrint footPrint);

	public List<FootPrint> gethistoryfoot(FootPrint footPrint);
}
