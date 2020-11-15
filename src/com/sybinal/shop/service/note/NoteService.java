package com.sybinal.shop.service.note;

import java.util.List;
import java.util.Map;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.Head;
import com.sybinal.shop.model.InteractionDetail;
import com.sybinal.shop.model.SystemDict;

public interface NoteService {

	public Integer setNoteData_Attachment(Head head);

	public Integer setNoteData_Label(Head head);

	public Integer setNoteData_Content(Head head);

	public Integer updateNoteData_Attachment(Head head);

	public Integer setNoteData(Head head);

	public List<SystemDict> getSysDataDict(String dictType);

	public Map<String, Object> getNoteData(Head head);
	
	public Map<String, Object> getnoteInfoDataTable(PageInformation pageInfo);
	
	public int deleteNote(int id);
	
	public Head getNoteById(int id);
	
	public int setInteraction(InteractionDetail interactionDetail);
	
	public int selectCount(InteractionDetail interactionDetail);
	
}
