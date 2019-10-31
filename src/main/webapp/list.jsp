<%@page import="com.qfedu.pojo.Employee"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
	</head>

	<body>
		<div>
			<h3>所有员工信息</h3>
			<a href="add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>

				
			<tbody id="tid"></tbody>
			</table>
		</div>

	<script type="text/javascript">
		$(function(){
			loadData(1);
		})

	 function loadData (page) {
			$.ajax({
				type:"get",
				url:"ssm/page.do?page="+ page +" &size=5",
				dataType:"json",

				success:function (data) {

						if(data.code==1){
							$("#tid").empty();
						  var infos = data.info.pageList;

						$(infos).each(function(){
						var html = '<tr>\n' +
								'\t\t\t\t\t<td>' + this.id + '</td>\n' +
								'\t\t\t\t\t<td>' + this.name + '</td>\n' +
								'\t\t\t\t\t<td>' + this.sex + '</td>\n' +
								'\t\t\t\t\t<td>' + this.age + '</td>\n' +
								'\t\t\t\t\t<td>' + this.phone + '</td>\n' +
								'\t\t\t\t\t<td>\n' +
								'\t\t\t\t\t\t<a href="update.jsp?id= '+this.id+'">修改</a>&nbsp;\n' +
								'\t\t\t\t\t\t<a href="javascript:del('+this.id+')">删除</a>\n' +
								'\t\t\t\t\t</td>\n' +
								'\t\t\t\t</tr>';
						// append 追加数据
						// $(html) 创建dom对象
						$("#tid").append($(html));
						})
						var html = '<tr><td colspan="6"><a href="javascript:loadData(1)">首页</a>&nbsp;' +
								'<a href="javascript:loadData(' + (data.info.currentPage - 1) + ')">上一页</a>&nbsp;' +
								'<a href="javascript:loadData(' + (data.info.currentPage + 1) + ')">下一页</a>&nbsp;' +
								'<a href="javascript:loadData(' + data.info.totalPage + ')">末页</a></td></tr>';
						$("#tid").append($(html));
						}
				}

		})
		}
	</script>
	<script type="text/javascript">
		function del(id) {
			$.ajax({
				type:"get",
				url:"ssm/del.do?id="+ id,
				dateType:"json",
				success:function (data) {
					if(data.code==1){
						loadData();

					}else{
						alert(data.info);
					}
				}

			})
		}
	</script>
	</body>

</html>