<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Enrollment Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
   <jsp:include page="kindEditorLib.jsp"/>
</head>

<body>
   <div style="width: 100%;">
 	<div class="form-container" style="width: 95%">
 	
 	<h1>新增文章</h1>
 	
	<form:form method="POST" modelAttribute="article" class="form-horizontal" action="article/add" name="articleForm">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="title">标 题</label>
				<div class="col-md-7">
					<form:input type="text" path="title" id="title" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="title" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="icon">图 标</label>
				<div class="col-md-7">
					<form:input type="text" path="icon" id="icon" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="icon" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="desc">简 介</label>
				<div class="col-md-7">
					<form:input type="text" path="desc" id="desc" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="desc" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="source">来 源</label>
				<div class="col-md-7">
					<form:input type="text" path="source" id="source" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="source" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
        <%--
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="category">分 类</label>
				<div class="col-md-7">
					<form:select path="category" id="category" class="form-control input-sm">
						<form:option value="">选择分类</form:option>
						<form:options items="${categories}" />
					</form:select>
					<div class="has-error">
						<form:errors path="category" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
	    --%>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="status">状 态</label>
				<div class="col-md-7" class="form-control input-sm">
					<form:radiobutton path="status" value="0" />等待
	    			<form:radiobutton path="status" value="1" />发布
					<div class="has-error">
						<form:errors path="status" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="content">内 容</label>
				<div class="col-md-7">
					<form:textarea path="content" class="form-control input-sm" cols="100" rows="8" style="width:654px;height:300px;visibility:hidden;"/>
					<div class="has-error">
						<form:errors path="content" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="保存" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</div>
	<script>
		Sniper.KindEditor.init('articleForm','content');
	</script>

</body>
</html>