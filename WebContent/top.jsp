<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function check(){
	var flag = 0;
	if(document.setKeyword.Keyword.value==""){
		flag=1;
	}

	if(flag){
		window.alert("キーワードが入力されていません");
		return false;
	}else{
		parent.left.location.href="./left.jsp";
		return true;
	}
}
</script>
<meta http-equiv="Contnt-Type" Content="text/html; charset=UTF-8">
</head>
<body>
	<form action="MainServlet" target="right" method="post" name="setKeyword"
		onsubmit="return check()">
		<table>
			<tr>
				<td><input type="text" name=Keyword></td>
				<td><input type="submit" value="検索"></td>
			</tr>
		</table>
	</form>
</body>
</html>