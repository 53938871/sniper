<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="js/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="js/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="js/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="js/bootstart.js"></script>
	<script>
        Sniper.KindEditor.init('example','content1');

	</script>
</head>
<body>

	<form name="example" method="post" action="demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:900px;height:700px;visibility:hidden;"></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>