<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>商城后台</title>
<jsp:include page="../commonCss.jsp" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/admin/vendor/webuploader/webuploader.css">
</head>
<body class="blank">
	<jsp:include page="../main/top.jsp" />
	<jsp:include page="../main/left.jsp" />
	<jsp:include page="../commonJs.jsp" />
	<script
		src="${pageContext.request.contextPath}/resources/admin/vendor/webuploader/webuploader.js"
		type="text/javascript"></script>
	<div class="content">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-2">
				<div class="hpanel">
					<input type="hidden" id="Aid">
					<div class="panel-body">
						<table id="noteInfoList" style="width: 100%;"
							class="table table-striped table-bordered table-hover"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="forwordform" action='<c:url value="/admin/note/show?${_csrf.parameterName}=${_csrf.token}" />' method='POST'>
	<input type="hidden" name="id" id="id"/>
    </form>
	<script type="text/javascript">
		var oTable;
		var upload;
		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");
		var contextPath = '${pageContext.request.contextPath}';
		$(function() {
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token);
			});
			noteInfoListData();
		});

		function noteInfoListData() {
			if (typeof oTable == 'undefined') {
				oTable = $('#noteInfoList')
						.dataTable(
								{
									'bPaginate' : true, // 翻页功能
									'sServerMethod' : 'POST', // 提交方式
									'bServerSide' : true,
									'bProcessing' : true,
									'bFilter' : false,
									"bSort" : false,
									'sAjaxSource' : contextPath
											+ '/admin/noteInfoDataTable',
									aoColumns : [
											{
												'mData' : 'id',
												'sTitle' : '编号',
												'sWidth' : '10%',
												'visible' : false
											},
											{
												'mData' : 'noteContent',
												'sTitle' : '内容',
												'sWidth' : '10%'
											},
											{
												'mData' : 'makeEmp',
												'sTitle' : '制作者',
												'sWidth' : '10%'
											},
											{
												'mData' : 'makeDate',
												'sTitle' : '制作时间',
												'sWidth' : '10%'
											},
											{
												'mData' : 'id',
												'sWidth' : '10%',
												'sTitle' : '操作',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<button id="update" class="btn btn-default btn-sm" onclick="saveNoteInfo(this)"><i class="fa fa-pencil"></i>编辑</button>&nbsp;&nbsp;<button id="del" class="btn btn-default btn-sm" onclick="delNoteInfo('
															+ data
															+ ')"><i class="fa fa-pencil"></i>删除</button>&nbsp;&nbsp;<button id="del" class="btn btn-default btn-sm" onclick="showNoteById('
															+ data
															+ ')"><i class="fa fa-pencil"></i>查看详情</button>';
													return returnValue;
												}
											} ]

								});
			} else {
				var oSettings = oTable.fnSettings();
				oSettings._iDisplayLength = parseInt($(
						'[name=noteInfoList_length] option:selected').val());
				$('.dataTables_length select').val(
						$('[name=noteInfoList_length] option:selected').val());
				oSettings._iDisplayStart = 0;
				oTable.fnDraw();
			}
		}

		function delNoteInfo(id) {
			$.ajax({
				url : contextPath + '/admin/deletenote',
				type : 'POST',
				dataType : 'json',
				data : {
					id : id
				},
				success : function(data) {
					if (data.error == 0) {
						swal("删除记录成功！", "成功", "success");
						noteInfoListData();
					} else {
						swal("删除记录失败！", "错误", "error");
					}
				},
				error : function() {
					swal("系统异常！", "失败", "error");
				}
			})
		}

		function showNoteById(id) {
			$("#id").val(id);;
			$("#forwordform").submit();
		}
		
	</script>
</body>
</html>