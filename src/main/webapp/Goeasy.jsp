<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="./js/echarts.min.js"></script>
    <%--<script type="text/javascript" src="./js/china.js"></script>--%>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

</head>
<body>
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>
<script type="text/javascript">


    var myChart = echarts.init(document.getElementById('statistics_main'));
    var option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: []
    };
    myChart.setOption(option);

    var goEasy = new GoEasy({
        appkey: "BC-b8fd397f277f4f1082af3fa510203e2d"
    });
    goEasy.subscribe({
        channel: "my_channel",
        onMessage: function (message) {
          //  console.log($.parseJSON(message.content).datalist);
            myChart.setOption({
                series: [{
                    data: $.parseJSON(message.content).datalist,
                    type: 'line'
                }]
            });

        }
    });


</script>
</body>
</html>
