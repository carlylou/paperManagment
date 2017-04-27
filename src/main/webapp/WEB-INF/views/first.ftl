<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<p> This is the navigation page! </p>


<!--这里显示最近读的文章-->
<p>Recent papers</p>



<!--这里上传新的论文-->
<p>Add more papers</p>
<form action="/papers/add">
    Paper's path: <input type="text" id = "paperPath" name = "paperPath">
    <input type="submit" value="Submit">
</form>


<!--这里显示文章计划-->
<p>Show plan</p>
<form action="/papers/plan">
    <input type="submit" value="Submit">
</form>

</body>
</html>