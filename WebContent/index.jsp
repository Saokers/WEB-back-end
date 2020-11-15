<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta http-equiv="refresh" content="0;url=${root}/login">
<title>整体目录</title>
<style type="text/css">
h1 {
	margin-left: 40px;
}
</style>
</head>
<body>
	<br>
	<br>
	<h1><a href="${root}/pc/index">PC</a></h1>
	<br>
	<br>
	<h1><a href="${root}/mobile/index">Mobile</a></h1>
	<br>
	<br>
	<h1><a href="${root}/login">管理后台</a></h1>
</body>
</html>