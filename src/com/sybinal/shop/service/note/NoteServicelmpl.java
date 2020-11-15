package com.sybinal.shop.service.note;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.mapper.AttachmentDetailMapper;
import com.sybinal.shop.mapper.HeadMapper;
import com.sybinal.shop.mapper.InteractionDetailMapper;
import com.sybinal.shop.mapper.LabelDetailMapper;
import com.sybinal.shop.mapper.UserMapper;
import com.sybinal.shop.model.Head;
import com.sybinal.shop.model.HeadVo;
import com.sybinal.shop.model.InteractionDetail;
import com.sybinal.shop.model.SystemDict;
import com.sybinal.shop.model.User;
import com.sybinal.shop.utils.Constants;
import com.sybinal.shop.utils.Page;
import com.sybinal.shop.utils.PagingTool;

@Service
public class NoteServicelmpl implements NoteService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	HeadMapper headMapper;

	@Autowired
	LabelDetailMapper labelDetailMapper;

	@Autowired
	AttachmentDetailMapper attachmentDetailMapper;

	@Autowired
	PagingTool pagingTool;

	@Autowired
	InteractionDetailMapper interactionDetailMapper;

	@Override
	@Transactional
	public Integer setNoteData_Attachment(Head head) {
		// TODO Auto-generated method stub
		head.setMakeDate(new Date());
		headMapper.insert(head);
		attachmentDetailMapper.insert(head);
		return head.getId();
	}

	@Override
	public Integer setNoteData_Label(Head head) {
		// TODO Auto-generated method stub
		head.setMakeDate(new Date());
		return labelDetailMapper.insert(head);
	}

	@Override
	public Integer setNoteData_Content(Head head) {
		// TODO Auto-generated method stub
		return headMapper.updateByPrimaryKeySelective(head);
	}

	@Override
	public Integer updateNoteData_Attachment(Head head) {
		// TODO Auto-generated method stub
		Integer id = head.getId();
		Integer i = attachmentDetailMapper.deleteByHeadKey(id);
		if (i > 0) {
			head.setMakeDate(new Date());
			attachmentDetailMapper.insert(head);
		}
		return i;
	}

	@Override
	@Transactional
	public Integer setNoteData(Head head) {
		// TODO Auto-generated method stub
		    head.setMakeDate(new Date());
			headMapper.insert(head);
			attachmentDetailMapper.insert(head);
			labelDetailMapper.insert(head);
			headMapper.updateByPrimaryKeySelective(head);
		    return head.getId();
	}

	@Override
	public List<SystemDict> getSysDataDict(String dictType) {
		// TODO Auto-generated method stub
		return headMapper.getSysDataDict(dictType);
	}

	@Override
	public Map<String, Object> getNoteData(Head head) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<>();
		int dataType = head.getDataType();
		int pageCount = 0;
		 
		List<Head> rows_data = new ArrayList<>();
		HeadVo headvo = new HeadVo();
		headvo.setPageSize(Constants.PAGE_NUMBER);
		headvo.setPageNum((head.getNowPage() - 1) * Constants.PAGE_NUMBER);
		List<User> users=new ArrayList<>();
		if (dataType == 1) {	
			//System.out.println(head);
			headvo.setMakeEmp(head.getMakeEmp());
			pageCount = headMapper.getCountByMakeEmp(head);
			rows_data = headMapper.getNoteData(headvo);
			for (Head head1 : rows_data) {
				User user=userMapper.selectByName(head1.getUserName());
				users.add(user);
			}
		} else if (dataType == 2) {
			pageCount = headMapper.getCount();
			rows_data = headMapper.getAllNoteData(headvo);
			for (Head head1 : rows_data) {
				User user=userMapper.selectByName(head1.getUserName());
				users.add(user);
			}
		}
		map.put("nowPage", head.getNowPage());
		// 计算总页数
		map.put("pageCount", Page.confirmPage(pageCount, Constants.PAGE_NUMBER));
		map.put("rows_data", rows_data);
		map.put("users",users);
		return map;
	}

	@Override
	public Map<String, Object> getnoteInfoDataTable(PageInformation pageInfo) {
		// TODO Auto-generated method stub
		int pageCount = headMapper.getCount();
		HeadVo headvo = new HeadVo();
		headvo.setPageSize(Integer.parseInt(pageInfo.getiDisplayLength()));
		headvo.setPageNum(Integer.parseInt(pageInfo.getiDisplayStart()) / Integer.parseInt(pageInfo.getiDisplayLength())
				* Integer.parseInt(pageInfo.getiDisplayLength()));
		List<Head> listNote = headMapper.getManageNoteData(headvo);
		HashMap<String, Object> datas = new HashMap<String, Object>();

		datas.put("sEcho", pageInfo.getsEcho());
		datas.put("iTotalRecords", pageCount);
		datas.put("iTotalDisplayRecords", pageCount);
		datas.put("aaData", listNote);

		return datas;
	}

	@Override
	@Transactional
	public int deleteNote(int id) {
		// TODO Auto-generated method stub
		headMapper.deleteByPrimaryKey(id);
		labelDetailMapper.deleteHeadKey(id);
		attachmentDetailMapper.deleteByHeadKey(id);
		interactionDetailMapper.deleteHeadKey(id);
		return 1;
	}

	@Override
	public Head getNoteById(int id) {
		// TODO Auto-generated method stub
		return headMapper.getManageNoteDataById(id);
	}

	@Override
	public int setInteraction(InteractionDetail interactionDetail) {
		// TODO Auto-generated method stub
		interactionDetail.setMakeDate(new Date());
		return interactionDetailMapper.setInteraction(interactionDetail);
	}

	@Override
	public int selectCount(InteractionDetail interactionDetail) {
        return interactionDetailMapper.selectCount(interactionDetail);
	}

}
