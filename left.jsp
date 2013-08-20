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
<%
	boolean go = false;
	Access.setGoF();
	//long start = System.currentTimeMillis();
	while (go!=true){
		go = Access.getGo();
		try{
			Thread.sleep(10);
		}catch (InterruptedException e){}
		//System.err.println(go);
	}
	//long stop = System.currentTimeMillis();
	//long times = (stop-start)/1000;
	System.out.println("検索終了");

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