<%@page import="com.qfedu.pojo.Employee"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>修改信息</title>
		<style type="text/css">
			table {
				width: 300px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 300px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
	</head>

	<body>
		<div>
			<h3>修改员工信息</h3>
			
			<form action="查询所有.html" method="post" onsubmit="return false;">
				<table border="1">
					<tr>
						<th>姓名</th>
						<td><input type="text" name="name" value="${emp.name }" /></td>
					</tr>
					<tr>
						<th>性别</th>
						
							<td>
								<input type="radio" name="sex" value="男" <c:if test="${emp.sex == '男' }"> checked="checked"</c:if> />男
								<input type="radio" name="sex" value="女" <c:if test="${emp.sex == '女' }"> checked="checked"</c:if> />女
							</td>
					
						
					</tr>
					<tr>
						<th>年龄</th>
						<td><input type="text" name="age" value="${emp.age }" /></td>
					</tr>
					<tr>
						<th>手机</th>
						<td><input type="text" name="phone" value="${emp.phone }" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" />&nbsp;
							<input type="reset" value="重置" /></td>
					</tr>
				</table>
			</form>
		</div>
		<script type="text/javascript">

			$ (function () {
				$.ajax({
					type:"get",
					url:"ssm/find.do?id=${param.id}",
					dateType:"json",
					success:function (data) {
						if(data.code==1){
							var emp=data.info;
							$("input[name='name']").val(emp.name);
							$("input[name='age']").val(emp.age);
							$("input[name='phone']").val(emp.phone);
							if (emp.sex=='男'){
								$("input[value='男']").attr("checked", "checked");
							}else {
								$("input[value='女']").attr("checked", "checked");
							}

							}else {
							alert(data.info);
						}

							}

				})
			})
		</script>
		<script type="text/javascript">

			$ ("form").submit (function() {
				$.ajax({
					type:"post",
					url:"ssm/upd.do" + window.location.search,
					data:$("form").serialize(),
					dataType:"json",
					success:function (data) {
						if (data.code==1){
							window.location.href = "list.jsp";
						}else {
							alert(data.info);
						}
					}
				})
			})
		</script>
	</body>

</html>