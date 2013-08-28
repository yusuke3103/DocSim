<%@page import="java.util.ArrayList"%>
<%
	int total_amount = (Integer)request.getAttribute("Size");
	ArrayList<Integer> clust0 = (ArrayList)request.getAttribute("clust0");
	ArrayList<Integer> clust1 = (ArrayList)request.getAttribute("clust1");
	ArrayList<Integer> clust2 = (ArrayList)request.getAttribute("clust2");
	ArrayList<Integer> clust3 = (ArrayList)request.getAttribute("clust3");
	System.out.println(clust0);
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

        $(function() {


            var data = {
                label: 'Center',
                amount: <%=total_amount %>,
                children: [
                    { label: '1st', amount: <%=clust0.size()%>, color: '#D95F02',
                        children: [
                        <%for (int x=0;x<clust0.size();x++){ 
                        	if(x+1!=clust0.size()){%>
                        { label: '<%=clust0.get(x)%>', amount: 1,color:'#D95F02'},
                        <%}else if(x+1==clust0.size()){%>
                        { label: '<%=clust0.get(x)%>', amount: 1,color:'#D95F02'}
                        <%}}%>
                    ] },
                    { label: '2nd', amount: <%=clust1.size()%>, color: '#dda0dd',
                        children: [
                        <%for (int x=0;x<clust1.size();x++){ 
                        	if(x+1!=clust1.size()){%>
                        { label: '<%=clust1.get(x)%>', amount: 1,color:'#dda0dd'},
                        <%}else if(x+1==clust1.size()){%>
                        { label: '<%=clust1.get(x)%>', amount: 1,color:'#dda0dd'}
                        <%}}%>
                    ] },
                    { label: '3rd', amount: <%=clust3.size()%>, color: '#00ff00',
                        children: [
                        <%for (int x=0;x<clust3.size();x++){ 
                        	if(x+1!=clust3.size()){%>
                        { label: '<%=clust3.get(x)%>', amount: 1,color:'#00ff00'},
                        <%}else if(x+1==clust1.size()){%>
                        { label: '<%=clust3.get(x)%>', amount: 1,color:'#00ff00'}
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
<body>
	<div class="bubbletree-wrapper">
		<div class="bubbletree"></div>
	</div>
</body>
</html>

