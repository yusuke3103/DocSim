<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                label: '神戸情報大学院大学',
                amount: 20,
                children: [
                    { label: '1st', amount: 10, color: '#D95F02',
                        children: [
                        { label: '13', amount: 1, color: '#D95F02' },
                        { label: '11', amount: 1, color: '#D95F02' },
                        { label: '17', amount: 1, color: '#D95F02' },
                        { label: '25', amount: 1, color: '#D95F02' },
                        { label: '15', amount: 1, color: '#D95F02' },
                        { label: '12', amount: 1, color: '#D95F02' },
                        { label: '14', amount: 1, color: '#D95F02' },
                        { label: '18', amount: 1, color: '#D95F02' },
                        { label: '19', amount: 1, color: '#D95F02' },
                        { label: '20', amount: 1, color: '#D95F02' },

                    ] },
                    { label: '神戸', amount: 2, color: '#1B9E77',
                        children: [
                        { label: '1', amount: 1, color: '#1B9E77' },
                        { label: '5', amount: 1, color: '#1B9E77' }
                    ]
                    },
                    { label: '情報', amount: 2, color: '#7570B3',
                        children: [
                        { label: '2', amount: 5, color: '#7570B3' },
                        { label: '3', amount: 8, color: '#7570B3'}
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
