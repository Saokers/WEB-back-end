package com.sybinal.shop.service.footprint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybinal.shop.mapper.FootPrintMapper;
import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.FootPrintExample;
import com.sybinal.shop.model.FootPrintExample.Criteria;
@Service
public class FootPrintServiceImpl implements FootPrintService{
	@Autowired
	private FootPrintMapper footprintmapper;
	
	@Override
	public int insert(FootPrint record) {
		// TODO Auto-generated method stub
		return footprintmapper.insert(record);
	}

	@Override
	public int equal(FootPrint record) {
		FootPrintExample example=new FootPrintExample();
		FootPrintExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(record.getUserId());
		createCriteria.andProductIdEqualTo(record.getProductId());
		List<FootPrint> selectByExample = footprintmapper.selectByExample(example);
		if(selectByExample.size()>0) {
			return selectByExample.get(0).getId();
		}else {
			return 0;
		}
		
	}

	@Override
	public int update(FootPrint record) {
		return footprintmapper.updateByPrimaryKey(record);
	}

	@Override
	public List<FootPrint> gettodayfoot(FootPrint footPrint) {
		
		Map<String ,List<FootPrint>> map=new HashMap<String, List<FootPrint>>(); 
		// TODO Auto-generated method stub
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String format = df.format(new Date());
		FootPrintExample example=new FootPrintExample();
		FootPrintExample.Criteria createCriteria = example.createCriteria();
		Date parse;
		try {
			parse = df.parse(format);
			createCriteria.andUserIdEqualTo(footPrint.getUserId());
			createCriteria.andDateTimeGreaterThanOrEqualTo(parse);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return footprintmapper.selectByExample(example);
	}

	@Override
	public List<FootPrint> gethistoryfoot(FootPrint footPrint) {
		// TODO Auto-generated method stub
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String format = df.format(new Date());
		FootPrintExample example=new FootPrintExample();
		FootPrintExample.Criteria createCriteria = example.createCriteria();
		Date parse;
		try {
			parse = df.parse(format);
			createCriteria.andUserIdEqualTo(footPrint.getUserId());
			createCriteria.andDateTimeLessThan(parse);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return footprintmapper.selectByExample(example);
	}

}
