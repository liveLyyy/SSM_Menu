<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript" src="static/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.post("show",function (data) {
            var result="";
            for (var i=0;i<data.length;i++){
                result+="<dl>";
                result+="<dt style='cursor: pointer'>"+data[i].name+"</dt>";
                for (var j=0;j<data[i].childre.length;j++){
                    result+="<dd>"+data[i].childre[j].name+"</dd>";
                }
                result+="</dl>";
            }
            $("body").html(result);
        });
        setTimeout(function () {
            $("dt").on("click",function () {
               $(this).siblings().slideToggle(100);
            });
        },1000)

    });
</script>
<body>
</body>
</html>
