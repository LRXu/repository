<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
</head>
<script type="text/javascript">
    
	window.onload = function() {
		
		/* 全选按钮 */
		var selectAll = document.querySelector("#selectAll");
		var selectnot = document.querySelector("#selectnot");
		var selectver = document.querySelector("#selectver");
		var select = document.querySelectorAll(".select");
		selectAll.onclick = function(){
			for(var i=0; select.length>i; i++){
				select[i].checked = true;
			}
		}
		
		selectnot.onclick = function(){
			for(var i=0; select.length>i; i++){
				select[i].checked = false;
			}
		}
		selectver.onclick = function(){
			for(var i=0; select.length>i; i++){
				select[i].checked = !select[i].checked;
			}
		}
	}
	
	/* ajax发送请求 */
	function sendjson() {
		
		var name = document.querySelector("#name1").value;
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/products/sendjson",
			contentType : "application/json;charset=utf-8",
			data : '{"name":"'+name+'","price":8000.9}',
			success : function(data) {
				alert(data);
			}
		});
	}
</script>

<body> 
<form action="${pageContext.request.contextPath }/products/query" method="post">
<table width="100%" border=1>
<tr>
<td>查询条件：商品名:<input type="text" name="product.name"> 
商品价格:<input type="text" name="product.price" id="name"></td>
</tr>
<tr>
<td><input type="submit" value="查询" name="action"/> 
    <input type="submit" value="删除" name="action"/>
    <input type="submit" value="修改" name="action"/>
    <input type="button" value="发送json数据" onclick="sendjson()"></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
    <td><input type="button" id="selectAll" value="全选"/>
    <input type="button" id="selectnot" value="全不选"/>
    <input type="button" id="selectver" value="反选"/></td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${productList }" var="item" varStatus="status">
<tr>
    <td><input type="checkbox" name="ids" class="select" value="${item.id }"/>
    <input type="hidden" name="products[${status.index }].id" value="${item.id }"></td>
	<td><input type="text" name="products[${status.index }].name" value="${item.name }" id="name1"/></td>
	<td><input type="text" name="products[${status.index }].price" value="${item.price }"/></td>
	<td><input type="text" name="products[${status.index }].createtime" 
	value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
	<td><input type="text" name="products[${status.index }].detail" value="${item.detail }"/></td>
	
	<td><a href="${pageContext.request.contextPath }/products/itemEdit/${item.id }">修改</a></td>

</tr>
</c:forEach>

</table>
</form>


</body>

</html>