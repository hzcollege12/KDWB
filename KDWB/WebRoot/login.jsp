<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">   
<script type="text/javascript" src="easyui/jquery-1.9.1.min.js"></script>   
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/plugins/jquery.datagrid.js"></script>
</head>
<body>
<div id="dd" class="easyui-dialog" title="登录界面" style="width:400px;height:200px;margin: 0 auto;"   
        data-options="modal:true,buttons:'#bb',closable:false">   
        <div style="height: 50px;width: 300px;margin-top: 30px;margin-left:80px;">
 			<table>
 				<tr>
 					<td><b>用户名：</b></td>
 					<td><input type="text" name="username"/></td>
 				</tr>
 				<tr>
 					<td><b>密码：</b></td>
 					<td><input type="text" name="password"/></td>
 				</tr>
 			</table>
 		
    	</div>
    	</div>
	<div id="bb">
	<a href="#" class="easyui-linkbutton">登录</a>
	<a href="#" class="easyui-linkbutton">注册</a>
	</div>


    	
</div>  
</body>
</html>