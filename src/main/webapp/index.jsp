<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- setting favicon.ico -->
<link rel="icon" href="favicon.ico" type="image/x-icon">
<title>index.jsp</title>
<link rel="stylesheet" href="./style/index.css">
</head>

<body>
	<section>
		<div class="text-center">
			<h2>index首頁</h2>
			<div class="data-wrap">
				<form action="${pageContext.request.contextPath}/TablePage" method="POST" enctype="application/x-www-form-urlencoded">
					<div id="display-box-id">
						<input id="submit-buton-id" type="submit" value="進入第二頁" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>

</html>

<!-- https://muki.tw/tech/css-div-center/ -->
<!-- https://codepen.io/mukiwu/pen/Iuncz -->
<!-- https://www.wibibi.com/info.php?tid=147 -->
<!-- https://smlpoints.com/notes-css-vertical-horizontal-align-method-collection.html -->
