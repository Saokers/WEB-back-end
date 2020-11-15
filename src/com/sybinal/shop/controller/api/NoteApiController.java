package com.sybinal.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.common.ApiServiceException;
import com.sybinal.shop.model.Head;
import com.sybinal.shop.model.InteractionDetail;
import com.sybinal.shop.model.SystemDict;
import com.sybinal.shop.service.note.NoteService;

@RestController
@RequestMapping("api/v1")
public class NoteApiController extends AbstractApiController {

	@Autowired
	NoteService noteService;

//	/**
//	 * 添加附件
//	 * 
//	 * @param head
//	 * @return
//	 * @throws ApiServiceException
//	 */
//	@RequestMapping(value = "note/setNoteData_Attachment", method = RequestMethod.POST, headers = "Accept=application/json")
//	public ApiResponseObject setNoteData_Attachment(@RequestBody Head head) throws ApiServiceException {
//		Object re = null;
//		Integer opType = head.getOpType();
//		if (opType == null) {
//			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), "请选择操作类型！");
//		} else if (opType == 1) {// 新增
//			if ((Integer) (re = noteService.setNoteData_Attachment(head)) != 0) {
//				return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//			} else {
//				return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//			}
//		} else {
//			// 修改操作
//			if ((Integer) (re = noteService.updateNoteData_Attachment(head)) != 0) {
//				return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//			} else {
//				return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//			}
//		}
//	}
//
//	/**
//	 * 添加标签
//	 * 
//	 * @param head
//	 * @return
//	 * @throws ApiServiceException
//	 */
//	@RequestMapping(value = "note/setNoteData_Label", method = RequestMethod.POST, headers = "Accept=application/json")
//	public ApiResponseObject setNoteData_Label(@RequestBody Head head) throws ApiServiceException {
//		Object re = null;
//		if ((Integer) (re = noteService.setNoteData_Label(head)) != 0) {
//			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//		} else {
//			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//		}
//	}
//
//	/**
//	 * 添加笔记内容(参与话题)
//	 * 
//	 * @param head
//	 * @return
//	 * @throws ApiServiceException
//	 */
//	@RequestMapping(value = "note/setNoteData_Content", method = RequestMethod.POST, headers = "Accept=application/json")
//	public ApiResponseObject setNoteData_Content(@RequestBody Head head) throws ApiServiceException {
//		Object re = null;
//		if ((Integer) (re = noteService.setNoteData_Content(head)) != 0) {
//			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//		} else {
//			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
//		}
//	}

	/**
	 * 发布笔记
	 * 
	 * @param head
	 * @return
	 * @throws ApiServiceException
	 */
	@RequestMapping(value = "note/setNoteData", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject setNoteData(@RequestBody Head head) throws ApiServiceException {
		Object re = null;
		if ((Integer) (re = noteService.setNoteData(head)) != 0) {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		} else {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		}
	}
	

	/**
	 * 获取基础数据（标签 10 话题 11）
	 * 
	 * @param dictType
	 * @return
	 * @throws ApiServiceException
	 */
	@RequestMapping(value = "note/getSysDataDict", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getSysDataDict(@RequestBody SystemDict systemDict) throws ApiServiceException {
		Object re = null;
		if ((re = noteService.getSysDataDict(systemDict.getDictType())) != null) {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		} else {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		}
	}

	/**
	 * 笔记瀑布流
	 * 
	 * @param head
	 * @return
	 * @throws ApiServiceException
	 */
	@RequestMapping(value = "note/getNoteData", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getNoteData(@RequestBody Head head) throws ApiServiceException {
		Object re = null;
		if ((re = noteService.getNoteData(head)) != null) {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		} else {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		}
	}

	/**
	 * 添加评论
	 * 
	 * @param interactionDetail
	 * @return
	 * @throws ApiServiceException
	 */
	@RequestMapping(value = "note/setInteraction", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject setInteraction(@RequestBody InteractionDetail interactionDetail)
			throws ApiServiceException {
		Integer re = null;
		if ((re = noteService.setInteraction(interactionDetail)) != 0) {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		} else {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), re);
		}
	}
	
	
	/**
	 * 查询点赞数
	 */
	@RequestMapping(value = "note/selectCount", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject selectCount(@RequestBody InteractionDetail interactionDetail) {
		int number = noteService.selectCount(interactionDetail);
		if(number !=0) {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), number);
		}
		return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.SUCCESS.getName(), number);
	}
	
	
	
	
	
}
