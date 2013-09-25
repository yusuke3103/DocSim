<%@page import="java.util.ArrayList"%>
<%
	int total_amount = (Integer)request.getAttribute("Size");
	ArrayList<Integer> clust0 = (ArrayList)request.getAttribute("clust0");
	ArrayList<Integer> clust1 = (ArrayList)request.getAttribute("clust1");
	ArrayList<Integer> clust2 = (ArrayList)request.getAttribute("clust2");
	ArrayList<Integer> clust3 = (ArrayList)request.getAttribute("clust3");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="./BubbleTree/jslib/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="./BubbleTree/jslib/jquery.history.js"></script>
<script type="text/javascript" src="./BubbleTree/jslib/raphael.js"></script>
<script type="text/javascript" src="./BubbleTree/jslib/vis4.js"></script>
<script type="text/javascript" src="./BubbleTree/jslib/Tween.js"></script>
<script type="text/javascript" src="./BubbleTree/build/bubbletree.js"></script>
<link rel="stylesheet" type="text/css" href="./BubbleTree/build/bubbletree.css" />
<script type="text/javascript" src="./BubbleTree/styles/cofog.js"></script>

<script type="text/javascript">
		function filtering(){
			parent.left.location.href="Filter";
		}
        $(function() {


            var data = {
                label: 'Center',
                amount: <%=total_amount %>,
                children: [
                    { label: '1st', amount: <%=clust0.size()%>, color: '#fff8dc',
                        children: [
                        <%for (int x=0;x<clust0.size();x++){ 
                        	if(x+1!=clust0.size()){%>
                        { label: '<%=clust0.get(x)+1%>', amount: 1,color:'#fff8dc'},
                        <%}else if(x+1==clust0.size()){%>
                        { label: '<%=clust0.get(x)+1%>', amount: 1,color:'#fff8dc'}
                        <%}}%>
                    ] },
                    { label: '2nd', amount: <%=clust1.size()%>, color: '#dda0dd',
                        children: [
                        <%for (int x=0;x<clust1.size();x++){ 
                        	if(x+1!=clust1.size()){%>
                        { label: '<%=clust1.get(x)+1%>', amount: 1,color:'#dda0dd'},
                        <%}else if(x+1==clust1.size()){%>
                        { label: '<%=clust1.get(x)+1%>', amount: 1,color:'#dda0dd'}
                        <%}}%>
                    ] },
                    { label: '3rd', amount: <%=clust2.size()%>, color: '#f0f8ff',
                        children: [
                        <%for (int x=0;x<clust2.size();x++){ 
                        	if(x+1!=clust2.size()){%>
                        { label: '<%=clust2.get(x)+1%>', amount: 1,color:'#f0f8ff'},
                        <%}else if(x+1==clust2.size()){%>
                        { label: '<%=clust2.get(x)+1%>', amount: 1,color:'#f0f8ff'}
                        <%}}%>
                    ] },
                    { label: '4th', amount: <%=clust3.size()%>, color: '#90ee90',
                        children: [
                        <%for (int x=0;x<clust3.size();x++){ 
                        	if(x+1!=clust3.size()){%>
                        { label: '<%=clust3.get(x)+1%>', amount: 1,color:'#90ee90'},
                        <%}else if(x+1==clust1.size()){%>
                        { label: '<%=clust3.get(x)+1%>', amount: 1,color:'#90ee90'}
                        <%}}%>
                    ]
                    }
                ]
            };

            new BubbleTree({
                data: data,
                bubbleType: 'icon',
                container: '.bubbletree'
            });

        });

    </script>
</head>
<body onLoad="filtering();">
<form name=filter action="Filter" method="get" target="left">
<input id=co name=col type="hidden" value=#99999>
</form>
	<!-- <div class="bubbletree-wrapper">-->
		<div class="bubbletree"></div>
	</div>
</body>
</html>

