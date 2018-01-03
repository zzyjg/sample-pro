<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程分类</title>

<link rel="stylesheet"
	href="<c:url value='/asserts/libs/bootstrap-3.3.7/css/bootstrap.css'></c:url>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/asserts/libs/bootstrap-table/bootstrap-table.css'></c:url>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/asserts/custom/index.css'></c:url>"
	type="text/css">

<script type="text/javascript">
	var basePath = "<c:url value='/'></c:url>"
</script>

</head>
<body>
	<div class="main container-fluid">


		<div class="row-fluid">
			<div class="col-xs-2">
				<ul class="nav nav-list">
					<li class="active"><a
						href="<c:url value='/course-category'></c:url>">课程分类</a></li>
					<li><a href="<c:url value='/course'></c:url>">课程</a></li>
				</ul>
			</div>


			<div class="col-xs-10">
				<div id="toolbar">
					<button id="add" class="btn btn-primary">
						<i class="glyphicon glyphicon-plus"></i> 增加
					</button>
				</div>
				<table class="table" id="data">

				</table>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="<c:url value='/asserts/libs/jquery-2.1.4/jquery.js'></c:url>"></script>
	<script type="text/javascript"
		src="<c:url value='/asserts/libs/bootstrap-3.3.7/js/bootstrap.js'></c:url>"></script>
	<script type="text/javascript"
		src="<c:url value='/asserts/libs/layer-v3.1.0/layer.js'></c:url>"></script>
	<script type="text/javascript"
		src="<c:url value='/asserts/libs/bootstrap-table/bootstrap-table.js'></c:url>"></script>
	<script type="text/javascript"
		src="<c:url value='/asserts/libs/bootstrap-table/locale/bootstrap-table-zh-CN.js'></c:url>"></script>
	<script type="text/javascript"
		src="<c:url value='/asserts/custom/course-category.js'></c:url>"></script>








</body>
</html>