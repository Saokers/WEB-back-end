<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<body>
	<jsp:include page="../main/top.jsp" />
	<jsp:include page="../main/left.jsp" />
	<jsp:include page="../commonJs.jsp" />
	<div id="wrapper">
		<!-- Simple splash screen-->
		<div class="splash">
			<div class="color-line"></div>
		</div>
		<div class="content animate-panel">
			<div class="row">
				<div class="col-lg-12">
					<div class="hpanel">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<h4>笔记详情</h4>
								</div>
							</div>
						</div>
						<div class="panel-body p-xl">
							<div class="row m-b-xl">
								<div class="col-sm-6 col-sm-offset-3">
									<div id="myCarousel" class="carousel slide"
										data-ride="carousel" data-interval="2000">
										<!-- 轮播（Carousel）指标 -->
										<ol class="carousel-indicators">
											<c:forEach items="${note.attachment_rows_data}" var="z"
												varStatus="index">
												<li data-target="#myCarousel"
													data-slide-to="${index.index }"
													class="${index.index==0?'active':'' }"></li>
											</c:forEach>
										</ol>
										<!-- 轮播（Carousel）项目 -->
										<div class="carousel-inner">
											<c:forEach items="${note.attachment_rows_data}" var="z"
												varStatus="index">
												<div class="item ${index.index==0?'active':'' }">
													<img src="/Shopping${z.attachmentPath }" width="100%">
												</div>
											</c:forEach>
										</div>
										<!-- 轮播（Carousel）导航 -->
										<!-- Controls -->
										<a class="carousel-control left" href="#myCarousel"
											role="button" data-slide="prev"> <span
											class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
											<span class="sr-only">&lsaquo;</span>
										</a> <a class="carousel-control right" href="#myCarousel"
											role="button" data-slide="next"> <span
											class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
											<span class="sr-only">&rsaquo;</span>
										</a>
									</div>
								</div>

							</div>
							<div>
								<div class="col-md-4">
									<h5>
										笔记标签
										<c:forEach items="${note.label_rows_data}" var="z"
											varStatus="index">
											<span class="glyphicon glyphicon-tag"
												style="margin-left: 10px">${z.labelName }</span>
										</c:forEach>
									</h5>
								</div>
								<div class="col-md-4">
									<h5>
										笔记内容 <span class="glyphicon glyphicon-tag"
											style="margin-left: 10px">${note.noteContent }</span>
									</h5>
								</div>
								<div class="col-md-4">
									<h5>
										参与话题<span class="glyphicon glyphicon-tag"
											style="margin-left: 10px">${note.topicName }</span>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="right-sidebar" class="animated fadeInRight">
			<div class="text-center"></div>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>