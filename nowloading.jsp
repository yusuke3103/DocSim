<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<div id="loaderImage"></div>
<script type="text/javascript" src="canvas.js"></script>
<script type="text/javascript">
	var cSpeed=9;
	var cWidth=128;
	var cHeight=128;
	var cTotalFrames=24;
	var cFrameWidth=128;
	var cImageSrc='images/sprites.gif';
	
	var cImageTimeout=false;

	
	function startAnimation(){
		
		document.getElementById('loaderImage').innerHTML='<canvas id="canvas" width="'+cWidth+'" height="'+cHeight+'"><p>Your browser does not support the canvas element.</p></canvas>';
		
		//FPS = Math.round(100/(maxSpeed+2-speed));
		FPS = Math.round(100/cSpeed);
		SECONDS_BETWEEN_FRAMES = 1 / FPS;
		g_GameObjectManager = null;
		g_run=genImage;

		g_run.width=cTotalFrames*cFrameWidth;
		genImage.onload=function (){cImageTimeout=setTimeout(fun, 0)};
		initCanvas();
	}
	
	
	function imageLoader(s, fun)//Pre-loads the sprites image
	{
		clearTimeout(cImageTimeout);
		cImageTimeout=0;
		genImage = new Image();
		genImage.onload=function (){cImageTimeout=setTimeout(fun, 0)};
		genImage.onerror=new Function('alert(\'Could not load the image\')');
		genImage.src=s;
	}
	
	//The following code starts the animation
	new imageLoader(cImageSrc, 'startAnimation()');
	
	function Search(){
		parent.left.location.href="./left.jsp";
		document.Search.submit();
	}
</script>
</head>
<body onLoad="Search()">
<form name="Search" action="MainServlet" method="POST" target="right">
	<input type="hidden" name=Keyword value=<%=request.getParameter("keyword") %>>
</form>
</body>
</html>