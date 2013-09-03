<%@page import="org.apache.jsp.right_jsp"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="flags.Access" %>
<%@ page import="servlet.MainServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table border=0>
<%
	for(int i=0;i<MainServlet.Url.size();i++){
		
	}
%>
	

</table>
<%
	for (int i=0;i<MainServlet.Url.size();i++){
%>

<font size="1">
		<a href=<%=MainServlet.Url.get(i).toString() %> target=_brank><%=i+1 %>.<%=MainServlet.Title.get(i).toString() %></a>
		<br>
		<%=MainServlet.Summary.get(i).toString() %>
</font>
		<hr>
<%
	}
%>
</body>
</html>