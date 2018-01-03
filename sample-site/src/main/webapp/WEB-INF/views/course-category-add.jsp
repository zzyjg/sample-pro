<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

				<fieldset>
					<legend>增加课程分类</legend>
					<form:form class="form-horizontal" modelAttribute="model"
						method="post"
						action="${pageContext.request.contextPath }/course-category/add">
						<div class="form-group">
							<form:label path="name" cssClass="col-sm-2 control-label">名称</form:label>
							<div class="col-sm-10">
								<form:input path="name" type="txt" class="form-control"
									placeholder="分类名称" />
								<form:errors path="name" cssClass="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<form:label path="sort" cssClass="col-sm-2 control-label">排序</form:label>
							<div class="col-sm-10">
								<form:input path="sort" type="number" class="form-control"
									placeholder="排序号" />

								<form:errors path="sort" cssClass="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">

								<div class="checkbox">
									<label> <form:checkbox path="status" /> 有效

									</label>
									<form:errors path="status" cssClass="error"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">

								<form:errors path="error"></form:errors>
								<button type="submit" class="btn btn-default">保存</button>
							</div>
						</div>
					</form:form>
				</fieldset>



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
	<script type="text/javascript">
		$(function() {
			$("form input").change(function() {
				$(this).siblings(".error").remove();
			});

		});
	</script>
</body>
</html>