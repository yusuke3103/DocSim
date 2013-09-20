<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="servlet.MainServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HashMap<Integer,Integer> data = (HashMap)request.getAttribute("clust_data");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<font size="2">	
<table border=0>

<%
	for(int i=0;i<MainServlet.Content.size();i++){
		if(data.get(i)==0){
%>
		<tr bgcolor="#fff8dc"><td><a href=<%=MainServlet.Url.get(i).toString() %> target=_brank><%=i+1 %>.<%=MainServlet.Title.get(i).toString() %></a><BR><%=MainServlet.Summary.get(i).toString() %></TD></TR>			
<%
		}else if(data.get(i)==1){
%>
		<tr bgcolor="#DDA0DD"><td><a href=<%=MainServlet.Url.get(i).toString() %> target=_brank><%=i+1 %>.<%=MainServlet.Title.get(i).toString() %></a><BR><%=MainServlet.Summary.get(i).toString() %></TD></TR>			
<%
		}else if(data.get(i)==2){
%>
		<tr bgcolor="#f0f8ff"><td><a href=<%=MainServlet.Url.get(i).toString() %> target=_brank><%=i+1 %>.<%=MainServlet.Title.get(i).toString() %></a><BR><%=MainServlet.Summary.get(i).toString() %></TD></TR>			
<%
		}else if(data.get(i)==3){
%>
		<tr bgcolor="#90ee90"><td><a href=<%=MainServlet.Url.get(i).toString() %> target=_brank><%=i+1 %>.<%=MainServlet.Title.get(i).toString() %></a><BR><%=MainServlet.Summary.get(i).toString() %></TD></TR>			
<%	
		}}
%>

</table>
</font>
</body>
</html>