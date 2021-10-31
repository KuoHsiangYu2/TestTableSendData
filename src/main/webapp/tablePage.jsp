<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- setting favicon.ico -->
<link rel="icon" href="favicon.ico" type="image/x-icon">
<title>tablePage.jsp</title>
</head>
<body>
	<p>tablePage</p>
	<button id="send-data-button-id">送出勾選資料</button>
	&nbsp;&nbsp;
	<button id="clear-checkbox-button-id">清空checkbox</button>
	<br />
	<br />
	<table id="customer-table-id" border="1" cellspacing="0" cellpadding="2">
		<thead>
			<tr>
				<th width="1%">
					<input id="all-checkbox-id" type="checkbox" />
				</th>
				<th>編號</th>
				<th>伺服器</th>
				<th>角色名稱</th>
				<th>Facebook名稱</th>
				<th>等級</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerBeanList}" var="unit" varStatus="unitStatus">
				<tr align="center">
					<td width="1%">
						<input type="checkbox" name="selectCheckbox" value="${unit.getId()}" />
					</td>
					<td>${unit.getId()}</td>
					<td>
						<input value="${unit.getServerName()}" />
					</td>
					<td>
						<input value="${unit.getRoleName()}" />
					</td>
					<td>
						<input value="${unit.getFacebookName()}" />
					</td>
					<td>
						<select id="select-id-${unitStatus.index}">
							<option value="">請選擇</option>
							<option value="level-1">level 1</option>
							<option value="level-2">level 2</option>
							<option value="level-3">level 3</option>
							<option value="level-4">level 4</option>
							<option value="level-5">level 5</option>
						</select>
						<script type="text/javascript">
							/* 設定下拉式選單預設選到到使用者之前選中的項目 */
							var optionUnit = document.getElementById("select-id-${unitStatus.index}");
							optionUnit.value = String("${unit.getLevel()}").toString();
						</script>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	pageContext.request.contextPath&nbsp;=&nbsp;${pageContext.request.contextPath}
	<br />
	<br />
	<a href="${pageContext.request.contextPath}">返回首頁</a>
	<br />

	<div id="table-page-div"></div>

	<script type="text/javascript">
		(function() {
			const tablePageDiv = document.getElementById('table-page-div');
			tablePageDiv.requestContextPath = String("${pageContext.request.contextPath}").toString();
		})();
	</script>
	<script type="text/javascript" src="./js/tablePage.js"></script>
</body>
</html>

<!--
Windows電腦：
  Visual Studio Code
    多行文字選取：Ctrl + Alt + 上
    迅速複製貼上一行程式碼：Alt + Shift + 下
    程式碼排版：Alt + SHift + F
-->