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
						<table id="advertInfoList" style="width: 100%;"
							class="table table-striped table-bordered table-hover"></table>
					</div>
				</div>
				<div>
					<button class="btn btn-primary" id="creatrow">新建</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="color-line"></div>
				<div class="text-center col-lg-12"
					style="width: 100%; height: 60px; background-color: white;">
					<h6 class="modal-title">更新图片</h6>
				</div>
				<div class="modal-body">
					<input type="hidden" id="Mid">
					<div id="uploader-demo">
						<div id="filePicker">选择图片</div>
						<div style='padding-top: 10px'>上传图片的最佳尺寸：300像素*300像素，其他尺寸会影响页面效果，格式png，jpeg，jpg，gif。大小不超过1M。最多允许上传4张</div>
						<div id="hiddenImage"></div>
						<div id="imageFile"></div>
					</div>
					<div class="modal-footer">
						<div class="col-lg-6 col-lg-offset-5">
							<button id="saveImage" class="btn btn-success" type="button">
								<strong>保存</strong>
							</button>
							<button id="close" class="btn btn-success" type="reset">
								<strong>关闭</strong>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

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
			advertInfoListData();
		});

		function advertInfoListData() {
			if (typeof oTable == 'undefined') {
				oTable = $('#advertInfoList')
						.dataTable(
								{
									'bPaginate' : true, // 翻页功能
									'sServerMethod' : 'POST', // 提交方式
									'bServerSide' : true,
									'bProcessing' : true,
									'bFilter' : false,
									"bSort" : false,
									'sAjaxSource' : contextPath
											+ '/admin/advertInfoDataTable',
									aoColumns : [
											{
												'mData' : 'id',
												'visible' : false
											},
											{
												'mData' : 'sortId',
												'sWidth' : '10%',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<input type="text" name="sortId" class="form-control" style="width:50px" value="'
															+ data + '"  disabled="disabled"/>';
													return returnValue;
												}
											},
											{
												'mData' : 'url',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<input type="text" name="url" class="form-control" value="'
															+ data+ '"/>';
													return returnValue;
												}
											},
											{
												'mData' : 'id',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<button class="btn btn-default" onclick="updateImage(this,'
															+ data
															+ ')">上传图片</button>';
													return returnValue;
												}
											},
											{
												'mData' : 'image',
												'sWidth' : '25%',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<img src="/Shopping'+data+'" style="width:300px;height:150px">';
													return returnValue;
												}
											},
											{
												'mData' : 'id',
												'sWidth' : '15%',
												'mRender' : function(data,
														type, full) {
													var returnValue = '<button id="update" class="btn btn-default btn-sm" onclick="saveAdvertInfo(this)"><i class="fa fa-pencil"></i>保存</button>&nbsp;&nbsp;<button id="del" class="btn btn-default btn-sm" onclick="delAdvertInfo('
															+ data
															+ ')"><i class="fa fa-pencil"></i>删除</button>';
													return returnValue;
												}
											} ]

								});
			} else {
				var oSettings = oTable.fnSettings();
				oSettings._iDisplayLength = parseInt($(
						'[name=advertInfoList_length] option:selected').val());
				$('.dataTables_length select')
						.val(
								$(
										'[name=advertInfoList_length] option:selected')
										.val());
				oSettings._iDisplayStart = 0;
				oTable.fnDraw();
			}
		}

		function createUpload() {
			upload = WebUploader
					.create({
						// 选完文件后，是否自动上传。
						auto : true,
						// swf文件路径
						swf : contextPath
								+ '/resources/vendor/webuploader/Uploader.swf',
						// 文件接收服务端。
						server : contextPath
								+ '/admin/newUploadfile?${_csrf.parameterName}=${_csrf.token}',

						fileNumLimit : 300,
						// 选择文件的按钮。可选。
						// 内部根据当前运行是创建，可能是input元素，也可能是flash.
						pick : '#filePicker',
						// 只允许选择图片文件。
						accept : {
							title : 'Images',
							extensions : 'gif,jpg,jpeg,bmp,png',
							mimeTypes : 'image/*'
						}
					});
			
			upload.on('uploadAccept',
							function(object, ret) {
								var hiddenImage = '<input type="hidden" name="' + object.file.id + '" value="' + ret.fileName + '" />'
								$("#hiddenImage").append(hiddenImage);
							});
			
			upload.on('fileQueued',
							function(file) {
								var $li = $('<div id="' + file.id + '" style="float:left" class="file-item thumbnail">'
										+ '<img>'
										+ '<div style="padding-top: 2px"><button class="btn btn-default btn-sm" type="button" onclick="deleteImage(this)">删除</button></div>'
										+ '</div>');
								$img = $li.find('img');
								// $list为容器jQuery实例
								$('#imageFile').append($li);
								var ratio = window.devicePixelRatio || 1;
								// 缩略图大小
								var thumbnailWidth = 150 * ratio;
								var thumbnailHeight = 150 * ratio;
								upload.makeThumb(file, function(error, src) {
									if (error) {
										$img.replaceWith('<span>不能预览</span>');
										return;
									}
									$img.attr('src', src);
								}, thumbnailWidth, thumbnailHeight);
							});
		}

		function updateImage(item, id) {
			$('#Mid').val(id);
			$("#myModal").modal('show');
		}

		$('#close').click(function() {
			clear();
		})

		$("#myModal").on("shown.bs.modal", function() {
			createUpload();
		});

		$("#myModal").on("hide.bs.modal", function() {
			upload.destroy();
		});

		function deleteImage(item) {
			for (var i = 0; i < upload.getFiles().length; i++) {
				// 将图片从上传序列移除
				if ($(item).parent().parent().find("input").val() == upload
						.getFiles()[i].id) {
					upload.removeFile(upload.getFiles()[i]);
				}
			}
			$(item).parent().parent().remove();
			$('#hiddenImage').find('input').val("");
		}

		function clear() {
			upload.destroy();
			$('#hiddenImage').empty();
			$('#imageFile').empty();
			$("#myModal").modal('hide');
		}

		$('#saveImage').click(function() {
			var Mid = $("#Mid").val();
			
			var resources = $('#hiddenImage').find('input').val();
			if (resources == null || resources == "") {
				swal("请选择图片！", "错误", "error");
				return;
			}
			if (Mid != null && Mid != "") {
				$.ajax({
					url : contextPath + '/admin/updateImage',
					type : 'POST',
					dataType : 'json',
					contentType:"application/json",
					data : JSON.stringify({
						id : Mid,
						image : resources
					}),
					success : function(data) {
						if (data.error == 0) {
							swal("图片更新成功！", "成功", "success");
							clear();
							advertInfoListData();
						} else {
							swal("图片更新失败！", "错误", "error");
							clear();
						}
					},
					error : function() {
						swal("系统异常！", "失败", "error");
						clear();
					}
				})
			} else {
				$.ajax({
					url : contextPath + '/admin/insertImage',
					type : 'POST',
					dataType : 'json',
					contentType:"application/json",
					data : JSON.stringify({
						image : resources
					}),
					success : function(data) {
						if (data.error == 0) {
							swal("图片插入成功！", "成功", "success");
							clear();
							advertInfoListData();
							$('#Aid').val(data.data);
						} else {
							swal("图片插入失败！", "错误", "error");
							clear();
						}
					},
					error : function() {
						swal("系统异常！", "失败", "error");
						clear();
					}
				})
			}
		})

		function delAdvertInfo(id) {
			$.ajax({
				url : contextPath + '/admin/deleteAdert',
				type : 'POST',
				dataType : 'json',
				contentType:"application/json",
				data : JSON.stringify({
					id : id,
				}),
				success : function(data) {
					if (data.error == 0) {
						swal("删除图片成功！", "成功", "success");
						advertInfoListData();
						$('#Aid').val('');
					} else {
						swal("删除图片失败！", "错误", "error");
					}
				},
				error : function() {
					swal("系统异常！", "失败", "error");
				}
			})
		}

		$('#creatrow').click(
						function() {
							var row = $('#advertInfoList').find('tbody').find(
									'tr').length;
							data = row % 2 == 0 ? 'even' : 'odd';
							var s = $('#advertInfoList').find('tbody').find(
									'tr');
							var $tr = '<tr role="row" class="'+data+'"><td><input type="text" name="sortId" class="form-control" style="width:50px" value=""  disabled="disabled"/></td><td><input type="text" name="url" class="form-control" value=""/></td><td><button class="btn btn-default" onclick="updateImage()">上传图片</button></td><td><img src="/Shopping" style="width:300px"></td><td><button name="update" class="btn btn-default btn-sm" onclick="saveAdvertInfo(this)"><i class="fa fa-pencil"></i>保存</button>&nbsp;&nbsp;<button id="delrow" class="btn btn-default btn-sm" onclick="delrow(this)"><i class="fa fa-pencil"></i>取消新建</button></td></tr>';
							$('#advertInfoList').find('tbody').append($tr);
						})

	
		function delrow(item) {
			$(item).parent().parent().empty();
		}
	
		function saveAdvertInfo(item) {
			var url = $(item).parent().parent().children().eq(1).find('input')
					.val();
			var id = $('#Aid').val();
			if (id != null && id != "") {
				$.ajax({
					url : contextPath + '/admin/updateUrl',
					type : 'POST',
					dataType : 'json',
					contentType:"application/json",
					data : JSON.stringify({
						id : id,
						url : url
					}),
					success : function(data) {
						if (data.error == 0) {
							swal("保存成功！", "成功", "success");
							$('#Aid').val('');
							advertInfoListData();
						} else {
							swal("保存失败！", "错误", "error");
							$('#Aid').val('');
						}
					},
					error : function() {
						swal("系统异常！", "失败", "error");
						$('#Aid').val('');
					}
				})
			} else {
				$.ajax({
					url : contextPath + '/admin/updateUrl',
					type : 'POST',
					dataType : 'json',
					contentType:"application/json",
					data : JSON.stringify({
						sortId : $(item).parent().parent().children().eq(0).find('input').val(),
						url : url
					}),
					success : function(data) {
						if (data.error == 0) {
							swal("保存成功！", "成功", "success");
							$('#Aid').val('');
							advertInfoListData();
						} else {
							swal("保存失败！", "错误", "error");
							$('#Aid').val('');
						}
					},
					error : function() {
						swal("系统异常！", "失败", "error");
						$('#Aid').val('');
					}
				})    
			}
		}
	</script>
</body>
</html>