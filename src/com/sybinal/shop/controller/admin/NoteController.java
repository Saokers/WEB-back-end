package com.sybinal.shop.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.Head;
import com.sybinal.shop.service.note.NoteService;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value = "/admin/note", method = RequestMethod.GET)
	public ModelAndView getAdvert() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/note/noteMain");
		return model;
	}
	
	@RequestMapping(value = "/admin/noteInfoDataTable", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noteInfoDataTable(PageInformation pageInfo) {
		return noteService.getnoteInfoDataTable(pageInfo);
	}
	
	@RequestMapping(value = "/admin/deletenote", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteNote(@RequestParam("id") int id) {
		int i;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			i = noteService.deleteNote(id);
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
	
	@RequestMapping(value = "/admin/note/show", method = RequestMethod.POST)
	public ModelAndView getNoteById(@RequestParam("id") int id) {
		Head head = noteService.getNoteById(id);
		ModelAndView model = new ModelAndView();
		model.addObject("note", head);
		model.setViewName("admin/note/showNote");
		return model;
	}
	
}
